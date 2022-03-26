package course.demos.streams;

import java.util.List;
import java.util.function.Function;

public class StreamApiDemo6 {
    //Function andThen vs compose
    public static void main(String[] args) {
        var list = List.of(1, 20, 30, 50, 100);

        //andThen
        Function<Integer, String> numberToString = String::valueOf;
        Function<Integer, String> stringConcat = numberToString.andThen(s -> s + " :)"); //x -> numberToString.apply(x) + " :)"
        list.stream().map(stringConcat).forEach(System.out::println);

        //compose
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> numToString = quote.compose(String::valueOf);
        list.stream().map(numToString).forEach(System.out::println);
    }
}
