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
        setDate(date);
        setPaymentMethod(paymentMethod);
        setState(state);
        setVehicle(vehicle);
        setCustomer(customer);
        setPrice(price);
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        } else if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Sale date cannot be in the future.");
        }
        this.date = date;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod == null ||
                !(paymentMethod.equals("Cash") ||
                        paymentMethod.equals("Card") ||
                        paymentMethod.equals("Bank Transfer") ||
                        paymentMethod.equals("Financing"))) {

            throw new IllegalArgumentException("Payment method must be Cash, Card, Bank Transfer or Financing.");
        }
        this.paymentMethod = paymentMethod;
    }

    public void setState(String state) {
        if (state == null ||
                !(state.equals("Pending") ||
                        state.equals("Completed") ||
                        state.equals("Cancelled"))) {

            throw new IllegalArgumentException("State must be Pending, Completed or Cancelled.");
        }
        this.state = state;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        this.vehicle = vehicle;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }
}
