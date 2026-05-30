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
    private String hexColor;
    private String typeColor;
    private Energy energy;
    private Brand brand;
    private String state;
    private Customer saler;

    public Vehicle(String VIN, Double kilometer, LocalDate arrivalDate, Double sale_price, Double purshase_price,
                   String registrationNumber, Integer power, String gearBox, Integer gearNumber, Integer doorNumber,
                   Integer seatNumber, String information, Integer euroStandard, Integer yearOfProduction,
                   Boolean isVatDeductible, Garanty garanty, String hexColor, String typeColor, Energy energy, Brand brand, String state, Customer saler) {
        setVIN(VIN);
        setKilometer(kilometer);
        setArrivalDate(arrivalDate);
        setSalePrice(sale_price);
        setPurchasePrice(purshase_price);
        setRegistrationNumber(registrationNumber);
        setPower(power);
        setGearBox(gearBox);
        setGearNumber(gearNumber);
        setDoorNumber(doorNumber);
        setSeatNumber(seatNumber);
        setInformation(information);
        setEuroStandard(euroStandard);
        setYearOfProduction(yearOfProduction);
        setIsVatDeductible(isVatDeductible);
        setGaranty(garanty);
        setHexColor(hexColor);
        setTypeColor(typeColor);
        setEnergy(energy);
        setBrand(brand);
        setState(state);
        setSaler(saler);
    }

    public void setVIN(String VIN) {
        if (VIN == null) throw new IllegalArgumentException("VIN cannot be null");
        if (VIN.length() != 17) throw new IllegalArgumentException("VIN must be exactly 17 characters");
        this.VIN = VIN;
    }

    public void setKilometer(Double kilometer) {
        if (kilometer == null) throw new IllegalArgumentException("Kilometer cannot be null");
        if (kilometer < 0 || kilometer > 999999.99) throw new IllegalArgumentException("Kilometer must be between 0 and 999999.99");
        this.kilometer = kilometer;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        if (arrivalDate == null) throw new IllegalArgumentException("Arrival date cannot be null");
        this.arrivalDate = arrivalDate;
    }

    public void setSalePrice(Double sale_price) {
        if (sale_price == null) throw new IllegalArgumentException("Sale price cannot be null");
        if (sale_price < 0 || sale_price > 999999.99) throw new IllegalArgumentException("Sale price must be between 0 and 999999.99");
        if (this.purshase_price != null && sale_price < this.purshase_price) throw new IllegalArgumentException("Sale price must be greater than or equal to purchase price");
        this.sale_price = sale_price;
    }

    public void setPurchasePrice(Double purshase_price) {
        if (purshase_price == null) throw new IllegalArgumentException("Purchase price cannot be null");
        if (purshase_price < 0 || purshase_price > 999999.99) throw new IllegalArgumentException("Purchase price must be between 0 and 999999.99");
        if (this.sale_price != null && purshase_price > this.sale_price) throw new IllegalArgumentException("Purchase price must be less than or equal to sale price");
        this.purshase_price = purshase_price;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setPower(Integer power) {
        if (power == null) throw new IllegalArgumentException("Power cannot be null");
        if (power < 1 || power > 1000) throw new IllegalArgumentException("Power must be between 1 and 1000");
        this.power = power;
    }

    public void setGearBox(String gearBox) {
        if (gearBox == null) throw new IllegalArgumentException("Gear box cannot be null");
        if (!gearBox.equals("Automatic") && !gearBox.equals("Manual")) throw new IllegalArgumentException("Gear box must be 'Automatic' or 'Manual'");
        this.gearBox = gearBox;
    }

    public void setGearNumber(Integer gearNumber) {
        if (gearNumber == null) throw new IllegalArgumentException("Gear number cannot be null");
        if (gearNumber < 5 || gearNumber > 8) throw new IllegalArgumentException("Gear number must be between 5 and 8");
        this.gearNumber = gearNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        if (doorNumber == null) throw new IllegalArgumentException("Door number cannot be null");
        if (doorNumber < 3 || doorNumber > 5) throw new IllegalArgumentException("Door number must be between 3 and 5");
        this.doorNumber = doorNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        if (seatNumber == null) throw new IllegalArgumentException("Seat number cannot be null");
        if (seatNumber < 1 || seatNumber > 9) throw new IllegalArgumentException("Seat number must be between 1 and 9");
        this.seatNumber = seatNumber;
    }

    public void setInformation(String information) {
        if (information == null) throw new IllegalArgumentException("Information cannot be null");
        if (information.length() > 255) throw new IllegalArgumentException("Information must be 255 characters max");
        this.information = information;
    }

    public void setEuroStandard(Integer euroStandard) {
        if (euroStandard == null) throw new IllegalArgumentException("Euro standard cannot be null");
        if (euroStandard < 1 || euroStandard > 7) throw new IllegalArgumentException("Euro standard must be between 1 and 7");
        this.euroStandard = euroStandard;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        if (yearOfProduction == null) throw new IllegalArgumentException("Year of production cannot be null");
        if (yearOfProduction < 1886) throw new IllegalArgumentException("Year of production must be >= 1886");
        this.yearOfProduction = yearOfProduction;
    }

    public void setIsVatDeductible(Boolean isVatDeductible) {
        if (isVatDeductible == null) throw new IllegalArgumentException("VAT deductible cannot be null");
        this.isVatDeductible = isVatDeductible;
    }

    public void setGaranty(Garanty garanty) {
        if (garanty == null) throw new IllegalArgumentException("Garanty cannot be null");
        this.garanty = garanty;
    }

    public void setHexColor(String hexColor) {
        if (hexColor == null) throw new IllegalArgumentException("Hex color cannot be null");
        if (!hexColor.matches("^#[0-9A-Fa-f]{6}$")) throw new IllegalArgumentException("Hex color must be a valid hex color (e.g. #FF0000)");
        this.hexColor = hexColor;
    }

    public void setTypeColor(String typeColor) {
        if (typeColor == null) throw new IllegalArgumentException("Type color cannot be null");
        this.typeColor = typeColor;
    }

    public void setEnergy(Energy energy) {
        if (energy == null) throw new IllegalArgumentException("Energy cannot be null");
        this.energy = energy;
    }

    public void setBrand(Brand brand) {
        if (brand == null) throw new IllegalArgumentException("Brand cannot be null");
        this.brand = brand;
    }

    public void setState(String state) {
        if (state == null) throw new IllegalArgumentException("State cannot be null");
        this.state = state;
    }

    public void setSaler(Customer saler) {
        if (saler == null) throw new IllegalArgumentException("Saler cannot be null");
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

    public String getHexColor() {
        return hexColor;
    }

    public String getTypeColor() {
        return typeColor;
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
