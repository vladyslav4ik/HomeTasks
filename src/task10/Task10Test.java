package task10;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Task10Test {
    public static void main(String[] args) {
        String fileName = "printMe.txt";
        Path path = Paths.get("E:\\Users\\Пользователь\\Desktop");
        new FileFinder(fileName, path);
    }
}
