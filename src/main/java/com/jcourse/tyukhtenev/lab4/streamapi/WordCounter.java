package com.jcourse.tyukhtenev.lab4.streamapi;

import java.util.Map;

public class WordCounter implements Comparable<WordCounter> {
    public Map.Entry<String, Integer> entry;

    public WordCounter(Map.Entry<String, Integer> entry) {
        this.entry = entry;
    }
    @Override
    public int compareTo(WordCounter wordCounter) {
        int result;
        result = wordCounter.entry.getValue().compareTo(this.entry.getValue());
        if (result == 0) {
            result = this.entry.getKey().compareTo(wordCounter.entry.getKey());
        }
        return result;
    }
}
