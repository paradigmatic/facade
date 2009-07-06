/*  
 * This file is part of Facade
 *
 *  Facade is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Facade is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  (c) 2009, Jean-Luc Falcone, jean-luc.falcone@unige.ch
 *
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.io;

import java.io.*;
import java.nio.channels.*;
import java.util.List;
/**
 *
 * @author falcone
 */
public class BasicFileProxy implements FileProxy {

    private File file;

    public BasicFileProxy( File f ) {
        if( f.isFile() ) {
            file = f;
        } else {
            throw new IllegalArgumentException( "File " + f + " is not a regular file (directory ?).");
        }
    }

    public BasicFileProxy( String filename ) {
        this( new File( filename ) );
    }


   // WARNING: should read the whole file...
    public FileIterator lineIterator() throws IOException {
        return new FileIterator( file );
    }

    public FileProxy append(String s) throws IOException {
        PrintWriter pw = new PrintWriter( new FileOutputStream(file, true));
        pw.println(s);
        pw.close();
        return this;
    }

    /*
     * If the file exists exception
     */
    public FileProxy create() throws IOException {
        if( file.exists() ) {
            throw newIOException( "File", "already exists.");
        }
        file.createNewFile();
        return this;
    }

    /**
     * if the file do not exist, does nothing.
     * @return
     * @throws java.io.IOException
     */
    public FileProxy delete() throws IOException {
        if( ! file.delete() ) {
            throw newIOException( "File", "could not be deleted because is not empty" );
        }
        return this;
    }

    /**
     * Copy first then delete.
     * @param path
     * @return
     * @throws java.io.IOException
     */
    public FileProxy moveTo( String path ) throws IOException {
        FileProxy next = copyTo( path );
        delete();
        return next;
    }

    public FileProxy copyTo(String path) throws IOException {
      File copy = new File( path );
      if( copy.isDirectory() ) {
          copy = new File( path + file.separator + file.getName() );
      }
      if( copy.exists() ) {
          throw new IOException("Destination " + copy.getAbsolutePath() + " already exists.");
      }
      FileChannel in = new FileInputStream( file ).getChannel();
      FileChannel out = new FileOutputStream( copy ).getChannel();
      in.transferTo(0, file.length(), out);
      in.close();
      out.close();
      return new BasicFileProxy( copy );
    }



    private IOException newIOException( String prefix, String suffix ) {
        return new IOException( prefix + " " + file.getName() + " " + suffix );
    }

    public FileProxy blank() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<String> lines() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
