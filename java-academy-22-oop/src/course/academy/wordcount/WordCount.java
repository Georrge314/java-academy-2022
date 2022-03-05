package course.academy.wordcount;

import java.util.Objects;

public class WordCount implements Comparable<WordCount> {
    private String word;
    private int count;

    public WordCount() {
    }

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return word.equals(wordCount.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(word).append(": ").append(count);
        return sb.toString();
    }

    //естествена подредба
    @Override
    public int compareTo(WordCount other) {
        return word.compareTo(other.word);
    }
}
