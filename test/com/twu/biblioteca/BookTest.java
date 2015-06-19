package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
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
    public void shouldPrintDetails() {
        String string = book.toString();
        assertEquals("Book Title           Author               2000                \n",string);
    }

    @Test
    public void shouldReturnTrueWhenCheckedOut() {
        book.checkout();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void shouldReturnTrueWhenReturned() {
        book.checkout();
        assertTrue(book.checkIn());
    }


}
