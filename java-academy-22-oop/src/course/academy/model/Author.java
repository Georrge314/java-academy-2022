package course.academy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static course.academy.model.Role.*;

public class Author extends User {
    private List<String> ownBlogs;

    public Author(String firstName, String lastName, int age, String username, String password, List<String> ownBlocks) {
        super(firstName, lastName, age, username, password, AUTHOR, true);
        this.ownBlogs = ownBlocks;
    }

    public Author(String firstName, String lastName, int age, String username, String password) {
        super(firstName, lastName, age, username, password, AUTHOR, true);
        this.ownBlogs = new ArrayList<>();
    }

    public List<String> getOwnBlogs() {
        return ownBlogs;
    }

    public void setOwnBlogs(List<String> ownBlogs) {
        this.ownBlogs = ownBlogs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add(super.toString())
                .add("ownBlogs='" + ownBlogs + '\'')
                .toString();
    }
}
