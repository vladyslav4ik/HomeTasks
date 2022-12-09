package task9;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Exchanger;

public class Reader implements Runnable {
    private File from;
    private Exchanger<String> exchanger;

    public Reader(Exchanger<String> exchanger, File from) {
        this.exchanger = exchanger;
        this.from = from;
        new Thread(this, "reader").start();
    }

    @Override
    public void run() {
        String string = new String();
        System.out.println(Thread.currentThread().getName() + " started work!");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(from))) {
            System.out.println(Thread.currentThread().getName() + " started process of reading!");

            int ch;
            while ((ch = in.read()) != -1) {
                string = string + (char) ch;
            }
            System.out.println(Thread.currentThread().getName() + " ended process of reading!");
            System.out.println(Thread.currentThread().getName() + " send string to writer!");
            //System.out.println(string);

            try {
                exchanger.exchange(string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ended work!");
    }
}