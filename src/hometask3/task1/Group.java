package hometask3.task1;

import hometask3.task1.exceptions.GroupOverflowException;
import hometask3.task1.exceptions.StudentNotFoundException;

import java.util.*;
import java.io.*;

public class Group {
    private String groupName;
    private List<Student> studentList;
    private Comparator<Student> comparator;

    public Group(String groupName) {
        this.groupName = groupName;
        studentList = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (studentList.size() == 10)
            throw new GroupOverflowException("Group is full!");
        else
            studentList.add(student);
    }

    public void addStudent() throws GroupOverflowException {
        if (studentList.size() == 10)
            throw new GroupOverflowException("Group is full!");
        else {
            StudentInput.infoInsertion();
            studentList.add(StudentInput.getStudent());
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        Student st = null;
        for (Student s : studentList) {
            if (s.getLastName().equals(lastName)) {
                st = s;
                break;
            }
        }
        if (st == null)
            throw new StudentNotFoundException("Student wasn't found!");
        return st;
    }

    public boolean removeStudentByID(int id) {
        boolean flag = false;
        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                flag = true;
                break;
            }
        }
        return flag;
    }

    private void sortStudentByLastName() {
        comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };
        Collections.sort(studentList, comparator);
    }

    public int studentAmount() {
        return studentList.size();
    }

    public void studentsToFile(File outputFile) {
        int i;
        try (FileOutputStream out = new FileOutputStream(outputFile)) {
            for (Student s : studentList) {
                byte[] temp = s.toString().getBytes();
                out.write(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void studentsFromFile(File inputFile) {
        int i;
        try (FileInputStream in = new FileInputStream(inputFile)) {
            do {
                i = in.read();
                if (i != - 1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    @Override
    public String toString() {
        sortStudentByLastName();
        String result = "Group " + groupName + ":\n";
        for (int i = 0; i < studentList.size(); i++) {
            result = result + (i + 1) + ". " + studentList.get(i).toString();
        }
        return result;
    }
}