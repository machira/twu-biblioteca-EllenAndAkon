package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/16/15.
 */
public class BibliotecaTest {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;
    private List<Movie> movies;
    private Book book1, book2, book3;
    private Movie movie1, movie2, movie3;
    private BufferedReader reader;

    @Before
    public void setUp() {
        movies = new ArrayList<Movie>();
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        reader = mock(BufferedReader.class);
        book1 = mock(Book.class);
        when(book1.toString()).thenReturn("Book 1");
        book2 = mock(Book.class);
        when(book2.toString()).thenReturn("Book 2");
        book3 = mock(Book.class);
        when(book3.toString()).thenReturn("Book 3");


        biblioteca = new Biblioteca(printStream, books, movies);


        movie1 = mock(Movie.class);
        movie2 = mock(Movie.class);
        movie3 = mock(Movie.class);
        when(movie1.toString()).thenReturn("Movie1");
        when(movie2.toString()).thenReturn("Movie2!");
        when(movie3.toString()).thenReturn("Movie3-");
    }


    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Biblioteca biblioteca = new Biblioteca(printStream,new ArrayList<Book>(),new ArrayList<Movie>());
        biblioteca.listBooks();

        verify(printStream).println("");
    }

    @Test
    public void shouldPrintOneBookWhenThereIsOneBook() {
        books.add(book1);
        biblioteca.listBooks();
        verify(printStream).println("Book 1");
    }

    @Test
    public void shouldPrintAllBooksWhenThereAreMoreThanOneBook() {

        books.add(book1);
        books.add(book2);
        books.add(book3);
        biblioteca.listBooks();

        verify(printStream).println("Book 1");
        verify(printStream).println("Book 2");
        verify(printStream).println("Book 3");
    }

    @Test
    public void shouldPrintAllMoviesWhenThereIsMoreThanOneMovie(){

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        biblioteca.listMovies();

        verify(printStream).println("Movie1");
        verify(printStream).println("Movie2!");
        verify(printStream).println("Movie3-");
    }

    @Test
    public void shouldNotIncludeCheckedOutBooksInList() {
        Book book4 = new Book("Akon's thesis", "Akon", "4000");
        Book book5 = new Book("Conversations on String Theory", "Raymond", "1991");
        books.add(book4);
        books.add(book5);
        biblioteca.checkout(book4);
        biblioteca.listBooks();

        verify(printStream, never()).format(anyString(), eq("Akon's thesis"), eq("Akon"), eq("4000"));
    }

    @Test
    public void shouldReturnFalseIfBookIsAlreadyCheckedOut() {
        Book book4 = new Book("Akon's thesis", "Akon", "4000");
        books.add(book4);
        book4.checkout();
        assertFalse(biblioteca.checkout(book4));
    }

    @Test
    public void shouldReturnTrueIfBookIsNotAlreadyCheckedOut() {
        Book book4 = new Book("Akon's thesis", "Akon", "4000");
        books.add(book4);
        assertTrue(biblioteca.checkout(book4));
    }

    @Test
    public void shouldBeAbleToReturnBooks(){
        when(book1.checkIn()).thenReturn(true);
        when(book2.checkIn()).thenReturn(false);
        assertEquals(biblioteca.returnBook(book1), true);
        assertFalse(biblioteca.returnBook(book2));
    }

}



