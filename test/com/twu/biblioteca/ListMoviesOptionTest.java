package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class ListMoviesOptionTest {
    private ListMoviesOption listMoviesOption;

    @Before
    public void setUpListOption(){
        listMoviesOption = new ListMoviesOption();
    }

    @Test
    public void canReturnName(){
        assertEquals(
                "List (M)ovies",
                listMoviesOption.name()
        );
    }

    @Test
    public void canReturnCommand(){
        assertEquals(
                "M",
                listMoviesOption.getCommand()
        );
    }

    @Test
    public void canRun(){
        Library library = mock(Library.class);
        listMoviesOption.run(library);
        verify(library, times(1)).listMovies();
    }
}
