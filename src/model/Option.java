package model;

import exception.InvalidInputException;

public class Option {
    private String name, description;
    private Integer price;

    public Option(String name, String description, Integer price) throws InvalidInputException {
        setName(name);
        this.description = description;
        setPrice(price);
    }

    public Integer getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setPrice(Integer price) throws InvalidInputException {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Le prix ne peux être null ou négatif !");
        }
    }

    public void setName(String name) throws InvalidInputException {
        if(name == null && name.isEmpty()) {
            throw new InvalidInputException("le nom de l'option ne peux être vide !");
        }
        this.name = name;
    }
}
