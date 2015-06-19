package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by machira on Jun/19/15.
 */
public class MovieTest {

    Movie movie;

    @Before
    public void setup() {
        this.movie = new Movie("Shawshank Redemption", 1996, "Morgan Freeman", 10);
    }


    @Test
    public void shouldPrintDetails() {
        String string = movie.toString();
        assertEquals("Shawshank Redemption 1996                 Morgan Freeman       10                  \n", string);
    }

    @Test
    public void shouldReturnTrueWhenCheckedOut() {
        movie.checkout();
        assertTrue(movie.isCheckedOut());
    }

    @Test
    public void shouldReturnTrueWhenReturned() {
        movie.checkout();
        assertTrue(movie.checkIn());
    }

}
