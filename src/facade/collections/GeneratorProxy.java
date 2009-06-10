/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.collections;

import org.apache.commons.collections15.*;
import java.util.*;
import facade.functors.Generator;

/**
 *
 * @author falcone
 */
public class GeneratorProxy<T> {

    private Factory<T> factory;
    private List<Predicate<T>> predicates;
    private int taking;
    static private final int UNDEFINED = -1;

    public GeneratorProxy(Factory<T> factory) {
        this.factory = factory;
        predicates = new ArrayList< Predicate<T> >();
        taking = UNDEFINED;
    }

    public GeneratorProxy<T> suchAs( Predicate<T> predicate ) {
        predicates.add(predicate);
        return this;
    }

    public GeneratorProxy<T> and( Predicate<T> predicate ) {
        return suchAs(predicate);
    }

    public Generator<T> takingTheFirst( int n ) {
        if( n<0 ) {
            throw new IllegalArgumentException("Cannot generate an negative number of elements");
        }
        taking = n;
        return new BasicGenerator<T>( factory, predicates, taking );
    }

}
