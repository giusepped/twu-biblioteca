package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by giuseppesmac on 17/06/17.
 */
public class QuitOptionTest {

    private QuitOption quitOption;

    @Before
    public void setUpQuitOption(){
        quitOption = new QuitOption();
    }

    @Test
    public void canReturnName(){
        assertEquals(
                "(Q)uit",
                quitOption.name()
        );
    }

    @Test
    public void canReturnCommand(){
        assertEquals(
                "Q",
                quitOption.getCommand()
        );
    }

}
