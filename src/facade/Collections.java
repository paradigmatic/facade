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

package facade;

import facade.collections.*;
import java.util.*;
import org.apache.commons.collections15.Factory;
/**
 *
 * @author falcone
 */
public class Collections {

    public static <T> CollectionProxy<T> with( Collection<T> collection ) {
        return new CollectionSafeProxy<T>( collection );
    }

    public static <T> CollectionProxy<T> on( Collection<T> collection ) {
        return new CollectionInPlaceProxy<T>( collection );
    }

    public static <T> GeneratorProxy<T> generateWith( Factory<T> factory ) {
        return new GeneratorProxy<T>( factory );
    }
}
