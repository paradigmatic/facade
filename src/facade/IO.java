/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import facade.io.BasicFileProxy;
import facade.io.FileProxy;
import java.io.*;
/**
 *
 * @author falcone
 */
public class IO {

    public static FileProxy file( String filename ) {
        return new BasicFileProxy(filename);
    }
    
    public static FileProxy file( File file ) {
        return new BasicFileProxy(file);
    }
}
