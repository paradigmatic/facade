
package facade.collections;

import java.util.Collection;
import java.util.Iterator;


/**
 * Common methods for collections manipulations.
 * @since 0.1.0
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
