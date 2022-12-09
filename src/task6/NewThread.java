package task6;

import java.math.BigInteger;

public class NewThread implements Runnable{
    private BigInteger getFactorial(long n) {
        if (n < 1)
            throw new IllegalArgumentException("n must be more or equal 1!");
        if (n == 1)
            return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + getFactorial(Long.parseLong(Thread.currentThread().getName())));
    }
}