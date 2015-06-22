package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
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
    public void shouldAskForInputWhenMenuIsShown() {
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
    public void shouldIncludeReturnBookInMenuOption(){
        menu.displayMenu();
        verify(printStream).println(contains("Return"));
    }

    @Test
    public void shouldIncludeListMoviesInMenuOption(){
        menu.displayMenu();
        verify(printStream).println(contains("Movies"));
    }

    @Test
    public void shouldListMoviesWhenOptionSelected(){
        menu.selectOption("list Movies");
        verify(biblioteca).listMovies();
    }

    @Test
    public void shouldReturnBookWithGivenTitle(){
        menu.selectOption("return " + bookTitle);
        verify(biblioteca).returnBookWithTitle(bookTitle.toLowerCase());
    }

    @Test
    public void shouldCheckoutBookWithGivenTitle(){
        menu.selectOption("checkOut " + bookTitle);
        verify(biblioteca).isBookAvailable(bookTitle.toLowerCase());
    }

//    @Test
//    public void shouldReturnMovieWithGivenTitle(){
//        menu.selectOption("return " + bookTitle);
//        verify(biblioteca).returnBookWithTitle(bookTitle.toLowerCase());
//    }

//    @Test
//    public void shouldCheckoutMovieWithGivenTitle(){
//        menu.selectOption("checKout " + bookTitle);
//        verify(biblioteca).checkoutBookWithTitle(bookTitle.toLowerCase());
//    }

    @Test
    public void shouldLetUserKnowWhenCheckoutFails(){
        when(biblioteca.isBookAvailable(bookTitle)).thenReturn(false);
        menu.selectOption("checKout " + bookTitle);
        verify(printStream).println("Could not check out book with that name.");
    }

    @Test
    public void shouldLetUserKnowWhenCheckoutIsSuccessful(){
        when(biblioteca.isBookAvailable(bookTitle.toLowerCase())).thenReturn(true);
        menu.selectOption("checKout " + bookTitle);
        verify(printStream).println(contains("Success"));
    }

    @Test
    public void shouldQuitApplicationWhenQuitIsSelected(){
        menu.selectOption("Quit");
        assertFalse(menu.isStillAlive());
    }

    @Test
    public void shouldLetUserKnowReturnisSuccessful(){
        when(biblioteca.returnBookWithTitle(bookTitle.toLowerCase())).thenReturn(true);
        menu.selectOption("return " + bookTitle);
        verify(printStream).println(contains("success"));
    }

    @Test
    public void shouldLetUserKnowReturnisUnsuccessful(){
        when(biblioteca.returnBookWithTitle(bookTitle.toLowerCase())).thenReturn(false);
        menu.selectOption("return " + bookTitle);
        verify(printStream).println(contains("not return"));
    }
}
