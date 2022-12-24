package hometask6.task3;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Task3Main {
    public static void main(String[] args) {
        String fileName = "printMe.txt";
        Path path = Paths.get("E:\\Users\\Пользователь\\Desktop");
        new FileFinder(fileName, path);
    }
}
