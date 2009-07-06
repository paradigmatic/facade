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
package facade.examples;

import facade.functors.Reducer;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import static facade.Collections.on;

/**
 *
 * @author falcone
 */
public class CollectionsInPlace {

    private static Predicate<Integer> isEven = new Predicate<Integer>() {

        public boolean evaluate(Integer i) {
            return i % 2 == 0;
        }
    };

    private static Reducer<String, String> strJoin = new Reducer<String, String>() {

        public String neutralElement() {
            return "";
        }

        public String reduce(String s, String accumulator) {
            return accumulator + " " + s;
        }

    };
    
    private static class ToString<I extends Object> implements Transformer<I,String> {
            public String transform(I arg) {
                return arg.toString();
            }
        }
      
     private static ToString<Integer> toString = new ToString<Integer>();



    public static void main(String[] args) {

        Collection<Integer> col = new ArrayList<Integer>();
        for( int i=0; i<20; i++ ) {
            col.add( i );
        }
        //System.out.println( on(col).map(toString).reduce(strJoin) );
        System.out.println( on(col).select(isEven).map(toString).reduce(strJoin) );


    }

}
