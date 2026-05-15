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
    private String state;
    private Customer saler;

    public Vehicle(String VIN, Double kilometer, LocalDate arrivalDate, Double sale_price, Double purshase_price,
            String registrationNumber, Integer power, String gearBox, Integer gearNumber, Integer doorNumber,
            Integer seatNumber, String information, Integer euroStandard, Integer yearOfProduction,
            Boolean isVatDeductible, Garanty garanty, Color color, Energy energy, Brand brand, String state, Customer saler) {
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
    }

    public String getVIN() {
        return VIN;
    }

    public Double getKilometer() {
        return kilometer;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Double getSalePrice() {
        return sale_price;
    }

    public Double getPurchasePrice() {
        return purshase_price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Integer getPower() {
        return power;
    }

    public String getGearBox() {
        return gearBox;
    }

    public Integer getGearNumber() {
        return gearNumber;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public String getInformation() {
        return information;
    }

    public Integer getEuroStandard() {
        return euroStandard;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public Boolean getIsVatDeductible() {
        return isVatDeductible;
    }

    public Garanty getGaranty() {
        return garanty;
    }

    public Color getColor() {
        return color;
    }

    public Energy getEnergy() {
        return energy;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getState() {
        return state;
    }

    public Customer getSaler() {
        return saler;
    }
}
