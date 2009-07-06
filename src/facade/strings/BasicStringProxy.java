/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author falcone
 */
public class BasicStringProxy implements StringProxy {

    private String str;

    public BasicStringProxy(String str) {
        this.str = str;
    }

    public List<String> split(String separators) {
        StringTokenizer st = new StringTokenizer(str, separators);
        List<String> lst = new ArrayList<String>( st.countTokens() );
        while( st.hasMoreTokens() ) {
            lst.add( st.nextToken() );
        }
        return lst;
    }

    public List<String> parse(String regexp) {
        Matcher matcher = Pattern.compile(regexp).matcher(str);
        if( matcher.matches() ) {
            int count = matcher.groupCount()+1;
            List<String> lst = new ArrayList<String>(count);
            for( int i=0; i<count; i++ ) {
                lst.add( matcher.group(i) );
            }
            return lst;
        } else {
            return null;
        }
    }

    public int toInt() {
        return Integer.parseInt(str);
    }

}
