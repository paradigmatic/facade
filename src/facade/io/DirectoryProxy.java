/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.io;

/**
 *
 * @author falcone
 */
public interface DirectoryProxy {

    public File
    public DirectoryProxy parent();
    public FSNodeList content();
    public DirectoryProxy empty();
    public DirectoryProxy delete();

}
