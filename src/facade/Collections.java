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
package facade;

import facade.collections.CollectionInPlaceProxy;
import facade.collections.CollectionProxy;
import facade.collections.CollectionSafeProxy;
import java.util.Collection;


/**
 * Provides static wrapper method to Collections.
 * @since 0.1.0
 */
public class Collections {

    public static <T> CollectionProxy<T> with( Collection<T> collection ) {
        return new CollectionSafeProxy<T>( collection );
    }

    public static <T> CollectionProxy<T> on( Collection<T> collection ) {
        return new CollectionInPlaceProxy<T>( collection );
    }

}
