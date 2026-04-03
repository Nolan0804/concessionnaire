package model;

import exception.InvalidInputException;

public class Energy {
    private String name;
    private Boolean isEcoFriendly;

    public Energy(String name, Boolean isEcoFriendly) throws InvalidInputException {
        setName(name);
        this.isEcoFriendly = isEcoFriendly;
    }

    public Boolean getEcoFriendly() {
        return isEcoFriendly;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInputException{
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Le type d'énergie ne peux être vide !");
        }
    }
}
