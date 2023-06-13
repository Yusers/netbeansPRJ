 package hrs.entities;

public abstract class Employee implements Payable {

    private String ssn;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String phone;
    private String email;

    @Override
    public double getPaymentAmount() {
        double paymentAmount = 0;
        return paymentAmount;
    }

    public Employee() {
    }

    public Employee(String ssn, String firstName, String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void display() {

    }

    @Override
    public String toString() {
        return "Employee{" + "ssn=" + ssn + ", firstName=" + firstName
                + ", lastName=" + lastName + ", birthDay=" + birthDay
                + ", phone=" + phone + ", email=" + email;
    }
}
