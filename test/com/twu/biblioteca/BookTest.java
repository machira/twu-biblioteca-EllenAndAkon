package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.contains;
import static org.mockito.Mockito.verify;

public class BookTest {

    private String title;
    private String author;
    private String yearPublished;
    private Book book;

    @Before
    public void setUp() {
        title = "Book Title";
        author = "Author";
        yearPublished = "2000";
        book = new Book(title, author, yearPublished);
    }

    @Test
    public void testBookHasTitle() {
        assertEquals(book.getTitle(), title);
    }

    @Test
    public void shouldHaveAnAuthor() {
        assertEquals(book.getAuthor(), author);
    }

    @Test
    public void shouldHaveAYearPublished() {
        assertEquals(book.getYearPublished(), yearPublished);
    }

    @Test
    public void shouldPrintDetails() {
        PrintStream printStream = mock(PrintStream.class);
        book.printDetails(printStream);
        verify(printStream).format(anyString(), eq(title), eq(author), eq(yearPublished));
    }

}
