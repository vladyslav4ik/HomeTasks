package hometask4.task2;

import java.io.File;
import java.io.IOException;

public class Task2Main {
    public static void main(String[] args) {
        UniqueWordsInFiles wordsInFiles = new UniqueWordsInFiles();
        File firstFile = new File("");
        File secondFile = new File("");
        try {
            wordsInFiles.getUniqueWords(firstFile, secondFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
