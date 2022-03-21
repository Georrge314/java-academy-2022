package course.demos;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo5 {

    //infer argument - компилатора да разбере какъв тип е аргумента
    //High order functions
    public static void main(String[] args) {
        Function<Integer, Integer> test = x -> x + 20;

        //fist class function before java 8
        var isGraterThan100 =  new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 100;
            }
        };

        //fist class function after java 8
        var isLowerThan100 = (Predicate<Integer>) x -> x < 100;

        //function accept function
        List<Integer> integerList = Stream.of(1, 2000, 1231213, 12, 1313, 23)
                .filter(isGraterThan100).collect(Collectors.toList());

        //function return function
        Function<String, Function<List<String>, String>> getFunc = (playerName) -> {
            System.out.println(playerName + "is player");
            return (womenName) -> playerName + " is with " + womenName;
        };
        System.out.println(getFunc.apply("Gosho").apply(List.of("Petq", "Janet", "Mariq", "Viki", "Kameliq")));

        //function take function as argument
        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> highOrderFunc2 =
                (list, predicate) -> list.stream().filter(predicate).collect(Collectors.toList());

        List<Integer> numbers = List.of(123, 152, 151, 102, 185, 146);
        highOrderFunc2.apply(numbers, x -> x % 2 == 0);

    }
}
