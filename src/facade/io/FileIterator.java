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
import java.util.*;

/**
 *
 * @author falcone
 */
public class FileIterator implements Iterator<String> {

    private static class EmptyFileItertor extends FileIterator {

        private EmptyFileItertor() throws FileNotFoundException {
            super(null);
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }
    }

    private static EmptyFileItertor emptyIterator;

    protected static FileIterator emptyFileIterator() {
        if( emptyIterator == null ) {
            try {
                emptyIterator = new EmptyFileItertor();
            } catch (FileNotFoundException e) {}
        }
        return emptyIterator;
    }

    private BufferedReader reader;
    private String line;

    public FileIterator(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
        line = nextLine();
    }

    public boolean hasNext() {
        if (line == null) {
            try {
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return false;
        }
        return true;
    }

    public String next() {
        String oldLine = line;
        line = nextLine();
        return oldLine;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }

    private String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void close() {
        reader.close();
    }
}
