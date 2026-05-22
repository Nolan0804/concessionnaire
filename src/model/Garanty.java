package model;

import exception.InvalidInputException;

public class Garanty extends ComboBoxItem {
    private String type;
    private Integer durationInMonths;

    public Garanty(String type, Integer durationInMonths) throws InvalidInputException {
        super(type);

        setType(type);
        setDurationInMonths(durationInMonths);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidInputException{
        if (type == null || type.isEmpty()) {
            throw new InvalidInputException("La garantie entrée n'est pas valide.");
        }
        this.type = type;
    }

    public void setDurationInMonths(Integer durationInMonths) throws InvalidInputException {
        if(durationInMonths == null || durationInMonths < 0) {
            throw new InvalidInputException("La durée d'une garantie ne peux être négative ou supérieur à 24 !");
        }
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        int durationInYear = durationInMonths / 12;
        return type + " - " + durationInYear + (durationInYear > 1 ? " ans": " an");
    }
}