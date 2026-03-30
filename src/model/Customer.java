package model;

import java.time.LocalDate;

public class Customer {
    private Integer customerNumber;
    private String fistName, lastName, email, phoneNumber, address;
    private LocalDate dateOfBirth;
    private Locality locality;

    public Customer(Integer customerNumber, String fistName, String lastName, String email, String phoneNumber,
            String address, LocalDate dateOfBirth, Locality locality) {
        this.customerNumber = customerNumber;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.locality = locality;
    }
}
