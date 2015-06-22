package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by machira on Jun/19/15.
 */
public class ListMoviesCommandTest {

    Biblioteca biblioteca;
    ListMoviesCommand listMoviesCommand;

    @Before
    public void setup() {
        biblioteca = mock(Biblioteca.class);
        listMoviesCommand = new ListMoviesCommand(biblioteca);
    }

    @Test
    public void shouldListMoviesWhenExecuted() {
        listMoviesCommand.execute();

        verify(biblioteca).listMovies();
    }
}
