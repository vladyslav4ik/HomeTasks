package hometask7.task3;

import java.io.File;

public class Task3Main {
    public static void main(String[] args) {
        LettersCounter counter = new LettersCounter();
        File file = new File("E:\\Users\\Пользователь\\Desktop\\text.txt");
        counter.countLetters(file);
    }
}
