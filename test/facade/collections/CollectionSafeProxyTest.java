/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static facade.Collections.*;

/**
 *
 * @author falcone
 */
public class CollectionSafeProxyTest {

    private Collection<Integer> emptyLst;
    private Collection<Integer> singleLst;
 
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
        singleLst.add(12);
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
        lst = with( singleLst ).select(falsePred).get();
        assertEquals( 0, lst.size() );
    }

    /**
     * Test of reject method, of class CollectionSafeProxy.
     */
    @Test
    public void testReject() {
        fail();
    }

    /**
     * Test of apply method, of class CollectionSafeProxy.
     */
    @Test
    public void testApply() {
        fail();
    }

    /**
     * Test of add method, of class CollectionSafeProxy.
     */
    @Test
    public void testAdd() {
        fail();
    }

    /**
     * Test of addAll method, of class CollectionSafeProxy.
     */
    @Test
    public void testAddAll() {
        fail();
    }

    /**
     * Test of map method, of class CollectionSafeProxy.
     */
    @Test
    public void testMap() {
        fail();
    }

    /**
     * Test of reduce method, of class CollectionSafeProxy.
     */
    @Test
    public void testReduce() {
        fail();
    }

    /**
     * Test of fillWith method, of class CollectionSafeProxy.
     */
    @Test
    public void testFillWith() {
        fail();
    }
}