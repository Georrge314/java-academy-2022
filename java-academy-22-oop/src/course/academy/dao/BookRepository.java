package course.academy.dao;


import course.academy.model.Book;

import java.util.List;

public interface BookRepository extends Repository<Integer, Book> {
    List<Book> findAllSortedByDate(boolean ascending);
}
