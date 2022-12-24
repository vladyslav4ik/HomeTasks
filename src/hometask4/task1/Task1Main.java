package hometask4.task1;

import java.io.File;
import java.io.IOException;

public class Task1Main {
    public static void main(String[] args) {
        FileCopier copier = new FileCopier();
        File from = new File("E:\\Users\\Пользователь\\Desktop\\from");
        File to = new File("E:\\Users\\Пользователь\\Desktop\\to");

        try {
            copier.copyFiles("jpg", from, to);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
