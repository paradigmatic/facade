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
package facade.strings;

import java.util.List;

/**
 * Wraps a {@link java.lang.String string} to allow easy manipulation. As the strings are immutable,
 * any usage is always safe for the wrapped string.
 * @since 0.1.0
 */
public interface StringProxy {

    /**
     * Split a string using each characters present in the 'separators'
     * parameter. The separators are not present in the sub strings.
     * @param separators
     * @return A list containing the splitted strings.
     */
    List<String> split( String separators );


    /**
     * Matches a regexp on a string, extraction each group.
     * @param regexp A string representing the regexp.
     * @return Either a list of tokens (indexed by group order) or null if the
     * regexp does not match the string.
     */
    List<String> parse( String regexp );

    /**
     * Attempt to parse an string as an integer.
     * @return The int value
     */
    int toInt();


}
