
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

import java.util.Collection;
import facade.functors.Reducer;
import org.apache.commons.collections15.Closure;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;

/**
 * Wraps a collection. Depending of the implementation,
 * the actions can act on a copy or in place.
 * @since 0.0.1
 */
public interface CollectionProxy<T> {

     /**
     * Get the wrapped collection.
     * @return the wrapped collection
     */
    public Collection<T> get();

    /**
     * Adds an element to the wrapped collection.
     * @param t the element to be added
     * @return a CollectionProxy
     */
    public CollectionProxy <T> add(T t);

    /**
     * Adds all the element of a collection to the wrapped collection.
     * @param otherCollection a collection of element to be added
     * @return a collectionProxy
     */
    public CollectionProxy addAll(Collection<T> otherCollection);

    /**
     * Filters a collection by selecting appropriate elements. Evaluates a predicate
     * on each object and select elements when it returns true.
     * @param pred the predicate use to select the elements. Selected when evaluates to true.
     * @return a CollectionProxy
     * @see org.apache.commons.collections15.Predicate
     */
    public CollectionProxy<T> select(Predicate<T> pred);

    /**
     * Filters a collection by rejecting inappropriate elements. Evaluates a predicate
     * on each object and reject the elements when it returns true.
     * @param pred the predicate use to reject the elements. Rejected when evaluates to true.
     * @return a CollectionProxy
     * @see org.apache.commons.collections15.Predicate
     */
    public CollectionProxy <T> reject(Predicate<T> pred);


    /**
     * Applies a closure on each element of the wrapped collection. Their internal
     * state can be affected by the closure, but the collection still contains the
     * same objects.
     * @param closure the closure to be applied on the collection elements
     * @return a CollectionProxy
     * @see org.apache.commons.collections15.Closure
     */
    public CollectionProxy <T> apply(Closure<T> closure);

    /**
     * Transforms every element of the wrapped collection. Apllies a transformer
     * on each element. It can change the generic type.
     * @param transformer the transformer object
     * @return a CollectionProxy
     * @see org.apache.commons.collections15.Transformer
     */
    public <E> CollectionProxy<E> map(Transformer<T, E> transformer);

    /**
     * Reduces the wrapped collection to a single value. A reducer instance
     * is used. The returned object might be of a different type than the
     * wrapped collection elements.
     * @param reducer a reducer to be used
     * @return the reduced value.
     */
    public <R> R reduce( Reducer<T,R> reducer );

    /**
     * Convert every collection element to a string which are join to produce
     * a single string representation. The separator is added between each elements.
     * @param separator the separator is added between each element
     * @return the produced string.
     */
    public String join( String separator );

}
