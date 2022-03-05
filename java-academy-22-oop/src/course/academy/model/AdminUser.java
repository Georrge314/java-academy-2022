package course.academy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static course.academy.model.Role.*;

public class AdminUser extends User {
    private String email;

    public AdminUser(String firstName, String lastName, int age, String username, String password, String email) {
        super(firstName, lastName, age, username, password, ADMIN, true);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ",  "", "")
                .add(super.toString())
                .add("email='" + email + '\'')
                .toString();
    }

    public static void main(String[] args) {
        List<String> blogs = new ArrayList<>();
        blogs.add("Something 1234");
        blogs.add("Something 5678");
        blogs.add("Something 9101112");

        var admin1 = new AdminUser("Ivan", "Georgiev", 25, "ivan2022","123456","ivan@gmail.com");
        var author1 = new AuthorUser("Mario", "Vasilev", 35, "mario1997","123456", blogs);
        var reader1 = new ReaderUser("Pesho", "Tolev", 45, "pesho123","123456", blogs);
        var author2 = new AuthorUser("Dave", "Marionov", 38,"dave1990", "12314125");
        var reader2 = new ReaderUser("Maria", "Petrova", 31,"mariaPe88", "dasdsagdfs");

        System.out.println(admin1);
        System.out.println(author1);
        System.out.println(reader1);
        System.out.println(author2);
        System.out.println(reader2);
    }
}
