package task4;

import java.io.File;
import java.io.IOException;

public class Task4Test {
    public static void main(String[] args) {
        FileCopier copier = new FileCopier();
        File from = new File("E:\\Users\\Пользователь\\Desktop\\get.txt");
        File to = new File("E:\\Users\\Пользователь\\Desktop\\to");

        try {
            copier.copyFiles("jpg", from, to);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
