package com.jcourse.tyukhtenev.lab4.streamapi;

import com.jcourse.tyukhtenev.lab4.WordCounter;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class WordsFrequency {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(args[0])))))
        {

            int[] count = {0};
            reader
                    .lines()
                    .map(line -> line.split("[^\\pL\\pN]"))
                    .flatMap(array -> Arrays.stream(array)) // Arrays::stream
                    .filter(s -> !s.isEmpty())
                    .peek(a->count[0]++)
                    .collect(toMap(a-> a, a->1, (a, b) ->a+b))

                    .entrySet()
                    .stream()
                    .sorted((a, b) -> {
                        int rs = b.getValue().compareTo(a.getValue());
                        if (rs==0) {
                            rs = a.getKey().compareTo(b.getKey());
                        }
                        return rs;
                    })
                    .forEach(entry -> System.out.println(entry.getKey()+"\t"+entry.getValue()));
        }
     catch (FileNotFoundException e) {
        System.out.println("Не найден файл");
    }
    }
}
