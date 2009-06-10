/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.functors;

import java.util.*;

/**
 *
 * @author falcone
 */
public interface Generator<T> extends Iterator<T>, Iterable<T>  {

    public void fill( Collection<T> collection );

}
