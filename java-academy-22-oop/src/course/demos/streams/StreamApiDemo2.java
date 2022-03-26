package course.demos.streams;

import course.demos.streams.util.StreamUtil;
import course.demos.streams.util.Tuple2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiDemo2 {
    public static <T> Stream<T> createStream(Collection<T> values) {
        return values == null ? Stream.empty() : values.stream();
    }

    public static void main(String[] args) {
        var empty = Stream.empty();

        var values = Stream.of("hello", "functional", "java", "stream", "api");
//        values.forEach(System.out::println);
//        System.out.println();

        var values2 = createStream(List.of("hello", "functional", "java", "stream", "api"));
//        values2.forEach(System.out::println);
//        System.out.println();

        var streamOfArrayValues = Arrays.stream(new String[]{"hello", "functional", "java", "stream", "api"}, 1, 4);
//        streamOfArrayValues.forEach(System.out::println);


        var streamBuilder = Stream.<String>builder()
                .add("hello").add("functional").add("java").add("stream").add("api").build();
//        streamBuilder.forEach(System.out::println);

        var streamGenerated = Stream.generate(Math::random).limit(100);
//        streamGenerated.forEach(System.out::println);

        var counter = new AtomicInteger();
        var countedRandoms = Stream
                        .generate(() -> new Tuple2<>(counter.incrementAndGet(), Math.random()))
                        .limit(100);
//        countedRandoms.forEach(tuple2 -> System.out.println(tuple2.getElement1() + " " + tuple2.getElement2()));

        var counterStream = IntStream.iterate(1, i -> i + 1).boxed();
//        counterStream.forEach(System.out::println);

        var countedRandomsZip =
                StreamUtil.zip(counterStream, streamGenerated, Tuple2::new);

//        countedRandomsZip.forEach(tuple -> System.out.println(tuple.getElement1() + " " + tuple.getElement2()));

        //String stream
        var charsStream = values.flatMapToInt(String::chars);
        charsStream.forEach(ch -> System.out.print((char) ch + " "));

    }
}
