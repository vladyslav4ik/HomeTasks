package hometask6.task3;

import java.io.File;

public class FileThread implements Runnable{
    private File[] files;
    private FileFinder finder;

    public FileThread(File[] files, FileFinder finder) {
        this.files = files;
        this.finder = finder;
        new Thread(this).start();
    }

    @Override
    public void run() {
        finder.findFile(files);
    }
}
