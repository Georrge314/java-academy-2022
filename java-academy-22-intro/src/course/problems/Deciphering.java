package course.problems;

import java.io.*;
import java.util.*;

public class Deciphering {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        char[] chars = scan.nextLine().toCharArray();
        Arrays.sort(chars);
        String word = String.valueOf(chars);

        StringBuilder builder = new StringBuilder();
        String path = "";
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = builder.toString();

        Map<String, Integer> wordCounts = new HashMap<>();
        int index = 0;
        while (index + word.length() <= text.length()) {
            String currWord = text.substring(index, index + word.length());
            index++;
            if (wordCounts.containsKey(currWord)) {
                wordCounts.put(currWord, wordCounts.get(currWord) + 1);
                continue;
            }

            char[] currWordChars = currWord.toCharArray();
            Arrays.sort(currWordChars);
            String sorted = String.valueOf(currWordChars);
            if (sorted.equals(word)) {
                wordCounts.put(currWord, 1);
            }
        }
        int allWords = 0;
        for (Integer count : wordCounts.values()) {
            allWords += count;
        }
        System.out.println(allWords);

        Comparator<Map.Entry<String, Integer>> customComparator = (e1, e2) -> {
            return e1.getValue() > e2.getValue() ? -1 :
                    e1.getValue() < e2.getValue() ? 1 :
                            e1.getKey().compareTo(e2.getKey());
        };

        int finalSize = allWords;
        wordCounts.entrySet().stream().sorted(customComparator).limit(20).forEach(e -> {
            System.out.print(String.format("%s: %d, ", e.getKey(), e.getValue()) +
                    fmt((double) e.getValue() / finalSize * 100));
        });
    }

    public static String fmt(double d) {
        if (d == (long) d) {
            return String.format("%d%%\n", (long) d);
        } else {
            return String.format("%.2f%%\n", d);
        }
    }
}