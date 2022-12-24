package hometask3.task1;

import java.util.StringJoiner;

public class Student extends Human implements CSVConverter{
    private int id;
    private String groupName;
    private StringJoiner sj;

    public Student() {
    }

    public Student(String name, String lastName, String gender, int id, String groupName) {
        super(name, lastName, gender);
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getLastName() + " " +
                super.getGender() + " " + id + " " + groupName + "\n";
    }

    @Override
    public String toCSVString() {
        sj = new StringJoiner(",");
        sj.add(super.getName());
        sj.add(super.getLastName());
        sj.add(super.getGender());
        sj.add(String.valueOf(id));
        sj.add(groupName);
        return sj.toString();
    }

    @Override
    public Student fromCSVString(String str) {
        Student temp = new Student();
        String[] data = str.split(",");
        temp.setName(data[0]);
        temp.setLastName(data[1]);
        temp.setGender(data[2]);
        temp.setId(Integer.parseInt(data[3]));
        temp.setGroupName(data[4]);
        return temp;
    }
}
