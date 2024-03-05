package models.Person;

public class Customer extends Person{
    private CustomerType customerType;
    private String customerCode;

    private String address;

    public Customer() {
    };

    public Customer(String fullName, String customerCode, String dateOfBirth, String gender, String phoneNumber, String numberOfIdentityCard, String email, CustomerType customerType, String address) {
        super(fullName, dateOfBirth, gender, phoneNumber, numberOfIdentityCard, email);
        this.customerType = customerType;
        this.address = address;
        this.customerCode = customerCode;
    }


    public Customer(long id, String fullName, String customerCode, String dateOfBirth, String gender, String phoneNumber, String numberOfIdentityCard, String email, CustomerType customerType, String address) {
        super(id, fullName, dateOfBirth, gender, phoneNumber, numberOfIdentityCard, email);
        this.customerType = customerType;
        this.address = address;
        this.customerCode = customerCode;
    }


    @Override
    public String toString() {
        return "Customer{" +
                ", id=" + id + '\''+
                ", fullName='" + fullName + '\'' +

                " customerType=" + customerType +
                ", customerCode='" + customerCode + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numberOfIdentityCard='" + numberOfIdentityCard + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                this.getId(),
                this.getFullName(),
                this.getCustomerCode(),
                this.getDateOfBirth(),
                this.getGender(),
                this.getPhoneNumber(),
                this.getNumberOfIdentityCard(),
                this.getEmail(),
                this.getCustomerType(),
                this.getAddress());
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
