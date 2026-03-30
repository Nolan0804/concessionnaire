package model;

import exception.InvalidInputException;

public class Option {
    private String name, description;
    private Integer price;

    public Option(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName(String name) throws InvalidInputException {
        if(name == null && name.isEmpty()) {
            throw new InvalidInputException("le nom de l'option ne peux être vide !");
        }
        this.name = name;
    }
}
