package task10;

import java.io.File;
import java.nio.file.Path;

public class FileFinder implements Runnable {
    private final String FILE_NAME;
    private File[] files;

    public FileFinder(String fileName, Path from) {
        this.FILE_NAME = fileName;
        if (from != null)
            this.files = from.toFile().listFiles();
        else
            throw new IllegalArgumentException("Path can't be null!");
        new Thread(this).start();
    }

    public void findFile(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                new FileThread(f.listFiles(), this);
            } else {
                if (f.getName().equals(FILE_NAME))
                    System.out.println(f.getPath());
            }
        }
    }

    @Override
    public void run() {
        findFile(files);
    }
}
