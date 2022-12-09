package task9;

import java.io.File;
import java.util.concurrent.Exchanger;

public class Task9Test {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        FileCopier fileCopier = new FileCopier(exchanger);
        File from = new File("E:\\Users\\Пользователь\\Desktop\\test.txt");
        File to = new File("E:\\Users\\Пользователь\\Desktop\\get.txt");
        fileCopier.copyFile(from, to);
    }
}