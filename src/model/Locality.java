package model;

public class Locality {
    private Integer postalCode;
    private Country country;
    private String name;

    public Locality(String name, Integer postalCode, Country country) throws IllegalArgumentException {
        setName(name);
        setPostalCode(postalCode);
        setCountry(country);
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peux être null !");
        }
            this.name = name;
    }

    public void setCountry(Country country) throws IllegalArgumentException {
        if (country == null) {
            throw new IllegalArgumentException("Le pays ne peux être null !");
        }
            this.country = country;
    }

    public void setPostalCode(Integer postalCode) throws IllegalArgumentException {
        if (postalCode == null || postalCode < 0) {
             throw new IllegalArgumentException("Le code postal ne peux être null ou négatif !");
        }
            this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }
}
