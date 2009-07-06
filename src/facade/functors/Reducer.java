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
package facade.functors;

/**
 * Allows to reduce a collection to a single value. The reduction operation
 * can be non-commutative or non associative.
 * @since 0.0.1
 */
public interface Reducer<T,R> {

    /**
     * Gets the neutral element for the operation defined in the reduce method.
     * The neutral element depends also on the operands type. For example, an neutral
     * element for a reducer multiplying doubles should be '1.0'.
     * @return the neutral element
     */
    public R neutralElement();

    /**
     * Reduce an element and an accumulator to a single value. Can be of a different
     * type than the element
     * @param t a new element to be reduced
     * @param accumulator the reduction result so far.
     * @return the reduction result.
     */
    public R reduce( T t, R accumulator );

}
