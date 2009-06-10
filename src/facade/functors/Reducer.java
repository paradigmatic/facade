/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.functors;

/**
 *
 * @author falcone
 */
public interface Reducer<T,R> {

    public R neutralElement();

    public R reduce( T t, R accumulator );

}
