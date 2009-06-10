/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.collections;

import facade.functors.*;
import facade.functors.Generator;
import facade.functors.Reducer;
import org.apache.commons.collections15.functors.*;
import org.apache.commons.collections15.*;
import java.util.*;

/**
 *
 * @author falcone
 */
public class CollectionInPlaceProxy<T> implements CollectionProxy<T> {

   private Collection<T> collection;

    public CollectionInPlaceProxy( Collection<T> collection ) {
        //TODO: check if an empty public constructor exists
        this.collection = collection;
    }

    public CollectionProxy<T> add(T t) {
        collection.add(t);
        return this;
    }

    public CollectionProxy addAll(Collection<T> otherCollection) {
        collection.addAll( otherCollection );
        return this;
    }

    public CollectionProxy<T> apply(Closure<T> closure) {
        for( T t: collection ) {
            closure.execute(t);
        }
        return this;
      }

    public CollectionProxy<T> reject(Predicate<T> pred) {
        return select( new NotPredicate( pred ) );
    }

    public Collection<T> result() {
        return collection;
    }

    public CollectionProxy<T> select(Predicate<T> pred) {
        for( T t : collection ) {
            if( ! pred.evaluate(t) ) {
                collection.remove(t);
            }
        }
        return this;
    }


     public <E> CollectionProxy<E> map(Transformer<T, E> transformer) {
        List lst = new ArrayList( collection.size() );
         for( T t: collection ) {
            lst.add( transformer.transform(t) );
        }
        collection.clear();
        collection.addAll( lst );
        return (CollectionProxy<E>) this;
    }

    public <R> R reduce(Reducer<T, R> reducer) {
        R result = reducer.neutralElement();
        for( T t: collection ) {
            result = reducer.reduce(t, result);
        }
        return result;
    }

    public CollectionProxy<T> fillWith(Generator<T> gen) {
        gen.fill(collection);
        return this;
    }

}
