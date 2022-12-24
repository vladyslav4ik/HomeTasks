package hometask3.task1.enums;

public enum Gender {
    MAN("Man"), WOMAN("Woman"), UNCERTAIN("Uncertain");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender[" +
                "gender=" + gender + '\'' +
                ']';
    }
}
