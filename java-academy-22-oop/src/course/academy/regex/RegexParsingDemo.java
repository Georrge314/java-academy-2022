package course.academy.regex;

import course.academy.model.Book;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static course.academy.model.MockBooks.MOCK_BOOKS;

public class RegexParsingDemo {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder builder = new StringBuilder();
        for(Book book : MOCK_BOOKS) {
            String dateString = book.getPublishedDate().format(dtf);
            Pattern pattern = Pattern.compile("^(\\d{2}).(\\d{2}).(\\d{4})$");
            Matcher matcher = pattern.matcher(dateString);
            if (matcher.matches()) {
                for (int i = 0; i <= matcher.groupCount(); i++) {
                    System.out.printf("%d -> %s [%d, %d]%n",i, matcher.group(i),
                            matcher.start(i), matcher.end(i));
                }
               builder.append(String.format("| %-50.50s | %2s | %2s | %4s |%n",
                        book.getTitle(), matcher.group(1),
                        matcher.group(2), matcher.group(3)));
            }
        }
        System.out.println(builder);

    }

    
}
