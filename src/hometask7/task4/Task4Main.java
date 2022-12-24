package hometask7.task4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task4Main {
    private static Deque<String> initializeDeque() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Penny");
        deque.addFirst("Kutrapalli");
        deque.addFirst("Volovitc");
        deque.addFirst("Leonard");
        deque.addFirst("Sheldon");
        return deque;
    }


    public static void displayQueue(int counter) {
        Deque<String> deque = initializeDeque();
        for (int i = 0; i < counter; i++) {
            deque.addLast(deque.getFirst());
            deque.addLast(deque.getFirst());
            deque.removeFirst();
        }
        System.out.println(deque);
    }

    public static void main(String[] args) {
        displayQueue(2);
    }
}
