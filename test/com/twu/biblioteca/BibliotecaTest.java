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

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(printStream, books);
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
        books.add(new Book("Harry Potter", "JK Rowling", "10"));
        biblioteca.listBooks();

        verify(printStream).println("Harry Potter - JK Rowling - 10");
    }

    @Test
    public void shouldPrintAllBooksWhenThereAreMoreThanOneBook() {
        books.add(new Book("Harry Potter", "JK Rowling", "10"));
        books.add(new Book("Lord of the Rings", "", "10"));
        biblioteca.listBooks();

        verify(printStream).println("Harry Potter - JK Rowling - 10");
        verify(printStream).println("Lord of the Rings -  - 10");
    }

    @Test
    public void shouldDisplayMenuOnStart(){
        biblioteca.start();

        verify(printStream).println(contains("List Books"));
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



