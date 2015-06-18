package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by angoh on 6/17/15.
 */
public class MenuTest {

    private BufferedReader reader;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;
    private Menu menu;
    private BibliotecaApp bibliotecaApp;
    private String bookTitle;

    @Before
    public void setUp() throws IOException{
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, biblioteca, reader);
        when(reader.readLine()).thenReturn("list books");
        bibliotecaApp = mock(BibliotecaApp.class);
        bookTitle = "Akon's Thesis";
    }

    @Test
    public void shouldAskForUserInputWhenMenuIsShown() {
        menu.displayMenu();
        verify(printStream).println("Enter your selection");
    }

    @Test
    public void shouldHandleInvalidUserInput() {
        menu.selectOption("boo");
        verify(printStream).println("That's not a valid option");
    }

    @Test
    public void shouldHandleValidUserInput(){
        menu.selectOption("LISt books");
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldIncludeQuitInMenuOption(){
        menu.displayMenu();
        verify(printStream).println(contains("Quit"));
    }

    @Test
    public void shouldIncludeCheckoutInMenuOption(){
        menu.displayMenu();
        verify(printStream).println(contains("Checkout"));
    }

    @Test
    public void shouldCheckoutBookWithGivenTitle(){
        menu.selectOption("checKout " + bookTitle);
        verify(biblioteca).checkout(bookTitle.toLowerCase());
    }

    @Test
    public void shouldLetUserKnowWhenCheckoutFails(){
        when(biblioteca.checkout(bookTitle)).thenReturn(false);
        menu.selectOption("checKout " + bookTitle);
        verify(printStream).println("Could not check out book with that title.");
    }

    @Test
    public void shouldLetUserKnowWhenCheckoutIsSuccessful(){
        when(biblioteca.checkout(bookTitle.toLowerCase())).thenReturn(true);
        menu.selectOption("checKout " + bookTitle);
        verify(printStream).println(contains("Success"));
    }

    @Test
    public void shouldQuitApplicationWhenQuitIsSelected(){
        menu.selectOption("Quit");
        assertFalse(menu.stillAlive);
    }

}
