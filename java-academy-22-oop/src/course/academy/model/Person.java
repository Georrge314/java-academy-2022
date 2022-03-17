package course.academy.model;

import course.academy.dao.Identifiable;

import java.util.Objects;
import java.util.StringJoiner;

public class Person implements Identifiable<Long> {
    private static int nextId = 1;

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = (long) nextId++;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    String format() {
        return String.format("| %4d | %12.12s | %12.12s | %3d ",
                id, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ", "", "")
                .add("id='" + id + '\'')
                .add("firstName='" + firstName + '\'')
                .add("lastName='" + lastName + '\'')
                .add("age='" + age + '\'')
                .toString();
    }

    public static void main(String[] args) {
        var p1 = new Person(1L, "John", "Doe", 22);
        var p2 = new Person(2L, "Ivan", "Petrov", 28);
        System.out.println(p1.format());
        System.out.println(p2.format());

    }
}
