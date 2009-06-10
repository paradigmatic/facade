/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade.io;

import java.io.IOException;

/**
 *
 * @author falcone
 */
public class NopFileFileProxy implements FileProxy {

    public boolean isDirectory() {
        return false;
    }

    public FileIterator lineIterator() throws IOException {
        return FileIterator.emptyFileIterator();
    }

    public FileProxy append(String s) throws IOException {
        return this;
    }

    public FileProxy create() throws IOException {
        return this;
    }

    public FileProxy delete() throws IOException {
        return this;
    }

    public FileProxy blank() throws IOException {
        return this;
    }

    public FileProxy moveTo(String path) throws IOException {
        return this;
    }

    public FileProxy copyTo(String path) throws IOException {
        return this;
    }

    public FileProxy ifExists() {
        return this;
    }

    public FileProxy unlessExists() {
        return this;
    }

}
