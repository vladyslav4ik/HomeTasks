package task3;

import java.util.Scanner;

public class StudentInput {
    private static Student student;
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void infoInsertion() {
        student = new Student();
        System.out.println("Input student name: ");
        student.setName(scanner.next());
        System.out.println("Input student lastname: ");
        student.setLastName(scanner.next());
        System.out.println("Input student gender: ");
        student.setGender(scanner.next());
        System.out.println("Input student id: ");
        student.setId(scanner.nextInt());
        System.out.println("Input student group name: ");
        student.setGroupName(scanner.next());
    }

    public static Student getStudent() {
        return student;
    }
}
