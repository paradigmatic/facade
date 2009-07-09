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
import java.util.Iterator;
import org.apache.commons.collections15.Transformer;
import static facade.Collections.*;

/**
 * Examples for the collection tools.
 * @since 0.1.0
 */
public class Collections {

    /* Invert a double */
    private static Transformer<Double, Double> inverse = new Transformer<Double, Double>() {

        public Double transform( Double arg0 ) {
            return 1.0 / arg0;
        }
    };

    /* Reduce doubles by summation */
    private static Reducer<Double, Double> sum = new Reducer<Double, Double>() {

        public Double neutralElement() {
            return 0.0;
        }

        public Double reduce( Double t, Double accumulator ) {
            return t + accumulator;
        }
    };

    /**
     * Run the examples
     * @param args <i>ignored</i>
     */
    public static void main( String[] args ) {

        /* RESISTORS IN PARALLEL WITH FACADE */

        System.out.println( "-> With facade: " );
        /* Empty collection of resistors */
        Collection<Double> resistors = new ArrayList<Double>();
        /* adding values. on() modifies the collection in place */
        on( resistors ).add( 1.5, 3.0, 15.0, 30.0, 150.0 );
        /* computing resistance. with() works on a collection copy. */
        double r = 1.0 / with( resistors ).map( inverse ).reduce( sum );
        /* pretty printing the resistors */
        System.out.println( "[ " + with( resistors ).join( ", " ) + " ]" );
        /* printing the equivalent resistor */
        System.out.println( r );

        /* --------------------------------------------------------------- */
        System.out.println();
        /* --------------------------------------------------------------- */

        /* RESISTORS IN PARALLEL WITH CLASSIC JAVA */

        System.out.println( "-> Without facade: " );
        /* Empty collection of resistors */
        resistors = new ArrayList<Double>();
        /* adding values */
        resistors.add( 1.5 );
        resistors.add( 3.0 );
        resistors.add( 15.0 );
        resistors.add( 30.0 );
        resistors.add( 150.0 );
        /* computing resistance */
        double sum = 0.0;
        for( Double resistor : resistors ) {
            sum += 1.0 / resistor;
        }
        r = 1.0 / sum;
        /* pretty printing the resistors */
        StringBuilder sb = new StringBuilder();
        sb.append( "[ " );
        Iterator<Double> it = resistors.iterator();
        if ( it.hasNext() ) {
            sb.append( it.next() );
        }
        while( it.hasNext() ) {
            sb.append( ", " ).append( it.next() );
        }
        sb.append( " ]" );
        System.out.println( sb.toString() );
        /* printing the equivalent resistor */
        System.out.println( r );

    }
}
