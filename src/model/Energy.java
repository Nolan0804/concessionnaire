package model;

import exception.InvalidInputException;

public class Energy extends ComboBoxItem{
    private String name;
    private Boolean isEcoFriendly;

    public Energy(String name, Boolean isEcoFriendly) throws InvalidInputException {
        super(name);

        setName(name);
        this.isEcoFriendly = isEcoFriendly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInputException{
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Le type d'énergie ne peux être vide !");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " - " + (isEcoFriendly ? "ECO" : "NON-ECO");
    }
}
