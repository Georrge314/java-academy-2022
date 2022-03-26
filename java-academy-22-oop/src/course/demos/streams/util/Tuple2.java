package course.demos.streams.util;

import java.util.Objects;

public class Tuple2<T1, T2> {
    private T1 element1;
    private T2 element2;

    public Tuple2(T1 element1, T2 element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public T1 getElement1() {
        return element1;
    }

    public T2 getElement2() {
        return element2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple2<?, ?> tuple = (Tuple2<?, ?>) o;
        return Objects.equals(element1, tuple.element1) && Objects.equals(element2, tuple.element2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element1, element2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tuple{");
        sb.append("element1=").append(element1);
        sb.append(", element2=").append(element2);
        sb.append('}');
        return sb.toString();
    }
}
