package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.dao.Persistable;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPersistableBookRepository implements BookRepository, Persistable {
    private Map<Integer, Book> books = new HashMap<>();
    private IdGenerator<Integer> idGenerator = new IntegerIdGenerator();

    @Override
    public Collection<Book> findAll() {
        return books.values();
    }

    @Override
    public Book findById(Integer id) {
        return books.get(id);
    }

    @Override
    public Book create(Book book) {
        book.setId(idGenerator.getNextId());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) throws NonexistingEntityException {
        Book old = findById(book.getId());
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + book.getId() + "' does not exist.");
        }
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book deleteById(Integer id) throws NonexistingEntityException {
        Book old = books.remove(id);
        if(old == null) {
            throw new NonexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return books.size();
    }
}
