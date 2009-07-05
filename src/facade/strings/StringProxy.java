/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.strings;

import java.util.List;

/**
 *
 * @author falcone
 */
public interface StringProxy {

    /**
     * Split a string using each characters present in the 'separators'
     * parameter. The separators are not present in the sub strings.
     * @param separators
     * @return A list containing the splitted strings.
     */
    List<String> split( String separators );


    /**
     * Matches a regexp on a string, extraction each group.
     * @param regexp A string representing the regexp.
     * @return Either a list of tokens (indexed by group order) or null if the
     * regexp does not match the string.
     */
    List<String> parse( String regexp );


}
