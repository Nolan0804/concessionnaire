package model;

import exception.InvalidInputException;

public class Country {
    private String name;

    public Country(String name) throws InvalidInputException {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Le nom du pays ne peux être vide !");
        }
    }
}
