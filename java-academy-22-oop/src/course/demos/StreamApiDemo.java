package course.demos;

import course.demos.util.Tuple2;
import course.demos.util.Tuple2Child;

import java.util.Arrays;
import java.util.function.Function;

public class StreamApiDemo {
    public static void main(String[] args) {
        String[] data = {"hello", "from", "java", "stream", "api"};

        Function<String, String> functionToLower = String::toLowerCase;

        Arrays.stream(data)
                .map(word -> {
                    System.out.println("In map: " + word);
                    return word.toUpperCase();
                })
                .filter(word -> {
                    System.out.println("In filter: " + word);
                    return word.contains("A");
                })
                .map(word -> {
                    System.out.println("In map 2:" + word);
                    return new Tuple2Child(word, word.length());
                })
                .forEach(System.out::println);
    }
}
// ? super Student  -  Student extend ? (родител на класа Student)
// ? extends Student  - ? extend Student (наследник на калса Student)
