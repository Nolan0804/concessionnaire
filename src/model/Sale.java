package model;

import java.time.LocalDate;

public class Sale {
    private LocalDate date;
    private String paymentMethod;
    private String state;
    private Vehicle vehicle;
    private Customer customer;
    private Double price;

    public Sale(LocalDate date, String paymentMethod, String state, Vehicle vehicle, Customer customer, Double price) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.state = state;
        this.vehicle = vehicle;
        this.customer = customer;
        this.price = price;
    }
}
