package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class ListBooksOptionTest {
    private ListBooksOption listBooksOption;

    @Before
    public void setUpListOption(){
        listBooksOption = new ListBooksOption();
    }

    @Test
    public void canReturnName(){
        assertEquals(
                "(L)ist books",
                listBooksOption.name()
        );
    }

    @Test
    public void canReturnCommand(){
        assertEquals(
                "L",
                listBooksOption.getCommand()
        );
    }

    @Test
    public void canRun(){
        Library library = mock(Library.class);
        listBooksOption.run(library);
        verify(library, times(1)).listBooks();
    }
}
