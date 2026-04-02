package model;

import java.time.LocalDate;

public class Trial {
    private LocalDate date;
    private Integer durationInMinutes;
    private Vehicle vehicle;
    private Customer customer;
    private String comment;
    private Boolean isPotentialSale;

    public Trial(LocalDate date, Integer durationInMinutes, Vehicle vehicle, Customer customer, String comment, Boolean isPotentialSale) {
        this.date = date;
        this.durationInMinutes = durationInMinutes;
        this.vehicle = vehicle;
        this.customer = customer;
        this.comment = comment;
        this.isPotentialSale = isPotentialSale;
    }
}
