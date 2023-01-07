package hometask8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class MyDictionary {
    private final Map<String, String> dictionary;

    public MyDictionary() {
        dictionary = new TreeMap<>();
        dictionary.put("hello", "привіт");
    }

    public MyDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void addNewWord(String englishForm, String ukrainianForm) {
        if (englishForm != null && ukrainianForm != null)
            dictionary.put(englishForm, ukrainianForm);
        else
            throw new IllegalArgumentException("You can't add null values!");
    }

    public void translate() {
        String text = readFile();
        String[] words = text.split(" ");
        try (FileWriter writer = new FileWriter("src/hometask8/output/Ukrainian.out.txt")) {
            for (String word : words) {
                word = word.replaceAll("[.,/\\-:;!?]", "").toLowerCase().trim();
                writer.write(dictionary.getOrDefault(word, "?") + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDictionary(String path) {
        File file = new File(path);
        if (!file.isFile())
            throw new IllegalArgumentException("You need to put the path to file!");

        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                String temp = entry.getKey() + " - " + entry.getValue() + " \n";
                writer.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFile() {
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader("src/hometask8/input/English.in.txt")) {
            int c;
            while ((c = reader.read()) != -1)
                builder.append((char) c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}