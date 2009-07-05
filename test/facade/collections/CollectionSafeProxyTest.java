/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.collections;

import facade.functors.Reducer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections15.Closure;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static facade.Collections.with;

/**
 *
 * @author falcone
 */
public class CollectionSafeProxyTest {

    private Collection<Integer> emptyLst;
    private Collection<Integer> singleLst;
    private final int SINGLE_ELEM = 41;

    private Predicate<Integer> falsePred = new Predicate() {
        public boolean evaluate(Object object) {
            return false;
        }
    };

    private Predicate<Integer> truePred = new Predicate() {
        public boolean evaluate(Object object) {
            return true;
        }
    };

    @Before
    public void setUp() {
        emptyLst = new ArrayList<Integer>();
        singleLst = new ArrayList<Integer>();
        singleLst.add(SINGLE_ELEM);
    }

    /**
     * Test of get method, of class CollectionSafeProxy.
     */
    @Test
    public void testGet() {
        Collection<Integer> lst = with( emptyLst ).get();
        assertFalse( lst == emptyLst );
    }

    /**
     * Test of select method, of class CollectionSafeProxy.
     */
    @Test
    public void testSelect() {
        Collection<Integer> lst = with( singleLst ).select(truePred).get();
        assertEquals( 1, lst.size() );
        lst = with( singleLst ).select(falsePred).get();
        assertEquals( 0, lst.size() );
    }

    /**
     * Test of reject method, of class CollectionSafeProxy.
     */
    @Test
    public void testReject() {
        Collection<Integer> lst = with( singleLst ).reject(falsePred).get();
        assertEquals( 1, lst.size() );
        lst = with( singleLst ).reject(truePred).get();
        assertEquals( 0, lst.size() );
    }


    /**
     * Test of apply method, of class CollectionSafeProxy.
     */
    @Test
    public void testApply() {
        class Watcher implements Closure<Integer> {
            private int last;
            public void execute(Integer arg0) {
                last = arg0;
            }
            public int getLast() { return last;}

        }
        Watcher w = new Watcher();
        with(singleLst).apply(w);
        assertEquals( w.getLast(), SINGLE_ELEM);
    }


    /**
     * Test of addAll method, of class CollectionSafeProxy.
     */
    @Test
    public void testAddAll() {
        Collection<Integer> col = new ArrayList<Integer>();
        col.add(12);
        col.add(13);
        Collection<Integer> newCol = with(singleLst).addAll(col).get();
        assertEquals(3, newCol.size() );
    }

    /**
     * Test of map method, of class CollectionSafeProxy.
     */
    @Test
    public void testMap() {
        class ToString<I extends Object> implements Transformer<I,String> {
            public String transform(I arg) {
                return arg.toString();
            }
        }
        Collection<String> col = with(singleLst).map(new ToString()).get();
        String str = (String) ((List) col).get(0);
        assertEquals( Integer.toString(SINGLE_ELEM), str);
    }

    /**
     * Test of reduce method, of class CollectionSafeProxy.
     */
    @Test
    public void testReduce() {
        class Sum implements Reducer<Integer,Integer>  {

            public Integer neutralElement() {
                return 0;
            }

            public Integer reduce(Integer t, Integer accumulator) {
                return t+accumulator;
            }

        }
        final int NEW_ELEM = 665;
        singleLst.add(NEW_ELEM);
        int result = with(singleLst).reduce(new Sum());
        assertEquals(NEW_ELEM+SINGLE_ELEM, result);
    }



    /**
     * Test of add method, of class CollectionSafeProxy.
     */
    @Test
    public void testAdd() {
        Collection<Integer> lst = with( singleLst ).add(3).get();
        assertEquals( 2, lst.size() );
    }

    /**
     * Test of join method, of class CollectionSafeProxy.
     */
    @Test
    public void testJoin() {
        final int SECOND = 665;
        final int THIRD = 333;
        final String SEPARATOR = ", ";
        singleLst.add(SECOND);
        singleLst.add(THIRD);
        String str = with(singleLst).join(", ");
        assertEquals( SINGLE_ELEM+SEPARATOR+SECOND+SEPARATOR+THIRD, str);
    }

}