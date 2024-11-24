package SalaryManagementSystem;

public class Worker {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int salary;

    public Worker(String id, String firstName, String lastName, String email, String phone, String address, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id: "+ id +", Worker Name:"+ firstName + " " + lastName + ", Email; " + email + ", Phone Number: " + phone +
        ", Address: " + address + ", Salary: " + salary;
    }
}
