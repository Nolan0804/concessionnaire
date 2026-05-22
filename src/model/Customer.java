package model;

import java.time.LocalDate;

public class Customer {
    private Integer customerNumber;
    private String firstName, lastName, email, phoneNumber, address;
    private LocalDate dateOfBirth;
    private Locality locality;

    public Customer(Integer customerNumber, String firstName, String lastName, String email, String phoneNumber,
            String address, LocalDate dateOfBirth, Locality locality) {
        setCustomerNumber(customerNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
        setLocality(locality);
    }
    public void setCustomerNumber(int customerNumber) {
        if (customerNumber <= 0) {
            throw new IllegalArgumentException("Customer number must be positive.");
        }
        this.customerNumber = customerNumber;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null ||
                !phoneNumber.matches("^\\+[0-9]{9,15}$")) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        this.address = address;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid birth date.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Locality getLocality() {
        return locality;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    @Override
    public String toString() {
        return customerNumber + " - " + firstName + " " + lastName;
    }
}
