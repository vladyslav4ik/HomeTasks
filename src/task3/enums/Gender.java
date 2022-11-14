package task3.enums;

public enum Gender {
    MAN("Man"), WOMAN("Woman"), UNCERTAIN("Uncertain");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Gender[" +
                "gender=" + gender + '\'' +
                ']';
    }
}
