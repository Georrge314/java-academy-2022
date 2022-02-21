package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.Book;

import java.util.Arrays;

public class BookRepositoryImpl implements BookRepository {
    private static final int MAX_BOOKS = 10;
    private static int nextId = 1;

    private Book[] books = new Book[MAX_BOOKS];
    private int len = 0;

    @Override
    public Book create(Book book) throws InvalidRepositoryStateException {
        if (len < books.length) {
            book.setId(nextId++);
            books[len++] = book;
            return book;
        }
        throw new InvalidRepositoryStateException("Repository full (capacity = " + books.length + ").");
    }

    @Override
    public Book update(Book book) throws InvalidRepositoryStateException {
        int index = findIndexById(book.getId());
        if (index >= 0) books[index] = book;
        throw new InvalidRepositoryStateException("Book with id:" + book.getId() + " not found");
    }

    @Override
    public Book deleteById(int id) throws InvalidRepositoryStateException {
        int index = findIndexById(id);
        if (index >= 0) {
            Book book = books[index];
            for (int i = index; i < books.length - 1; i++) {
                books[i] = books[i + 1];
            }
            len--;
            return book;
        }
        throw new InvalidRepositoryStateException("Book with id: " + id + "not found.");
    }

    @Override
    public Book findById(int id) throws InvalidRepositoryStateException {
        //Ако книгата не съществува ще върне -1
        int index = findIndexById(id);
        if (index >= 0) {
            return books[index];
        }
        throw new InvalidRepositoryStateException("Book with id: " + id + "not found.");
    }

    @Override
    public Book[] findAll() {
        return Arrays.copyOf(books, len);
    }

    @Override
    public int size() {
        return len;
    }

    private int findIndexById(int id) {
        return Arrays.binarySearch(books, new Book(id));
    }
}