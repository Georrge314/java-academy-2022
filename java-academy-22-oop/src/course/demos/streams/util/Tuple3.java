package course.demos.streams.util;

import java.util.Objects;

public class Tuple3<T1, T2, T3> {
    private T1 element1;
    private T2 element2;
    private T3 element3;

    public Tuple3(T1 element1, T2 element2, T3 element3) {
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
    }

    public T1 getElement1() {
        return element1;
    }

    public T2 getElement2() {
        return element2;
    }

    public T3 getElement3() {
        return element3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(element1, tuple3.element1) && Objects.equals(element2, tuple3.element2) && Objects.equals(element3, tuple3.element3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element1, element2, element3);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tuple3{");
        sb.append("element1=").append(element1);
        sb.append(", element2=").append(element2);
        sb.append(", element3=").append(element3);
        sb.append('}');
        return sb.toString();
    }
}
