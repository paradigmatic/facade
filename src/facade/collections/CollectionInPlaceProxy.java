/*  
 * This file is part of Facade
 *
 *  Facade is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Facade is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  (c) 2009, Jean-Luc Falcone, jean-luc.falcone@unige.ch
 *
 */
package facade.collections;

import facade.functors.Reducer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections15.Closure;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.NotPredicate;


/**
 * Wraps a collection and allow actions to modify it directly.
 * @since 0.0.1
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

    public Collection<T> get() {
        return collection;
    }

    public CollectionProxy<T> select(Predicate<T> pred) {
        Iterator<T> it = collection.iterator();
        while( it.hasNext() ) {
            T t = it.next();
            if( ! pred.evaluate(t) ) {
                it.remove();
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

    public String join(String separator) {
        return Common.join( collection, separator );
    }

    public CollectionProxy<T> add(T... t) {
        return addAll( t );
    }

    public CollectionProxy<T> addAll(T[] array) {
        for( T t: array )  {
            collection.add( t );
        }
        return this;
    }



}
