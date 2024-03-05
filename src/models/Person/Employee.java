package models.Person;

public class Employee extends Person{
    private Level level;
    private Position position;
    private double salary;

    public Employee(String fullName, String dateOfBirth, String gender, String phoneNumber, String numberOfIdentityCard, String email, Level level, Position position, double salary) {
        super(fullName, dateOfBirth, gender, phoneNumber, numberOfIdentityCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(long id, String fullName, String dateOfBirth, String gender, String phoneNumber, String numberOfIdentityCard, String email, Level level, Position position, double salary) {
        super(id, fullName, dateOfBirth, gender, phoneNumber, numberOfIdentityCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level=" + level +
                ", position=" + position +
                ", salary=" + salary +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", numberOfIdentityCard='" + numberOfIdentityCard + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                this.getId(),
                this.getFullName(),
                this.getDateOfBirth(),
                this.getGender(),
                this.getPhoneNumber(),
                this.getNumberOfIdentityCard(),
                this.getEmail(),
                this.getLevel(),
                this.getPosition(),
                this.getSalary()
        );
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
