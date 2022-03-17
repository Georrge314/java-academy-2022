package course.academy;


import course.academy.dao.BookRepository;
import course.academy.dao.DaoFactory;
import course.academy.dao.impl.DaoFactoryImpl;
import course.academy.exception.InvalidEntityDataException;
import course.academy.exception.NonexistingEntityException;
import course.academy.model.Book;
import course.academy.model.MockBooks;
import course.academy.service.BookService;
import course.academy.service.impl.BookServiceImpl;
import course.academy.view.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NonexistingEntityException {
        DaoFactory daoFactory = new DaoFactoryImpl();
        BookRepository bookRepository = daoFactory.createBookRepository();

        BookService bookService = new BookServiceImpl(bookRepository);

        for(Book book : MockBooks.MOCK_BOOKS){
            try {
                bookService.addBook(book);
            } catch (InvalidEntityDataException e) {
                e.printStackTrace();
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        var invalidBook = new Book("Thinking in Java", "Bruce Eckel", LocalDate.parse("10.02.2016", dtf),
                "Pearson", "Detailed introduction to Java programming.");
        try {
            bookService.addBook(invalidBook);
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }

        bookService.deleteBookById(2);
        for(Book book : bookService.getAllBooks(new Comparator<Book>(){
            @Override
            public int compare(Book book, Book other) {
                return book.getPublishedDate().compareTo(other.getPublishedDate());
            }
        }.reversed())) {
            System.out.println(book);
        }

        System.out.println();

        Book thirdBook = bookService.getBookById(3);
        System.out.println(thirdBook);

        try {
            System.out.println(bookService.getBookById(4));
        } catch (NonexistingEntityException ex) {
            ex.printStackTrace();
        }

        System.out.println();
        thirdBook.setTitle("Third Book");
        bookService.updateBook(thirdBook);
        System.out.println(bookService.getBookById(3));
        System.out.println("Program finished normally.");


        var menu = new Menu("Main Menu", List.of(
                new Menu.Option("Load Books", new Menu.Command() {
                    @Override
                    public String execute() {
                        System.out.println("Loading books ...");
                        return "Books loaded successfully.";
                    }
                }),
                new Menu.Option("Save Books", new Menu.Command() {
                    @Override
                    public String execute() {
                        System.out.println("Saving books ...");
                        return "Books saved successfully.";
                    }
                })
        ));

//        var exitCommand = menu.new ExitCommand();
        menu.show();
    }
}
