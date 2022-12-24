package hometask7.task1;

import java.util.LinkedList;
import java.util.List;

public class Task1Main {
    public static void testList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++)
            list.add(i);
        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);
        System.out.println(list);
    }

    public static void main(String[] args) {
        testList();
    }
}
