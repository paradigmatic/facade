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

    public Collection<T> get() {
        return collection;
    }

    public CollectionProxy<T> select(Predicate<T> pred) {
        for( T t : collection ) {
            System.out.println("ELEM: " + t);
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


}
