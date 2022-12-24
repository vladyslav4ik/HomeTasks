package hometask3.task1;

import hometask3.task1.enums.*;

public class Human {
    private String name;
    private String lastName;
    private Gender gender;

    public Human() {
    }

    public Human(String name, String lastName, String gender) {
        this.name = name;
        this.lastName = lastName;
        if (gender.equalsIgnoreCase("man") ||
                gender.equalsIgnoreCase("woman"))
            this.gender = Gender.valueOf(gender.toUpperCase());
        else
            this.gender = Gender.UNCERTAIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender.getGender();
    }

    public void setGender(String gender) {
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    @Override
    public String toString() {
        return "Human[" +
                "name=" + name + '\'' +
                ", lastName=" + lastName + '\'' +
                ", gender=" + gender +
                ']';
    }
}


