package course.problems;

import java.util.Scanner;

public class GCDAndLCD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        int y = scan.nextInt();
        System.out.printf("GCD of %d and %d = %d\n", x, y, getGCD(x, y));
        System.out.printf("LCD of %d and %d = %d\n", x, y, getLCD(x, y));
    }

    //84
    //18

    //най-голямото число, което дели две числа без остатък
    public static int getGCD(int a, int b) {
        if (a == b) {
            return a;
        }
        int divider = Math.min(a, b);
        do {
            divider--;
        } while (a % divider != 0 || b % divider != 0);

        return divider;
    }

    //най-малък общ делител
    public static int getLCD(int a, int b) {
        int n = Math.min(a, b);

        for (int i = 2; i <= n; i++) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
