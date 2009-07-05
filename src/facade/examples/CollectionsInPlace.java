/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
