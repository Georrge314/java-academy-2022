package course.academy.model;

import course.academy.dao.Identifiable;

import java.time.LocalDate;
import java.util.Objects;

//Указваме с какъв друг обект може да бъде сравнявана една книга
public class Book implements Identifiable<Integer>, Comparable<Book> {
    private int id;
    private String title;
    private String publisher;
    private LocalDate publishedDate;
    private String author;
    private String description;

    public Book(String title, String publisher, LocalDate publishedDate) {
        this.title = title;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    //Constructor overloading
    public Book(String title, String publisher, LocalDate publishedDate, String author) {
        this(title, publisher, publishedDate);
        this.author = author;
    }

    public Book(String title, String publisher, LocalDate publishedDate, String author, String description) {
        this(title, publisher, publishedDate);
        this.author = author;
        this.description = description;
    }

    //използваме го за двуично търсене на id
    public Book(int id) {
        this.id = id;
    }

    //Lazy initializing
    //Използва се за полета с огромно количесвто данни или за методи които се използват рядко в програмата
    public String getDescription() {
        if (description == null) {
            description = this.toString();
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    //Със Стринг Билдър е по-бързо
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", publishedDate=").append(publishedDate);
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //Използваме анотацията override за да кажем на компилатора че презаписваме метод от базов клас.
    //Така той може да провери дали наистина има такъв метод.
    //Проверява дали два обеката са еднавки по общ критерии. Не по място в паметта!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    //За тези два метода трябва да бъде използван един и същ критерии.
    //Този хаш код е различен от хаша в динамичната памет.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Book other) {
        return this.getId() - other.getId();
    }
}
