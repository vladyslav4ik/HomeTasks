package task3;

import task3.exceptions.GroupOverflowException;
import task3.exceptions.StudentNotFoundException;

public class Group {
    private String groupName;
    private Student[] students;
    private int nStudents;

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
        else
            students[nStudents++] = student;
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
        int pos;
        for (pos = 0; pos < nStudents; pos++)
            if (students[pos].getId() == id)
                break;

        if (pos == nStudents)
            return false;

        for (int i = pos; pos < nStudents - 1; pos++)
            students[i] = students[i + 1];
        nStudents--;
        return true;
    }

    private void sortStudent() {
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

    public int studentAmount() {
        return nStudents;
    }

    @Override
    public String toString() {
        sortStudent();
        String result = "Group " + groupName + ":\n";
        for (int i = 0; i < nStudents; i++) {
            result = result + (i + 1) + ". " + students[i].toString();
        }
        return result;
    }
}