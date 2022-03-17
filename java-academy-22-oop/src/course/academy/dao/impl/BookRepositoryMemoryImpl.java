package course.academy.dao.impl;

import course.academy.dao.BookRepository;
import course.academy.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

class BookRepositoryMemoryImpl extends AbstractPersistableRepository<Integer, Book>
        implements BookRepository {
    private NavigableMap<LocalDate, List<Book>> booksByDate = new TreeMap<>();

    public BookRepositoryMemoryImpl(IdGenerator<Integer> idGenerator) {
        super(idGenerator);
    }

    @Override
    public Book create(Book book) {
        booksByDate.putIfAbsent(book.getPublishedDate(), new ArrayList<>());
        booksByDate.get(book.getPublishedDate()).add(book); // index each book by date
        return super.create(book);
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    @Override
    public List<Book> findAllSortedByDate(boolean ascending) { // O(1)
        var valuesMap =  booksByDate;
        if(!ascending) {
            valuesMap = valuesMap.descendingMap();
        }
        System.out.println("Book.findAllSorted() called.");
        List<Book> results = new ArrayList<>();
        for(List<Book> listByDate: valuesMap.values()){
            results.addAll(listByDate);
        }
        return results;
    }

}
