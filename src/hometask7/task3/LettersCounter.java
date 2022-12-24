package hometask7.task3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LettersCounter {
    private Map<Character, Integer> map;

    public LettersCounter() {
        map = new TreeMap<>();
    }

    public void countLetters(File file) {
        int ch;
        try (FileReader reader = new FileReader(file)) {
            while ((ch = reader.read()) != -1) {
                if (!map.containsKey((char) ch))
                    map.put(Character.toLowerCase((char) ch), 1);
                else
                    map.put(Character.toLowerCase((char) ch), map.get((char) ch) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortMap();
        displayMap();
    }

    public void clearMap() {
        map.clear();
    }

    private void sortMap() {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.put(list.get(i).getKey(), list.get(i).getValue());
        }
        map = result;
    }

    private void displayMap() {
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
