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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Basic implementation for the StringProxy interface.
 * @see StringProxy
 * @since 0.0.1
 */
public class BasicStringProxy implements StringProxy {

    private String str;

    public BasicStringProxy(String str) {
        this.str = str;
    }

    public List<String> split(String separators) {
        StringTokenizer st = new StringTokenizer(str, separators);
        List<String> lst = new ArrayList<String>( st.countTokens() );
        while( st.hasMoreTokens() ) {
            lst.add( st.nextToken() );
        }
        return lst;
    }

    public List<String> parse(String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(str);
        if( matcher.matches() ) {
            int count = matcher.groupCount()+1;
            List<String> lst = new ArrayList<String>(count);
            for( int i=0; i<count; i++ ) {
                lst.add( matcher.group(i) );
            }
            return lst;
        } else {
            return null;
        }
    }

    public int toInt() {
        return Integer.parseInt(str);
    }

}
