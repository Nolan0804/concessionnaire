package model;

import java.time.LocalDate;

public class Maintenance {
    private LocalDate date;
    private String description, annotation;
    private Integer kilometer;
    private Vehicle vehicle;

    public Maintenace(LocalDate date, String description, String annotation, Integer kilometer, Vehicle vehicle) {
        setDate(date);
        setDescription(description);
        setAnnotation(annotation);
        setKilometer(kilometer);
        this.vehicle = vehicle;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("La date ne peut pas être nulle.");
        } else if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date de maintenance ne peut pas être dans le futur.");
        }
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public void setKilometer(Integer kilometer) {
        if (kilometer == null || kilometer < 0) {
            throw new IllegalArgumentException("Le kilométrage ne peut pas être nul ou négatif.");
        }
        this.kilometer = kilometer;
    }
}
