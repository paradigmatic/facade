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

import java.util.Collection;
import facade.functors.Generator;
import facade.functors.Reducer;
import org.apache.commons.collections15.Closure;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author falcone
 */
public interface CollectionProxy<T> {

    public CollectionProxy <T> add(T t);

    public CollectionProxy addAll(Collection<T> otherCollection);

    public CollectionProxy <T> apply(Closure<T> closure);

    public <E> CollectionProxy<E> map(Transformer<T, E> transformer);

    public CollectionProxy <T> reject(Predicate<T> pred);

    public Collection<T> get();

    public CollectionProxy<T> select(Predicate<T> pred);

    public <R> R reduce( Reducer<T,R> reducer );



}
