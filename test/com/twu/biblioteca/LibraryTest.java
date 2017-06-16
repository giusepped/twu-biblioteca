package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class LibraryTest {

    private ByteArrayOutputStream outputStream;
    private Library library;

    @Before
    public void setUpLibrary(){
        library = new Library();
        Book b1 = new Book("The Aeneid");
        Book b2 = new Book("The House of the Spirits");
        library.addBooks(b1, b2);
    }

    @Test
    public void canListBooks(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        library.list();
        assertEquals(
                "Here are the available books\n" +
                "The Aeneid\n" +
                "The House of the Spirits\n",
                outputStream.toString()
        );
    }
}
