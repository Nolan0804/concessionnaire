package model;

import exception.InvalidInputException;

public class Brand {
    private String name;
    private Country originCountry;
    private Integer yearCreated;

    public Brand(String name, Integer yearCreated, Country originCountry) throws InvalidInputException {
        setName(name);
        setYearCreated(yearCreated);
        this.originCountry = originCountry;
    }
    // Setter
    public void setName(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Nom de la marque vide");
        }
        this.name = name;
    }

    public void setYearCreated(Integer yearCreated) throws InvalidInputException {
        if(yearCreated < 1886) { // 1886 est l'année de création de la voiture
            throw new InvalidInputException("La première voiture a été créée en 1886. Merci d'entrer une date postérieure.");
        }
    }

    // Getter
    public String getName() {
        return name;
    }
}
