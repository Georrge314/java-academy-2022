package course.academy.hello;

public class MyEnumeration {
    public enum InvoiceType { SIMPLE, VAT }

    public static void main(String[] args) {
        for (InvoiceType it : InvoiceType.values()) {
            System.out.println(it);
            System.out.println(it.ordinal());
            System.out.println("------------------------------");
        }
    }
}
