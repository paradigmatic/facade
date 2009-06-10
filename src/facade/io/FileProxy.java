/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.io;

import java.util.*;
import java.io.*;

/**
 *
 * @author falcone
 */
public interface FileProxy {

    public boolean isDirectory();
    public FileIterator lineIterator() throws IOException;
    public FileProxy append( String s ) throws IOException;
    public FileProxy create() throws IOException;
    public FileProxy delete() throws IOException;
    public FileProxy blank() throws IOException;
    public FileProxy moveTo( String path ) throws IOException;
    public FileProxy copyTo( String path ) throws IOException;
    public FileProxy ifExists();
    public FileProxy unlessExists();
}
