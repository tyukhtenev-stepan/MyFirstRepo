package com.jcourse.tyukhtenev.lab4;

import java.io.*;
import java.util.*;

public class WordsFrequency {
    public static void main(String[] args) throws Exception {
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(args[0])), "cp1251")) {

            Map<String, Integer> frequency = new HashMap<>();
            StringBuilder sbuilder = new StringBuilder();

            int currentChar = 0; //Текущий символ
            int wordCount = 0; //Счетчик всех слов

            while (currentChar != -1) {
                currentChar = r.read();

                if (Character.isLetterOrDigit((char) currentChar)) {
                    sbuilder.append((char) currentChar);
                } else {
                    String word;
                    word = sbuilder.toString(); // слово из буфера
                    sbuilder.setLength(0);

                    int val = 1; //первое значение из hashmap
                    if (frequency.containsKey(word) && word.length() > 0) {
                        val = val + frequency.get(word);
                    }
                    if (word.length() > 0) {
                        frequency.put(word, val);
                    }
                }
            }
            System.out.println(frequency);

            List<WordCounter> list = new ArrayList<WordCounter>();
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                list.add(new WordCounter(entry));
            }

            Collections.sort(list);

            for (int z : frequency.values()) {
                wordCount = wordCount + z;
            }

            try (Writer out = new OutputStreamWriter(new FileOutputStream("output.csv"), "cp1251")) {
                for (WordCounter str : list) {
                    out.write(str.entry.getKey() + ";" + str.entry.getValue() + ";" + (double) str.entry.getValue() / wordCount * 100 + "%\n");
                }
            } catch (IOException e) {
                System.out.println("Не могу сохранить файл");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл");
        }
    }
}
