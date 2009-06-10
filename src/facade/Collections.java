/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import facade.collections.*;
import java.util.*;
/**
 *
 * @author falcone
 */
public class Collections {

    public static <T> CollectionProxy<T> with( Collection<T> collection ) {
        return new CollectionSafeProxy<T>( collection );
    }

    public static <T> CollectionProxy<T> on( Collection<T> collection ) {
        return new CollectionInPlaceProxy<T>( collection );
    }

}
