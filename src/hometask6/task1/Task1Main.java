package hometask6.task1;

public class Task1Main {
    public static void main(String[] args) {
        Dock dock1 = new Dock("Dock1");
        Dock dock2 = new Dock("Dock2");
        Ship ship1 = new Ship("first");
        Ship ship2 = new Ship("second");
        Ship ship3 = new Ship("third");

        dock1.shipToDock(ship1);
        dock1.shipToDock(ship2);
        dock2.shipToDock(ship3);

        dock1.startUnloading();
        dock2.startUnloading();

        try {
            dock1.getT().join();
            dock2.getT().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ship1.getN());
        System.out.println(ship2.getN());
        System.out.println(ship3.getN());
    }
}
