package model;

import exception.InvalidInputException;

public class Garanty {
    private String type;
    private Integer durationInMonths;

    public Garanty(String type, Integer durationInMonths) throws InvalidInputException {
        setType(type);
        setDurationInMonths(durationInMonths);
    }

    public String getType() {
        return type;
    }
    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setType(String type) throws InvalidInputException{
        if (type == null || type.isEmpty()) {
            throw new InvalidInputException("La garantie entrée n'est pas valide.");
        }
        this.type = type;
    }

    public void setDurationInMonths(Integer durationInMonths) throws InvalidInputException {
        if(durationInMonths == null || durationInMonths < 0 || durationInMonths > 24) {
            throw new InvalidInputException("La durée d'une garantie ne peux être négative ou supérieur à 24 !");
        }
        this.durationInMonths = durationInMonths;
    }
}
