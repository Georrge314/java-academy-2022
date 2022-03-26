package course.demos.streams;

import course.demos.streams.util.Letter;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Function;

import static course.demos.streams.Example.*;

public class StreamApiDemo8 {
    //partial function application, currying and closure.
    public static void main(String[] args) {
        //currying

        //simple currying example
        BiFunction<String, String, Letter> letterCreator =
                (salutation, body) -> new Letter(salutation, body);
        Function<String, Function<String, Letter>> letterCreator2 =
                salutation -> body -> new Letter(salutation, body);


        //advanced currying example
        Function<String, Function<String, Function<LocalDate, Function<String,
                Function<String, Function<String, Letter>>>>>> letterCreatorCurrying =
                returnAddress
                        -> closing
                        -> dateOfLetter
                        -> insideAddress
                        -> salutation
                        -> body
                        -> new Letter(returnAddress, insideAddress, dateOfLetter, salutation, body, closing);
        var letter = letterCreatorCurrying
                .apply("Address")
                .apply("Closing")
                .apply(LocalDate.of(2023, 11, 25))
                .apply("InsideAddress")
                .apply("Salutation")
                .apply("Body");

        //we can easily pre-fill the first few parameters
        Function<String, Function<LocalDate, Function<String, Function<String, Function<String, Letter>>>>> letterCreatorPrefilled =
                returningAddress -> letterCreatorCurrying.apply(returningAddress).apply("Closing");
        letterCreatorPrefilled.apply("Address")
                .apply(LocalDate.of(2023, 11, 25))
                .apply("InsideAddress")
                .apply("Salutation")
                .apply("Body");
        //It's more understandable with builder pattern!

        //Closures example
        NumberToMonth numberToMonth = new NumberToMonth() {
            String[] months = {
                    "Jan", "Feb", "Mar",
                    "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep",
                    "Oct", "Nov", "Dec"
            };

            //this uses closures
            @Override
            public String toMonth(int n) {
                return (n > 0 && n <= months.length)
                        ? months[n - 1]
                        : null;
            }
        };

        //Partial Application example (uses closure)

        //from biFunc -> Func (method with 2 args and result is biFunc)
        var adder = partial(Example::add, 10);
        System.out.println(adder.apply(100));

        //from biFunc -> Func
        BiFunction<Integer, Integer, Integer> minus = (x, y) -> x - y;
        Function<Integer, Integer> subtractor = partial(minus, 170);
        System.out.println(subtractor.apply(71));

        //from fourFunc - Func
        FourFunction<Integer, Integer, Integer, Integer, Integer> fourFunction =
                (x,y,z,w) -> x * y * z * w;
        var multiplayer = partial(fourFunction, 2, 5, 2);
        System.out.println(multiplayer.apply(10));

        //from fourFunc - biFunc
        //partial(4func, x,  y) = 2func(z,w)
        System.out.println(partial(fourFunction, 20, 3).apply(2, 5));




    }
}

class Example {
    //example of pure function
    public static int add(int x, int y) {
        return x + y;
    }

    public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> function, T x) {
        return (y) -> function.apply(x, y);
    }

    public static <T, U, V, E, R> Function<E, R> partial(FourFunction<T, U, V, E, R> function, T x, U y, V z) {
        return (w) -> function.apply(x, y, z, w);
    }

    public static <T, U, V, E, R> BiFunction<V, E, R> partial(FourFunction<T, U, V, E, R> function, T x, U y) {
        return (z,w) -> function.apply(x, y, z, w);
    }
}

@FunctionalInterface
interface FourFunction<T, U, V, E, R> {
    R apply(T a, U b, V c, E d);
}

@FunctionalInterface
interface NumberToMonth {
    String toMonth(int n);
}