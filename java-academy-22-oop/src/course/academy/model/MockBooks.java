package course.academy.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MockBooks {
    //Този клас се състой само то полета на класа. Нямаме нужда от инстанция
    //Можем да променяме стойностите, но не можем да сложим на същата памет нов масив, тъй като е "final"
    //атрибута и блока ще се заредят последователно след първото извикване на класа.
    public static final Book[] MOCK_BOOKS;
    static {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        MOCK_BOOKS = new Book[]{
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
                new Book("Thinking in Java", "Georgi Petrov", LocalDate.parse("11.10.2005", dtf), "Ivan Ivanov"),
        };
    }
}
