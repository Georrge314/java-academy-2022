package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.dao.impl.BookRepositoryImpl;
import course.academy.model.Book;
import course.academy.model.MockBooks;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        for (Book book : MockBooks.MOCK_BOOKS) {
            try {
                bookRepository.create(book);
            } catch (InvalidRepositoryStateException e) {
                e.printStackTrace();
                break;
            }
        }

        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
    }
}
