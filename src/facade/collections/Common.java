/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.collections;

import java.util.Collection;
import java.util.Iterator;


/**
 * Common methods for collections manipulations.
 * @author falcone
 */
public class Common {

    protected static <T> String join( Collection<T> collection, String separator ) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = collection.iterator();
        if( it.hasNext() ) {
            sb.append( it.next() );
        }
        while( it.hasNext() ) {
            sb.append( separator ).append( it.next() );
        }
        return sb.toString();
    }

}
