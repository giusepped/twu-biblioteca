package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by giuseppedesantis on 16/06/2017.
 */
public class MovieTest {

    private Movie movie;

    @Before
    public void createMovie(){
        movie = new Movie(
                "The Incredibles",
                "Brad Bird",
                "10",
                2004);
    }

    @Test
    public void canGetDetails(){
        assertEquals(
                "The Incredibles | Brad Bird | 10 | 2004",
                movie.getDetails()
        );
    }

    @Test
    public void canGetTitle(){
        assertEquals(
                "The Incredibles",
                movie.getTitle()
        );
    }
}
