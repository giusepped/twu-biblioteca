package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class ListOptionTest {
    private ListOption listOption;

    @Before
    public void setUpListOption(){
        listOption = new ListOption();
    }

    @Test
    public void canRun(){
        Library library = mock(Library.class);
        listOption.run(library);
        verify(library, times(1)).list();
    }
}
