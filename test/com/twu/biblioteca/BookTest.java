package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class BookTest {

    private Book book;

    @Before
    public void createBook(){
        book = new Book("The House of the Spirits", "Isabel Allende", 1982);
    }

    @Test
    public void canGetDetails(){
        assertEquals(
                "The House of the Spirits | Isabel Allende | 1982",
                book.getDetails()
        );
    }

    @Test
    public void canGetTitle(){
        assertEquals(
                "The House of the Spirits",
                book.getTitle()
        );
    }
}
