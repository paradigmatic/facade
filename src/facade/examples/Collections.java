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
import static facade.Collections.*;

/**
 * Examples for the collection tools.
 * @since 0.0.1
 */
public class Collections {

    /* Return true if an integer is even */
    private static Predicate<Integer> isEven = new Predicate<Integer>() {

        public boolean evaluate(Integer i) {
            return i % 2 == 0;
        }
    };

    /* Invert a double */
    private static Transformer<Double, Double> inverse = new Transformer<Double, Double>() {

        public Double transform(Double arg0) {
            return 1.0 / arg0;
        }
    };

    /* Reduce double by summation */
    private static Reducer<Double, Double> sum = new Reducer<Double, Double>() {

        public Double neutralElement() {
            return 0.0;
        }

        public Double reduce(Double t, Double accumulator) {
            return t + accumulator;
        }
    };
    /**
     * Run the examples
     * @param args <i>ignored</i>
     */
    public static void main(String[] args) {

        /* List of 20 natural numbers */
        Collection<Integer> col = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            col.add(i);
        }
        /* Filter in place taking only negative numbers */
        on(col).select(isEven);
        /* Join and print */
        System.out.println(on(col).join("-"));
        System.out.println();

        /* List of resistors */
        Collection<Double> resistors = new ArrayList<Double>();
        /* adding values */
        on(resistors).add(1.5).add(3.0).add(15.0).add(30.0).add(150.0);
        
        /* computing equivalent resistor while in parallel */
        double r = 1.0 / with(resistors).map(inverse).reduce(sum);
        /* printing the original collection (untouched because of the 'with()'
         * method */
        System.out.println( "[ "+with(resistors).join(", ") + " ]" );
        /* printing the equivalent resistor */
        System.out.println( r );
        
        /* Classic java */
        resistors = new ArrayList<Double>();
        resistors.add(1.5);
        resistors.add(3.0);
        resistors.add(15.0);
        resistors.add(30.0);
        resistors.add(150.0);
        double sum = 0.0;
        for( Double resistor: resistors ) {
            sum += 1.0 / resistor;
        }
        r = 1.0 / sum;


    }
}
