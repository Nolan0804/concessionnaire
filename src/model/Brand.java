package model;

public class Brand {
    private String name, originCountry;
    private Integer yearCreated;

    public Brand(String name, Integer yearCreated, String originCountry) {
        setName(name);
        this.yearCreated = yearCreated;
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearCreated(Integer yearCreated) {
        if(yearCreated < 1886) {
            throw new IllegalArgumentException("Year created must be greater than or equal to 1886");
        }
    }
}
