package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class CheckOutOptionTest {
    private CheckOutOption checkOutOption;

    @Before
    public void setUpCheckOutOption(){
        checkOutOption = new CheckOutOption();
    }

    @Test
    public void canReturnName(){
        assertEquals(
                "(C)heck out item",
                checkOutOption.name()
        );
    }

    @Test
    public void canReturnCommand(){
        assertEquals(
                "C",
                checkOutOption.getCommand()
        );
    }

    @Test
    public void canRun(){
        Library library = mock(Library.class);
        checkOutOption.run(library);
        verify(library, times(1)).checkOut();
    }
}
