package model;

import java.time.LocalDate;

public class Maintenance {
    private LocalDate date;
    private String description, annotation;
    private Integer kilometer;
    private Vehicle vehicle;

    public Maintenace(LocalDate date, String description, String annotation, Integer kilometer, Vehicle vehicle) {
        this.date = date;
        this.description = description;
        this.annotation = annotation;
        this.kilometer = kilometer;
        this.vehicle = vehicle;
    }

    


}
