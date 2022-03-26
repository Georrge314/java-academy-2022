package course.demos.streams;


import java.util.concurrent.Callable;
import java.util.function.*;

public class StreamApiDemo4 {
    static class Hello implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }

    static class Hi implements Runnable {

        @Override
        public void run() {
            for (int i = 9; i >= 0; i--) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World!";
        Consumer<String> consumer = name -> System.out.println(name);
        Predicate<String> predicate = name -> name.length() > 4;
        Function<String, char[]> function = x -> x.toCharArray();
        BiFunction<Integer, Integer, Boolean> biFunction = (x, y) -> x >= y && y > 0;
        BiConsumer<Integer, String> biConsumer = (age, name) -> System.out.println(name + "is " + age + " years old");
        BiPredicate<Integer, String> biPredicate = (age, name) -> age >= 25 && name.length() >= 4;
        UnaryOperator<String> unaryOperator = name -> name.toUpperCase();
        BinaryOperator<String> binaryOperator = (name1, name2) -> name1 + " " + name2;
        Callable<Integer> callable = () -> Integer.parseInt("gosho");
        Runnable runnable;
        Thread thread1 = new Thread(new Hello());
        Thread thread2 = new Thread(new Hi());
        Thread thread3 = new Thread(() -> System.out.println("Good evening"));
        thread1.start();
        thread2.start();
    }
}
