package model;

import exception.InvalidInputException;

public class Garanty {
    private String type;
    private Integer durationInMonths;

    public Garanty(String type, Integer durationInMonths) throws InvalidInputException {
        this.type = type;
        setDurationInMonths(durationInMonths);
    }

    public void setDurationInMonths(Integer durationInMonths) throws InvalidInputException {
        if(durationInMonths == null || durationInMonths < 0) {
            throw new InvalidInputException("La durée d'une garantie ne peux être négative !");
        }
        this.durationInMonths = durationInMonths;
    }
}
