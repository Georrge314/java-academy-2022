package course.academy.service.impl;

import course.academy.dao.BookRepository;
import course.academy.exception.ConstraintViolationException;
import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;
import course.academy.service.BookService;
import course.academy.util.BookValidator;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.*;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;
    private final BookValidator bookValidator;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
        this.bookValidator = new BookValidator();
    }

    public BookServiceImpl(BookRepository bookRepo, BookValidator bookValidator) {
        this.bookRepo = bookRepo;
        this.bookValidator = bookValidator;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> getAllBooks(Comparator<Book> comp) {
        return bookRepo.findAllSorted(comp);
    }

    @Override
    public List<Book> getAllBooksByDate(boolean ascending) {
        return bookRepo.findAllSortedByDate(ascending);
    }

    @Override
    public Book getBookById(Integer id) throws NonexistingEntityException {
        var book = bookRepo.findById(id);
        if(book == null) {
            throw new NonexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return book;
    }

    @Override
    public Book addBook(Book book) throws InvalidEntityDataException {
        try {
            bookValidator.validateBook(book);
        } catch (ConstraintViolationException ex) {
            throw new InvalidEntityDataException(
                    format("Error creating book '%s'", book.getTitle()),
                    ex);
        }
        return bookRepo.create(book);
    }

    @Override
    public Book updateBook(Book book) throws NonexistingEntityException, InvalidEntityDataException {
        try {
            bookValidator.validateBook(book);
        } catch (ConstraintViolationException ex) {
            throw new InvalidEntityDataException(
                    format("Error creating book '%s'", book.getTitle()),
                    ex);
        }
        return bookRepo.update(book);
    }

    @Override
    public Book deleteBookById(Integer id) throws NonexistingEntityException {
        return bookRepo.deleteById(id);
    }

    @Override
    public long count() {
        return bookRepo.count();
    }
}
