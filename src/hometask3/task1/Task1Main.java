package hometask3.task1;

import hometask3.task1.exceptions.GroupOverflowException;
import hometask3.task1.exceptions.StudentNotFoundException;

import java.io.File;

public class Task1Main {
    public static void main(String[] args) {
        Group g122_19_4 = new Group("122-19-4");
        Student s1 = new Student("Emma", "Em", "woman", 1, "122-19-4");
        Student s2 = new Student("Eva", "Ev", "woman", 2, "122-19-4");
        Student s3 = new Student("Vasya", "Vas", "man", 3, "122-19-4");
        Student s4 = new Student("Petya", "Pet", "man", 4, "122-19-4");
        Student s5 = new Student("Rima", "Ri", "woman", 5, "122-19-4");
        Student s6 = new Student("Dima", "Di", "man", 6, "122-19-4");
        Student s7 = new Student("James", "Jam", "man", 7, "122-19-4");
        Student s8 = new Student("Yulis", "Yu", "woman", 8, "122-19-4");
        Student s9 = new Student("Ann", "An", "woman", 9, "122-19-4");
        Student s10 = new Student("Galyna", "Gal", "woman", 10, "122-19-4");

        try {
            g122_19_4.addStudent(s1);
            g122_19_4.addStudent(s2);
            g122_19_4.addStudent(s3);
            g122_19_4.addStudent(s4);
            g122_19_4.addStudent(s5);
            g122_19_4.addStudent(s6);
            g122_19_4.addStudent(s7);
            g122_19_4.addStudent(s8);
            g122_19_4.addStudent(s9);
            g122_19_4.addStudent(s10);
            //g122_19_4.addStudent(s1); //will throw exception (group is full, n students = 11)
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }

        System.out.println(g122_19_4.studentAmount());
        try {
            System.out.println(g122_19_4.searchStudentByLastName("Pet"));
           // System.out.println(g122_19_4.searchStudentByLastName("het")); //will throw an exception
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(g122_19_4);

        File file = new File("students_info.txt");
        //g122_19_4.studentsToFile(file);
        g122_19_4.studentsFromFile(file);
    }
}
