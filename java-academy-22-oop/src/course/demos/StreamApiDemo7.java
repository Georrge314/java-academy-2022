package course.demos;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo7 {

    private static class Person {
        private String name;
        private int age;

        public Person(String name) {
            this.name = name;
            this.age = 25;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static class Printer {
        public <V> void print(V value) {
            System.out.println(value);
        }
    }

    //object::instanceMethod - става this (0)
    //Class::staticMethod - идва като аргумент (1)
    //Class::instanceMethod - (System.out::println) идва като аргумент (1)
    //Class::new
    public static void main(String[] args) {
        //object::instanceMethod ||||| person -> person.getName()
        //person става this.GetName()
        Comparator<Person> personNameComp = Comparator.comparing(Person::getName);

        //Class::staticMethod ||||| s -> Integer.parseInt(s)
        int sum = Stream.of("2", "3", "4").mapToInt(Integer::parseInt).sum();


        //Class::instanceMethod - идва като аргумент (1)
        var printer = new Printer();
        Stream.of(1,23,45,623).forEach(printer::print);


        //Class::new - името идва като аргумент на конструктора
        List<Person> people = Stream.of("Ivan", "Pesho", "Dido").map(Person::new).collect(Collectors.toList());

    }
}
