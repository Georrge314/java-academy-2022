package course.academy.model;

import java.util.StringJoiner;

import static course.academy.model.Role.*;

public class User extends Person {
    private String username;
    private String password;
    private Role role = READER;
    private boolean active = true;

    public User() {
        super(); // by default
    }

    public User(Long id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, int age, String username, String password) {
        super(firstName, lastName, age);
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, int age, String username, String password, Role role, boolean active) {
        super(firstName, lastName, age);
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public User(Long id) {
        super(id);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String format() {
        return String.format("| %s | %-15.15s | %-15.15s | %-6.6s | %5.5b",
                super.format(), username, password, role.name(), active);
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ", "", "")
                .add(super.toString())
                .add("username='" + username + '\'')
                .add("password='" + password + '\'')
                .add("role='" + role + '\'')
                .add("active='" + active + '\'')
                .toString();
    }
}
