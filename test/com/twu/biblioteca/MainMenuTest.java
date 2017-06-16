package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import sun.applet.Main;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class MainMenuTest {

    private ByteArrayOutputStream outputStream;
    private MainMenu menu;
    private ListOption listOption;
    private Library library;

    @Before
    public void setUpMenu(){
        library = new Library();
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        listOption = mock(ListOption.class);
        when(listOption.getCommand()).thenReturn("L");
        options.add(listOption);
        menu = new MainMenu(library, options);
    }

    @Test
    public void canShowOptions(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        menu.showOptions();
        assertEquals(
                "Please choose an option (use the first letter):\n" +
                        "(L)ist books\n",
                outputStream.toString()
        );
    }

    @Test
    public void canChooseOption(){
        menu.chooseOption("L");
        verify(listOption, times(1)).run(library);
    }
}
