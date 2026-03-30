package model;

public class Locality {
    private Integer postalCode;
    private Country countryName;
    private String name;

    public Locality(String name, Integer postalCode, Country country) {
        this.name = name;
        this.countryName = country;
        this.postalCode = postalCode;
    }
}
