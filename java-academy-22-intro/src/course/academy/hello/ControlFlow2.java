package course.academy.hello;

public class ControlFlow2 {
    public static void main(String[] args) {

        int x = 5;
        outer_label:
        while (true) {
            System.out.println("first loop");
            while (true) {
                x++;
                if (x == 10) {
                    break outer_label;
                }
            }
        }

        System.out.println("end of the programm");
    }
}
