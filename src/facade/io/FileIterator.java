/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.io;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falcone
 */
public class FileIterator implements Iterator<String> {

    private static class EmptyFileItertor extends FileIterator {

        private EmptyFileItertor() throws FileNotFoundException {
            super(null);
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }
    }

    private static EmptyFileItertor emptyIterator;

    protected static FileIterator emptyFileIterator() {
        if( emptyIterator == null ) {
            try {
                emptyIterator = new EmptyFileItertor();
            } catch (FileNotFoundException e) {}
        }
        return emptyIterator;
    }

    private BufferedReader reader;
    private String line;

    public FileIterator(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
        line = nextLine();
    }

    public boolean hasNext() {
        if (line == null) {
            try {
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return false;
        }
        return true;
    }

    public String next() {
        String oldLine = line;
        line = nextLine();
        return oldLine;
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }

    private String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
