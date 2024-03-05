package models.Person;

public abstract class Person {
    protected long id;
    protected String fullName;
    protected String dateOfBirth;
    protected String gender;
    protected String phoneNumber;
    protected String numberOfIdentityCard;
    protected String email;
    public Person(){};

    public Person(String fullName, String dateOfBirth, String gender, String phoneNumber, String numberOfIdentityCard, String email) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.numberOfIdentityCard = numberOfIdentityCard;
        this.email = email;
    }

    protected Person(long id, java.lang.String fullName, java.lang.String dateOfBirth, java.lang.String gender, String phoneNumber, String numberOfIdentityCard, java.lang.String email) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.numberOfIdentityCard = numberOfIdentityCard;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumberOfIdentityCard() {
        return numberOfIdentityCard;
    }

    public void setNumberOfIdentityCard(String numberOfIdentityCard) {
        this.numberOfIdentityCard = numberOfIdentityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
