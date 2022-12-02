package task6;

public class Task6Test {
    public static void main(String[] args) {
        try {
            for (int i = 1; i < 101; i++) {
                new NewThread(String.valueOf(i));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted!");
        }
    }
}