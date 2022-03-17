package course.academy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static course.academy.model.Role.*;

public class Reader extends User {
    private List<String> favoriteBlogs;

    public Reader(String firstName, String lastName, int age, String username, String password, List<String> favoriteBlocks) {
        super(firstName, lastName, age, username, password, READER, true);
        this.favoriteBlogs = favoriteBlocks;
    }

    public Reader(String firstName, String lastName, int age, String username, String password) {
        super(firstName, lastName, age, username, password, READER, true);
        this.favoriteBlogs = new ArrayList<>();
    }

    public List<String> getFavoriteBlogs() {
        return favoriteBlogs;
    }

    public void setFavoriteBlogs(List<String> favoriteBlogs) {
        this.favoriteBlogs = favoriteBlogs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add(super.toString())
                .add("favoriteBlogs='" + favoriteBlogs + '\'')
                .toString();
    }

}
