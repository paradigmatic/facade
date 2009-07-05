/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import facade.collections.CollectionInPlaceProxy;
import facade.collections.CollectionSafeProxy;
import java.util.ArrayList;
import java.util.Collection;
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
public class CollectionsTest {

    private Collection<Integer> col;

    public CollectionsTest() {
    }


    @Before
    public void setUp() {
        col = new ArrayList();
    }

    /**
     * Test of with method, of class Collections.
     */
    @Test
    public void testWith() {
        Object o = with(col);
        assertTrue( o instanceof CollectionSafeProxy );
    }

    /**
     * Test of on method, of class Collections.
     */
    @Test
    public void testOn() {
        Object o = on(col);
        assertTrue( o instanceof CollectionInPlaceProxy );
    }

}