package model;

import java.time.LocalDate;

public class Vehicle {
    private String VIN;
    private Double kilometer;
    private LocalDate arrivalDate;
    private Double sale_price;
    private Double purshase_price;
    private String registrationNumber;
    private Integer power;
    private String gearBox;
    private Integer gearNumber;
    private Integer doorNumber;
    private Integer seatNumber;
    private String information;
    private Integer euroStandard;
    private Integer yearOfProduction;
    private Boolean isVatDeductible;
    private Garanty garanty;
    private Color color;
    private Energy energy;
    private Brand brand;
    private State state;
    private Customer saler;
    private String state;

    public Vehicle(String VIN, Double kilometer, LocalDate arrivalDate, Double sale_price, Double purshase_price,
            String registrationNumber, Integer power, String gearBox, Integer gearNumber, Integer doorNumber,
            Integer seatNumber, String information, Integer euroStandard, Integer yearOfProduction,
            Boolean isVatDeductible, Garanty garanty, Color color, Energy energy, Brand brand, State state,
            Customer saler, String state) {
        this.VIN = VIN;
        this.kilometer = kilometer;
        this.arrivalDate = arrivalDate;
        this.sale_price = sale_price;
        this.purshase_price = purshase_price;
        this.registrationNumber = registrationNumber;
        this.power = power;
        this.gearBox = gearBox;
        this.gearNumber = gearNumber;
        this.doorNumber = doorNumber;
        this.seatNumber = seatNumber;
        this.information = information;
        this.euroStandard = euroStandard;
        this.yearOfProduction = yearOfProduction;
        this.isVatDeductible = isVatDeductible;
        this.garanty = garanty;
        this.color = color;
        this.energy = energy;
        this.brand = brand;
        this.state = state;
        this.saler = saler;
        this.state = state;
    }
}
