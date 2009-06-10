/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.functors;

/**
 *
 * @author falcone
 */
public class StringConcatenator<T> implements Reducer<T,String> {

    public String neutralElement() {
        return "";
    }

    public String reduce(T t, String accumulator) {
        return accumulator + t.toString();
    }

}
