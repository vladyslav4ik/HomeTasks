package task8;

public class Ship implements Runnable{
    private int n;
    private String name;

    public Ship(String name) {
        this.name = name;
        n = 10;
        new Thread(this, name);
    }

    public int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println("The number of boxes on " + name + " ship: " + n);
            n = n - 1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}