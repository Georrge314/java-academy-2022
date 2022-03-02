package course.academy.hello;

public class Operators {
    public static int operators(int x, int y, int z) {
        //each number has the priority of the expression
        //[6] [1] [2] [3]  [4] [1][3][1][5][1][5][1]
        return ++x / z >= 4 && -y == -6 ? --x : ++x;
    }

    public static void main(String[] args) {
        int x = 15;
        int y = 6;
        int z = 4;

        System.out.println(operators(x, y, z));
    }
}
