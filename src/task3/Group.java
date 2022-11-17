package task3;

import task3.exceptions.GroupOverflowException;
import task3.exceptions.StudentNotFoundException;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students;
    private int nStudents;
    private Comparator<Student> comparator; // new field comparator

    public Group(String groupName) {
        this.groupName = groupName;
        students = new Student[10];
        nStudents = 0;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (nStudents == students.length)
            throw new GroupOverflowException("Group is full!");
        else {
            students[nStudents] = student;
            nStudents = nStudents + 1;
        }
    }

    // second variant of method for adding students
    public void addStudent() throws GroupOverflowException {
        if (nStudents == students.length)
            throw new GroupOverflowException("Group is full!");
        else {
            StudentInput.infoInsertion();
            students[nStudents] = StudentInput.getStudent();
            nStudents = nStudents + 1;
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        Student st = null;
        for (int i = 0; i < nStudents; i++) {
            if (students[i].getLastName().equals(lastName)) {
                st = students[i];
                break;
            }
        }
        if (st == null)
            throw new StudentNotFoundException("Student wasn't found!");
        return st;
    }

    public boolean removeStudentByID(int id) {
        int j;
        for (j = 0; j < nStudents; j++)
            if (id == students[j].getId())
                break;

        if (j == nStudents)
            return false;

        for (int i = j; i < nStudents - 1; i++)
            students[i] = students[i + 1];
        nStudents = nStudents - 1;
        return true;
    }

    private void bubbleSortStudent() {
        int in, out;
        for (out = nStudents - 1; out >= 0; out--) {
            for (in = 0; in < out; in++) {
                if (students[in].getLastName().compareTo(students[in + 1].getLastName()) > 0) {
                    Student temp = students[in];
                    students[in] = students[in + 1];
                    students[in + 1] = temp;
                }
            }
        }
    }

    // new method for sorting with using comparator
    private void sortStudentByLastName() {
        comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };

        Arrays.sort(students, comparator);
    }

    public int studentAmount() {
        return nStudents;
    }

    @Override
    public String toString() {
        //sortStudent();
        sortStudentByLastName();
        String result = "Group " + groupName + ":\n";
        for (int i = 0; i < nStudents; i++) {
            result = result + (i + 1) + ". " + students[i].toString();
        }
        return result;
    }
}