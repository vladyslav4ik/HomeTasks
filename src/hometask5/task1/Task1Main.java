package hometask5.task1;

public class Task1Main {
    public static void main(String[] args) {
        try {
            for (int i = 1; i < 101; i++) {
                new Thread(new NewThread(), String.valueOf(i)).start();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted!");
        }
    }
}