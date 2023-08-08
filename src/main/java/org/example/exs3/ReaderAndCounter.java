package org.example.exs3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReaderAndCounter {
private File file;

    public ReaderAndCounter(File file) {
        this.file = file;
    }

    private Map<String, Integer> countAndRead(File file) {
        Map<String, Integer> wordMap = new HashMap<>();
        this.file = file;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.toLowerCase();
                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return wordMap;
    }

    public void getWords(){
        Map<String, Integer> wordMap = countAndRead(file);

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordMap.entrySet());
        sortedEntries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());


        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
