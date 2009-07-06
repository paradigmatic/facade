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
import java.util.List;

/**
 *
 * @author falcone
 */
public interface FileProxy {

    public FileIterator lineIterator() throws IOException;
    public List<String> lines() throws IOException;
    public FileProxy append( String s ) throws IOException;
    public FileProxy create() throws IOException;
    public FileProxy delete() throws IOException;
    public FileProxy blank() throws IOException;
    public FileProxy moveTo( String path ) throws IOException;
    public FileProxy copyTo( String path ) throws IOException;

}
