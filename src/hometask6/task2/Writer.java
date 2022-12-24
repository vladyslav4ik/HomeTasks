package hometask6.task2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Exchanger;

public class Writer implements Runnable {
    private Exchanger<String> exc;
    private File to;

    public Writer(Exchanger exchanger, File to) {
        this.to = to;
        this.exc = exchanger;
        new Thread(this, "writer").start();
    }

    private String exchangeString() {
        String s = "";
        try {
            s = exc.exchange(new String());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void run() {
        String string = "";
        System.out.println(Thread.currentThread().getName() + " started work!");
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(to))) {
            System.out.println(Thread.currentThread().getName() + " got a string from exchanger!");
            string = exchangeString();
            System.out.println(Thread.currentThread().getName() + " started process of writing!");
            out.write(string.getBytes());
            out.flush();
            System.out.println(Thread.currentThread().getName() + " ended process of writing!");
            System.out.println("Result: " + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ended work!");
    }
}