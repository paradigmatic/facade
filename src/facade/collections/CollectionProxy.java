/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.collections;

import java.util.Collection;
import facade.functors.Generator;
import facade.functors.Reducer;
import org.apache.commons.collections15.Closure;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author falcone
 */
public interface CollectionProxy<T> {

    public CollectionProxy <T> add(T t);

    public CollectionProxy addAll(Collection<T> otherCollection);

    public CollectionProxy <T> apply(Closure<T> closure);

    public <E> CollectionProxy<E> map(Transformer<T, E> transformer);

    public CollectionProxy <T> reject(Predicate<T> pred);

    public Collection<T> result();

    public CollectionProxy<T> select(Predicate<T> pred);

    public CollectionProxy<T> fillWith( Generator<T> gen );

    public <R> R reduce( Reducer<T,R> reducer );



}
