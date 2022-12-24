package hometask5.task2;

import java.util.Random;

public class Task2Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[15_000_000];
        int[] firstPiece = new int[5_000_000];
        int[] secondPiece = new int[5_000_000];
        int[] thirdPiece = new int[5_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.arraycopy(array, 0, firstPiece, 0, firstPiece.length);
        System.arraycopy(array, 5_000_000, secondPiece, 0, secondPiece.length);
        System.arraycopy(array, 10_000_000, thirdPiece, 0, thirdPiece.length);

        long time = System.currentTimeMillis();
        long sum = Calculator.calculateSum(array);

        System.out.println("Time with using one thread: " + (System.currentTimeMillis() - time));
        System.out.println("Sum with using one thread: " + sum);

        NewThread t1 = new NewThread(firstPiece);
        NewThread t2 = new NewThread(secondPiece);
        NewThread t3 = new NewThread(thirdPiece);

        time = System.currentTimeMillis();
        try {
            t1.getThread().join();
            t2.getThread().join();
            t3.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time with using three threads: " + (System.currentTimeMillis() - time));
        System.out.println("Sum with using three threads: " + (t1.getSum() + t2.getSum() + t3.getSum()));
    }
}
