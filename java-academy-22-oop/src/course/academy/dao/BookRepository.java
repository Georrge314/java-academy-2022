package course.academy.dao;

import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.model.Book;

/**
 * public interface for managing lifecycle of Book objects
 */
public interface BookRepository {
    /**
     * create book in our repository
     * @param book
     * @return created book
     */
    Book create(Book book) throws InvalidRepositoryStateException;
    /**
     * update existing book
     * @param book
     * @return updated book
     */
    Book update(Book book) throws InvalidRepositoryStateException;
    /**
     * delete existing book by id
     * @param id
     * @return deleted book
     * @throws InvalidRepositoryStateException
     */
    Book deleteById(int id) throws InvalidRepositoryStateException;
    /**
     * find book by id
     * @param id
     * @return book by id
     * @throws InvalidRepositoryStateException
     */
    Book findById(int id) throws InvalidRepositoryStateException;
    /**
     * find all books
     * @return array of all books
     */
    Book[] findAll();
    /**
     * get size of the repository
     * @return size of the repository
     */
    int size();
}
