package course.academy.hello;

public class ControlFlow {
    public static void main(String[] args) {
        var persons = new Person[] {
                new Person(20, "gosho"),
                new Person(21, "pesho"),
                new Person(31,"ivan"),
        };

        //Създава копие на персон. Ако променим референцията, променяме само копието а не оригинала
        for (Person p : persons) {
            p = new Person(100, "Vasil");
            //след като приключи цикъла копието се затрива от GC;
        }
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
