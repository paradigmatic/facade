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
public class BasicGenerator<T> implements Generator<T> {

    private Factory<T> factory;
    private List<Predicate<T>> predicates;
    private int taking;
    private int nextOne;

    public BasicGenerator(Factory<T> factory, List<Predicate<T>> predicates, int taking){
        this.factory = factory;
        this.predicates = predicates;
        this.taking = taking;
        nextOne = 0;
    }

    public boolean hasNext() {
        return nextOne < taking;
    }

    public T next() {
        T t = factory.create();
        if( evaluatePredicatesOn(t) ) {
            nextOne++;
            return t;
        } else {
            return next();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private boolean evaluatePredicatesOn( T t ) {
        if( predicates.isEmpty() ) {
            return true;
        }
        for( Predicate<T> pred: predicates ) {
            if( ! pred.evaluate(t) ) {
                return false;
            }
        }
        return true;
    }

    public void fill(Collection<T> collection) {
        for( T t: this ) {
            collection.add( t );
        }
    }

    public Iterator<T> iterator() {
        return this;
    }


}
