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
