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

import facade.strings.BasicStringProxy;
import facade.strings.StringProxy;

/**
 * Provides static wrapper method for Strings.
 * @since 0.0.1
 */
public class Strings {

    /**
     * Wraps a string in a StringProxy
     * @param str The string to be wrapped
     * @return A wrapping StringProxy
     */
    static public StringProxy string( String str ) {
        return new BasicStringProxy( str );
    }

}
