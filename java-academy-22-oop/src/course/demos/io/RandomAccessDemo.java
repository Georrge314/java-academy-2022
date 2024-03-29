package course.demos.io;

import java.io.*;
import java.util.Random;

public class RandomAccessDemo {
    public static void main(String[] args) {
        //write data
        try (var f = new RandomAccessFile("data.db", "rw")) {
            new Random().doubles(10)
                    .forEach(r -> {
                        try {
                            f.writeDouble(r);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            f.seek(4 * 8); //got to 5-th record
            f.writeDouble(42.0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read data
        try (var f = new RandomAccessFile("data.db", "rw")) {
            try {
                for(int i = 0;; i++) {
                    var d = f.readDouble();
                    System.out.printf("%d -> %f%n", i, d);
                }
            } catch (EOFException e) {
                System.out.println("<END OF FILE>");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
