package course.academy.hello;

public class BitOperations {
    public static String toBinary(int n) {
        StringBuilder br = new StringBuilder();
        do {
            br.append(n % 2);
//           все едно делим на 2
            n = n >> 1;
        } while (n > 0);
        return br.reverse().toString();
    }

    public static int toDecimal(String binary) {
        int result = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            //Взимаме младшият член(1или0) и умножаваме степените на двойката
            // 1 << 0 = 1, 1 << 1 = 1 . 2 = 2, 1 << 2 = 1.2.2 = 4...
            //става като степенуване на 2ката
            result += (binary.charAt(i) - '0') * (1 << j);
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 12;
        System.out.println(toDecimal(toBinary(a)));
    }
}
