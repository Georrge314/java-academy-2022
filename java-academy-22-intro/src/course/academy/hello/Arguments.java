package course.academy.hello;

public class Arguments {

    //формален аргумент(създава се копие на актуалният аргумент)
    public static Person incrementAgeBy10(Person person) {
        //нова референция
        return new Person(person.getAge() + 10, person.getName());
    }
    //копие на "n"
    public static void increment(int n) {
        n += 1;
        //след това н ще се затрие
    }

    public static void main(String[] args) {
        var person = new Person(21, "gosho");
        //актуален аргумент
        var olderPerson = incrementAgeBy10(person);
        System.out.println(person);
        System.out.println(olderPerson);
        System.out.println(person == olderPerson);
    }
}
