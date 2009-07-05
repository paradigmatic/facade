/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.strings;

import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static facade.Strings.*;

/**
 *
 * @author falcone
 */
public class BasicStringProxyTest {

    private static final String FIRST = "23";
    private static final String SECOND = "57";
    private String str;

    @Before
    public void setUp() {
        str = FIRST + ",  " + SECOND ;
    }

    @Test
    public void testSplit() {
        List<String> splitted = string( str ).split( " ," );
        assertEquals(2, splitted.size() );
        assertEquals(FIRST, splitted.get(0));
        assertEquals(SECOND, splitted.get(1));
    }


    @Test
    public void testParse() {
        String regexp = "(\\d+)[^\\d]+(\\d+)";
        String badRegexp = "(\\d+) (\\d+)";
        List<String> parsed = string( str ).parse(regexp);
        assertEquals(3, parsed.size() );
        assertEquals(str, parsed.get(0) );
        assertEquals(FIRST, parsed.get(1));
        assertEquals(SECOND, parsed.get(2));
        parsed = string( str ).parse(badRegexp);
        assertEquals( null, parsed );
    }


}