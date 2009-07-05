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

import facade.collections.CollectionInPlaceProxy;
import java.util.logging.Level;
import java.util.logging.Logger;
import facade.functors.Generator;
import facade.functors.Reducer;
import org.apache.commons.collections15.iterators.*;
import org.apache.commons.collections15.functors.*;
import org.apache.commons.collections15.*;
import java.util.*;

/**
 *
 * @author falcone
 */
public class CollectionSafeProxy<T> implements CollectionProxy<T> {

    private Collection<T> collection;

    public CollectionSafeProxy(Collection<T> collection) {
        //TODO: check if an empty public constructor exists
        this.collection = collection;
    }

    public Collection<T> get() {
        try {
            return cloneCollection();
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public CollectionProxy<T> select(Predicate<T> pred) {
        Collection<T> newCollection = null;
        try { //TODO: define a proper exception management
            newCollection = emptyCloneCollection();
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<T> it = new FilterIterator(collection.iterator(), pred);
        while (it.hasNext()) {
            newCollection.add(it.next());
        }
        return new CollectionInPlaceProxy<T>(newCollection);
    }

    public CollectionProxy<T> reject(Predicate<T> pred) {
        return select(new NotPredicate(pred));
    }

    public CollectionProxy<T> apply(Closure<T> closure) {
        CollectionProxy<T> nextProxy = null;
        try {
            nextProxy = new CollectionInPlaceProxy<T>(cloneCollection()).apply(closure);
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextProxy;
    }

    public CollectionProxy<T> add(T t) {
        CollectionProxy<T> nextProxy = null;
        try {
            nextProxy = new CollectionInPlaceProxy<T>(cloneCollection()).add(t);
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextProxy;

    }

    public CollectionProxy<T> addAll(Collection<T> otherCollection) {
        CollectionProxy<T> nextProxy = null;
        try {
            nextProxy = new CollectionInPlaceProxy<T>(cloneCollection()).addAll(otherCollection);
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextProxy;
    }

    private Collection<T> cloneCollection() throws InstantiationException, IllegalAccessException {
        Collection<T> cloned = emptyCloneCollection();
        cloned.addAll(collection);
        return cloned;
    }


    private Collection<T> emptyCloneCollection() throws InstantiationException, IllegalAccessException {
        Collection<T> cloned = collection.getClass().newInstance();
        return cloned;
    }

    public <E> CollectionProxy<E> map(Transformer<T, E> transformer) {
        CollectionProxy<E> nextProxy = null;
        try {
            nextProxy = new CollectionInPlaceProxy<T>(cloneCollection()).map(transformer);
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextProxy;
    }

    public <R> R reduce(Reducer<T, R> reducer) {
        R result = null;
        try {
            result = new CollectionInPlaceProxy<T>(cloneCollection()).reduce(reducer);
        } catch (InstantiationException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CollectionSafeProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String join(String separator) {
        return Common.join( collection, separator );
    }
}
