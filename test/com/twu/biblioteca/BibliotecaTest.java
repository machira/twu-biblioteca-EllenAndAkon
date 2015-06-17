package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/16/15.
 */
public class BibliotecaTest {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;
    private Book book1, book2, book3;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(printStream, books);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
    }

    @Test
    public void testWelcomeMessagePrints(){

        biblioteca.start();

        verify(printStream).println("Welcome to Biblioteca!");

    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        biblioteca.listBooks();

        verify(printStream).println("");
    }

    @Test
    public void shouldPrintOneBookWhenThereIsOneBook() {
        books.add(book1);
        biblioteca.listBooks();

        verify(printStream).println(anyString());
    }

    @Test
    public void shouldPrintAllBooksWhenThereAreMoreThanOneBook() {
        books.add(book1);
        books.add(book2);
        books.add(book3);
        biblioteca.listBooks();

        verify(printStream).println(anyString());
        verify(printStream).println(anyString());
        verify(printStream).println(anyString());
    }

    @Test
    public void shouldDisplayMenuOnStart(){
        biblioteca.start();

        verify(printStream).println(contains("MAIN MENU"));
    }

    @Test
    public void shouldAskForUserInputWhenMenuIsShown() {
        biblioteca.start();
        verify(printStream).println("Enter your selection");
    }

    @Test
    public void shouldHandleInvalidUserInput() {
        biblioteca.start();
        biblioteca.selectOption("boo");
        verify(printStream).println("That's not a valid option");
    }

    @Test
    public void shouldHandleValidUserInput(){
        Biblioteca spy = spy(biblioteca);
        spy.start();
        spy.selectOption("LISt books");
        verify(spy).listBooks();
    }


}



