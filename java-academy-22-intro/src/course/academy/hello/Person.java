package course.academy.hello;

import java.util.Objects;

//Всеки клас имплицитно разширява Object
public class Person {
    //казва се атрибут на обкета, а при извикване се казва пропърти на обекта.
    //при създаване на нов обекти
    //ако не се сетне age
    //той ще се инициализира с дефолтната му стойносто, която е нула
    //това не е локална променлива
    private int age;
    private String name = "Anonymous";

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name + ": " + this.age;
    }
}
