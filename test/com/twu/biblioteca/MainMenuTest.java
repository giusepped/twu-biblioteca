package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class MainMenuTest {

    private ByteArrayOutputStream outputStream;
    private MainMenu menu;
    private ListBooksOption listBooksOption;
    private Library library;

    @Before
    public void setUpMenu(){
        library = new Library();
        ArrayList<MenuOption> options = new ArrayList<MenuOption>();
        listBooksOption = mock(ListBooksOption.class);
        when(listBooksOption.getCommand()).thenReturn("L");
        when(listBooksOption.name()).thenReturn("(L)ist books");
        options.add(listBooksOption);
        menu = new MainMenu(library, options);
    }

    @Test
    public void canShowOptions(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        menu.showOptions();
        assertEquals(
                "Please choose an option (use the letter in parenthesis):\n" +
                        "(L)ist books\n",
                outputStream.toString()
        );
    }

    @Test
    public void canChooseOption(){
        menu.chooseOption("L");
        verify(listBooksOption, times(1)).run(library);
    }

    @Test
    public void cannotChooseInvalidOption(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        menu.chooseOption("banana");
        assertEquals(
                "Invalid option!\n",
                outputStream.toString()
        );
    }
}
