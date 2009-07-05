/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import facade.strings.BasicStringProxy;
import facade.strings.StringProxy;

/**
 *
 * @author falcone
 */
public class Strings {

    /**
     * Wraps a string in a StringProxy
     * @param str The string to be wrapped
     * @return A wrapping StringProxy
     */
    static public StringProxy string( String str ) {
        return new BasicStringProxy( str );
    }

}
