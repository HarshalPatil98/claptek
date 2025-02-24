package com.app.bansira;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", "123", "Genre1", 2001, "Dept1", true);
        book2 = new Book("Title2", "Author2", "456", "Genre2", 2002, "Dept2", false);
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        library.addBook(book2);
        library.removeBook("123");

        List<Book> books = library.listAllBooks();
        assertEquals(1, books.size());
        assertEquals("456", books.get(0).getISBN());
    }

    @Test
    public void testFindBookByTitle() {
        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.findBookByTitle("Title1");
        assertEquals(1, books.size());
        assertEquals("123", books.get(0).getISBN());
    }

    @Test
    public void testFindBookByAuthor() {
        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.findBookByAuthor("Author2");
        assertEquals(1, books.size());
        assertEquals("456", books.get(0).getISBN());
    }

    @Test
    public void testListAllBooks() {
        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        library.addBook(book1);
        library.addBook(book2);

        List<Book> books = library.listAvailableBooks();
        assertEquals(1, books.size());
        assertEquals("123", books.get(0).getISBN());
    }
}
