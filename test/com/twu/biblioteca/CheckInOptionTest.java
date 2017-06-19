package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class CheckInOptionTest {
    private CheckInOption checkInOption;

    @Before
    public void setUpCheckInOption(){
        checkInOption = new CheckInOption();
    }

    @Test
    public void canReturnName(){
        assertEquals(
                "(R)eturn book",
                checkInOption.name()
        );
    }

    @Test
    public void canReturnCommand(){
        assertEquals(
                "R",
                checkInOption.getCommand()
        );
    }

    @Test
    public void canRun(){
        Library library = mock(Library.class);
        checkInOption.run(library);
        verify(library, times(1)).checkIn();
    }
}
