package com.twu.biblioteca;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WelcomeMessageTest {

    private ByteArrayOutputStream outputStream;
    private WelcomeMessage welcomeMessage;

    @Test
    public void WelcomeMessageIsDisplayed(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        welcomeMessage = new WelcomeMessage();
        welcomeMessage.printMessage();
        assertEquals(
                "Welcome to Bangalore Public Library, we are here to help you\n",
                outputStream.toString());


    }
}
