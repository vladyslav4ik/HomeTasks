package task3;

public class Student extends Human {
    private int id;
    private String groupName;

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
}
