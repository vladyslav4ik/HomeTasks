package task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dock implements Runnable {
    private String name;
    private ExecutorService es;
    private List<Ship> list;
    private Thread t;

    public Dock(String name) {
        this.name = name;
        list = new ArrayList<>();
        es = Executors.newFixedThreadPool(1);
        t = new Thread(this, name);
    }

    public void shipToDock(Ship ship) {
        list.add(ship);
        System.out.println("Ship " + ship.getName() + " was added to dock");
    }

    public void startUnloading() {
        if (list.isEmpty())
            throw new IllegalArgumentException("You must add at least one ship to start unloading!");
        t.start();
    }

    public Thread getT() {
        return t;
    }

    @Override
    public void run() {
        System.out.println("Dock " + name + " started the process of unloading");
        for (Ship s : list) {
            es.execute(s);
            //list.remove(s);
        }
        System.out.println();
        es.shutdown();
    }
}
