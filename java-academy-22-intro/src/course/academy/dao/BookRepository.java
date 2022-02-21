package course.academy.dao;

import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.Book;

public interface BookRepository {
    Book create(Book book) throws InvalidRepositoryStateException;
    Book update(Book book) throws InvalidRepositoryStateException;
    Book deleteById(int id) throws InvalidRepositoryStateException;
    Book findById(int id) throws InvalidRepositoryStateException;
    Book[] findAll();
    int size();
}
