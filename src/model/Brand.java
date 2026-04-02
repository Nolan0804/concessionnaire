package model;

import exception.InvalidInputException;
import java.time.Year;

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
        int currentYear = Year.now().getValue();
        if (yearCreated == null) {
            throw new InvalidInputException("L'année ne peut pas être nulle.");
        } else if (yearCreated < 1886) { 
            throw new InvalidInputException("La première voiture a été créée en 1886. Merci d'entrer une date postérieure.");
        } else if (yearCreated > currentYear) {
            throw new InvalidInputException("Impossible d'ajouter une marque qui n'existe pas encore.");
        }
        this.yearCreated = yearCreated;
    }
    //test

    // Getter
    public String getName() {
        return name;
    }
}
