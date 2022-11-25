package task5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWordsInFiles {
    public void getUniqueWords(File firstFile, File secondFile) throws IOException {
        Set<String> first = arrayToSet(fileToArray(firstFile));
        Set<String> second = arrayToSet(fileToArray(secondFile));
        String result = checkUniqueness(first, second);
        try (FileOutputStream out = new FileOutputStream("unique_words.txt")) {
            out.write(result.getBytes());
        }
    }

    private String[] fileToArray(File file) {
        String temp = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext())
                temp = temp + scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp.toLowerCase().split("\\W");
    }

    private Set<String> arrayToSet(String[] array) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        return set;
    }

    private String checkUniqueness(Set<String> first, Set<String> second) {
        String result = "";
        for (String str : first) {
            if (second.contains(str))
                result = result + str + "\n";
        }
        return result.trim();
    }
}
