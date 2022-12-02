package task6;

import java.math.BigInteger;

public class NewThread implements Runnable{
    private String name;
    private Thread t;

    public NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        t.start();
    }

    private BigInteger getFactorial(long n) {
        if (n == 1)
            return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
    }

    @Override
    public void run() {
        System.out.println(getFactorial(Long.parseLong(t.getName())));
    }
}