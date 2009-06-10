/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import java.io.IOException;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections15.*;
import facade.functors.StringConcatenator;
import static facade.Collections.*;
import static facade.IO.*;
/**
 *
 * @author falcone
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            file("/tmp/machin.txt").ifExists().delete();
            file("machin.txt").blank().append("MACHIN").append("======").moveTo("/tmp/");
            Iterator<String> it = file("/tmp/machin.txt").lineIterator();
            while( it.hasNext() ) {
                System.out.println( it.next() );
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
