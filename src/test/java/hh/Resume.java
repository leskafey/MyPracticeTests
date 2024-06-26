package hh;

public class Resume {

    private final String gender;
    private final String city;
    private final int age;
    private final boolean isPhoneConfirmed;
    private final boolean isReadyToRelocate;

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public boolean isPhoneConfirmed() {
        return isPhoneConfirmed;
    }

    public boolean isReadyToRelocate() {
        return isReadyToRelocate;
    }

    public Resume(String gender, String city, int age, boolean isPhoneConfirmed, boolean isReadyToRelocate) {
        this.gender = gender;
        this.city = city;
        this.age = age;
        this.isPhoneConfirmed = isPhoneConfirmed;
        this.isReadyToRelocate = isReadyToRelocate;
    }
}
