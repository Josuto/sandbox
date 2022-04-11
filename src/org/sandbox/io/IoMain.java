package org.sandbox.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This class aims to explain the basic constructs around Java IO by example.
 * 
 * @author josumartinez
 *
 */
public final class IoMain {

    private static final int CHARS_INITIAL_VALUE = 40;
    
    
    public static void main(String[] args) {
        try {
            char[] chars = basicFileRead("/Users/josumartinez/Downloads/text.txt");
            System.out.println("The (partial) content of the file is: " + String.valueOf(chars));
            
            chars = bufferedFileRead("/Users/josumartinez/Downloads/text.txt");
            System.out.println("The (partial) content of the file is: " + String.valueOf(chars));
            
            // Java 8+ supported charset list: https://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
            chars = charEncodingFileRead("/Users/josumartinez/Downloads/text.txt", "US-ASCII");
            System.out.println("The (partial) content of the file is: " + String.valueOf(chars));
        } 
        catch (IOException exception) {
            exception.printStackTrace();
        } 
    }
    
    /**
     * Most basic file processing algorithm. {@link FileReader} sequentially reads
     * the characters of the file referred by the given filename, one at a time.
     * Since the read request is handled directly by the underlying OS, each
     * character read request means a disk access operation, which makes it this
     * operation pretty inefficient compared to that performed at
     * {@link #bufferedFileRead(String)}.
     */
    private static char[] basicFileRead(final String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            return loadCharArray(reader);
        }
    }
    
    /**
     * Faster than {@link #basicFileRead(String)} as {@link BufferedReader} stores a
     * larger block of the given filename in an internal buffer (array) at a time,
     * reducing disk access time, and {@link BufferedReader#read()} reads from it
     * while there are characters to be processed. When the buffer content is
     * consumed, then it request the native input API to access the disk to read a
     * new block, until there are no more blocks to read. Be aware, however, that
     * efficiency comes at the price of an increase of memory consumption due to the
     * existence of the buffer.
     */
    private static char[] bufferedFileRead(final String filename) throws IOException {
        try (Reader reader = new BufferedReader(new FileReader(filename))) {
            return loadCharArray(reader);
        }
    }
    
    /**
     * The constructor of {@link InputStreamReader} wraps an {@link InputStream} and
     * specifies the character encoding system to use when reading its contents. In
     * this case, we wrap a {@link FileInputStream} (i.e., the representation of the
     * contents of a file as a stream of bytes), that the constructor of
     * {@link InputStreamReader} realizes as a {@link Reader} (i.e., a stream of
     * characters).
     */
    private static char[] charEncodingFileRead(final String filename, final String encoding) throws IOException {
        try (Reader reader = new InputStreamReader(new FileInputStream(filename), encoding)) {
            return loadCharArray(reader);
        }
    }
    
    /**
     * Given a {@link Reader} to a file, this method reads its contents and returns
     * them as an array of characters.
     */
    private static char[] loadCharArray(final Reader reader) throws IOException {
        char[] chars = new char[CHARS_INITIAL_VALUE];
        int charIndex = 0;
        int data = reader.read();
        while (data != -1 & charIndex < chars.length) {
            char c = Character.valueOf((char) data);
            chars[charIndex++] = c;
            data = reader.read();
        }
        return chars;
    }

}
