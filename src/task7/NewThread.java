package task7;

public class NewThread implements Runnable {
    private Thread t;
    private long sum;
    private int[] array;

    public NewThread(int[] array) {
        t = new Thread(this);
        this.array = array;
        sum = 0;
        t.start();
    }

    public Thread getThread() {
        return t;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        sum = Calculator.calculateSum(array);
    }
}
