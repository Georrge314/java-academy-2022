package course.academy;

import course.academy.dao.BookRepository;
import course.academy.dao.exception.InvalidRepositoryStateException;
import course.academy.dao.impl.BookRepositoryImpl;
import course.academy.model.Book;
import course.academy.model.MockBooks;

public class Main {
    public static void main(String[] args) {
        //Трябва да зависим от интерфейс а не от имплементация
        BookRepository bookRepository = new BookRepositoryImpl();
        //При достъпването на класа MockBooks ще се заредят статичните полета
        for (Book book : MockBooks.MOCK_BOOKS) {
            try {
                bookRepository.create(book);
            } catch (InvalidRepositoryStateException e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            bookRepository.deleteById(3);
            Book bookById = bookRepository.findById(5);
            bookById.setDescription("This book was updated!");
            bookRepository.update(bookById);
            System.out.println(bookRepository.findById(5).getDescription());
        } catch (InvalidRepositoryStateException e) {
            e.printStackTrace();
        }


        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }

    }
}
