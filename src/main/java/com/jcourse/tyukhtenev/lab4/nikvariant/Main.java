package com.jcourse.tyukhtenev.lab4.nikvariant;

import java.io.*;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            out.println("Expect two args");
            return;
        }
// вариант через Stream API
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(
                new BufferedInputStream(new FileInputStream(args[0]))))) {
            //Matcher regxp =
            int[] count = {0};
            Comparator<Map.Entry<String, Integer>> entryComparator = (a, b) -> {
                int rs = b.getValue().compareTo(a.getValue());
                if (rs == 0) {
                    rs = a.getKey().compareTo(b.getKey());
                }
                return rs;
            };
            reader
                    .lines()
                    .map(line -> line.split("[^\\pL\\pN]"))
                    .flatMap(Arrays::stream)
                    .filter(s -> !s.isEmpty())
                    .peek(a->count[0]++)
                    .collect(toMap(a->a, a->1, (a, b)->a+b))
                    .entrySet()
                    .stream()
                    .sorted(entryComparator)
                    .forEach(entry-> out.println(entry.getKey()+"\t"+entry.getValue()));
        }
    }
}

/* Вариант чтения по байтово
        Map<String, Integer> words = new HashMap<>();
        float total = readAndCountAllWords(args[0], words);
        List<Map.Entry<String, Integer>> allWords = new ArrayList<>(words.entrySet());
        allWords.sort((a,b) ->{
            int rs = Integer.compare(b.getValue(), a.getValue());
            if(rs==0){
                String word1 = a.getKey();
                String word2 = b.getKey();
                rs = word1.compareTo(word2);
            }
            return rs;
        });
        for (Map.Entry<String, Integer> pair : allWords) {
            System.out.printf("%s\t%s\t%s%%%n", pair.getKey(), pair.getValue(), pair.getValue()/total*100.0f);
        }
    }
    private static int readAndCountAllWords(String fileName, Map<String, Integer> words) throws IOException {
        try(Reader reader = new InputStreamReader(
                new BufferedInputStream(new FileInputStream(fileName)))){
            int c;
            int total = 0;
            StringBuilder sb = new StringBuilder();
            while((c=reader.read())!=-1){
                char ch = (char)c;
                if(Character.isLetterOrDigit(ch)){
                    sb.append(ch);
                    continue;
                }
                total += addCurrentWord(words, sb);
            }
            total += addCurrentWord(words, sb);
            return total;
        }
    }
    private static int addCurrentWord(Map<String, Integer> words, StringBuilder sb) {
        if (sb.length()>0){
            String word = sb.toString();
            sb.setLength(0);
            words.merge(word, 1, (a, b) -> a + b);
            return 1;
        }
        return 0;
    }
}
*/







