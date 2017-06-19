package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class LibraryTest {

    private ByteArrayOutputStream outputStream;
    private Library library;

    @Before
    public void setUpLibrary(){
        library = new Library();
        Book b1 = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        Book b2 = new Book("The House of the Spirits", "Isabel Allende", 1982);
        Movie m1 = new Movie(
                "The Incredibles",
                "Brad Bird",
                "10",
                2004);
        Movie m2 = new Movie(
                "The Matrix",
                "The Wachowskis",
                "10",
                1999);
        library.addItems(b1, b2, m1, m2);
    }

    @Test
    public void canListBooks(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        library.listBooks();
        assertEquals(
                "Here are the available books\n" +
                "Title   |   Author  |   Year of publication\n" +
                "A Game of Thrones | George R. R. Martin | 1996\n" +
                "The House of the Spirits | Isabel Allende | 1982\n",
                outputStream.toString()
        );
    }

    @Test
    public void canListMovies(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        library.listMovies();
        assertEquals(
                "Here are the available movies\n" +
                        "Title   |   Director   |   Rating   |   Year of publication\n" +
                        "The Incredibles | Brad Bird | 10 | 2004\n" +
                        "The Matrix | The Wachowskis | 10 | 1999\n",
                outputStream.toString()
        );
    }

    @Test
    public void canChekoutBook(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String input = "The House of the Spirits";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.checkOut();
        assertEquals(
                "Please enter the title of the book\n" +
                "Thank you! Enjoy the book\n",
                outputStream.toString()
        );
    }

    @Test
    public void cannotCheckoutInvalid(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String input = "banana";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.checkOut();
        assertEquals(
                "Please enter the title of the book\n" +
                "That book is not available\n",
                outputStream.toString()
        );
    }

    @Test
    public void canStoreCheckedoutBooks(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String input = "The House of the Spirits";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.checkOut();
        library.listCheckedOut();
        assertEquals(
                "Please enter the title of the book\n" +
                "Thank you! Enjoy the book\n" +
                "The House of the Spirits | Isabel Allende | 1982\n",
                outputStream.toString()
        );
    }

    @Test
    public void canReturnCheckedOutBook(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String input = "The House of the Spirits";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.checkOut();
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.checkIn();
        library.listBooks();
        assertEquals(
                "Please enter the title of the book\n" +
                "Thank you! Enjoy the book\n" +
                "Please enter the title of the book\n" +
                "Thank you for returning the book\n" +
                "Here are the available books\n" +
                "Title   |   Author  |   Year of publication\n" +
                "A Game of Thrones | George R. R. Martin | 1996\n" +
                "The House of the Spirits | Isabel Allende | 1982\n",
                outputStream.toString()
        );
    }

    @Test
    public void cannotReturnInvalidBook(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String input = "Bananas";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        library.checkIn();
        assertEquals(
                "Please enter the title of the book\n" +
                "That is not a valid book to return\n",
                outputStream.toString()
        );
    }
}
