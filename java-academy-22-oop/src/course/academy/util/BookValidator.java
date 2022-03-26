package course.academy.util;

import course.academy.exception.ConstraintViolation;
import course.academy.exception.ConstraintViolationException;
import course.academy.exception.InvalidEntityDataException;
import course.academy.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookValidator {
    public void validateBook(Book book) throws ConstraintViolationException {
        List<ConstraintViolation> violations = new ArrayList<>();
        var titleLength = book.getTitle().trim().length();
        if(titleLength < 2 || titleLength > 50){
            violations.add(
                    new ConstraintViolation(
                            book.getClass().getName(),
                            "title",
                            book.getTitle(),
                            "Book title length should be between 2 and 50 characters."));
        }
        if(book.getPublishedDate().isAfter(LocalDate.now())){
            violations.add(
                    new ConstraintViolation(
                            book.getClass().getName(),
                            "publishedDate",
                            book.getPublishedDate(),
                            "Book '" + book.getTitle() + "' publishing date: '" + book.getPublishedDate() + "' should be in the past."));;
        }
        if (violations.size() > 0) {
            throw new ConstraintViolationException("Invalid Book filed", violations);
        }
    }
}
