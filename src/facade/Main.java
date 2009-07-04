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

import facade.functors.Generator;
import facade.functors.StringConcatenator;
import java.io.IOException;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections15.*;
import static facade.IO.*;
import static facade.Collections.*;
/**
 *
 * @author falcone
 */
public class Main {

    public static void generatorDemo() {
        List<Integer> lst = new ArrayList<Integer>();

        Predicate<Integer> isEven = new Predicate<Integer>() {

            public boolean evaluate(Integer object) {
                return object % 2 == 0;
            }
        };

        Predicate<Integer> isBiggerThan10 = new Predicate<Integer>() {

            public boolean evaluate(Integer object) {
                return object > 10;
            }
        };

        Factory<Integer> naturalNumbers = new Factory<Integer>() {
            private int next = 0;
            public Integer create() {
                next++;
                return next;
            }
        };

        Generator<Integer> generator = generateWith(naturalNumbers).suchAs(isEven).and(isBiggerThan10).takingTheFirst(12);
        String str = (String) on(lst).fillWith(generator).reduce( new StringConcatenator() );
        System.out.println(str);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        generatorDemo();
    }

}
