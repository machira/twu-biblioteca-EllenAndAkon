package com.twu.biblioteca.Commands;


import com.twu.biblioteca.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by machira on Jun/19/15.
 */
public class ListBooksCommandTest {

    Biblioteca biblioteca;
    ListBooksCommand listBooksCommand;

    @Before
    public void setup() {
        biblioteca = mock(Biblioteca.class);
        listBooksCommand = new ListBooksCommand(biblioteca);
    }

    @Test
    public void shouldListBooksWhenExecuted() {
        listBooksCommand.execute();

        verify(biblioteca).listBooks();
    }
}