package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Biblioteca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by machira on Jun/22/15.
 */
public class CheckoutBookCommandTest {

    private Biblioteca biblioteca;
    private CheckoutBookCommand checkoutBookCommand;
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    @Before
    public void setup() {
        biblioteca = mock(Biblioteca.class);
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        checkoutBookCommand = new CheckoutBookCommand(biblioteca, bufferedReader, printStream);
    }

    @Test
    public void shouldListAvailableBooksWhenCheckoutOptionIsSelected() {
        checkoutBookCommand.execute();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldPromptUserToSelectBookWhenCheckoutOptionIsSelected() throws IOException {
        checkoutBookCommand.getUserBookSelection();
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldCorrectlyPassUserSelectionWhenUserProvidesInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Test Title");
        String userSelection  = checkoutBookCommand.getUserBookSelection();
        Assert.assertThat(userSelection,is("Test Title"));
    }

    @Test
    public void shouldCheckoutSelectedBookWhenUserProvidesInput() {
        when(biblioteca.isBookAvailable("Title")).thenReturn(true);
        checkoutBookCommand.checkoutBook("Title");
        verify(biblioteca).checkoutBookWithTitle("Title");
    }

    @Test
    public void shouldSuccessfullyCheckoutAvailableBook() {
        when(biblioteca.isBookAvailable("Conversational Introduction to String Theory - Yael Kaufman and Raymond Macharia")).thenReturn(true);

        checkoutBookCommand.checkoutBook("Conversational Introduction to String Theory - Yael Kaufman and Raymond Macharia");

        verify(printStream).println("Success! Enjoy your book.");
    }



}

