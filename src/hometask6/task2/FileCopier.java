package hometask6.task2;

import java.io.File;
import java.util.concurrent.Exchanger;

public class FileCopier {
    private Exchanger<String> exchanger;

    public FileCopier(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void copyFile(File from, File to)  {
        if (from.isDirectory() || to.isDirectory())
            throw new IllegalArgumentException("Arguments must be file!");
        new Reader(exchanger, from);
        new Writer(exchanger, to);
    }
}