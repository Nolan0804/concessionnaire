package model;

import java.time.LocalDate;

public class Customer {
    private Integer customerNumber;
    private String firstName, lastName, email, phoneNumber, address;
    private LocalDate dateOfBirth;
    private Locality locality;

    public Customer(Integer customerNumber, String firstName, String lastName, String email, String phoneNumber,
            String address, LocalDate dateOfBirth, Locality locality) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.locality = locality;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }
}
