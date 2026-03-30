package model;

import exception.InvalidInputException;

public class State {
    private String name;

    public State(String name) throws InvalidInputException {
        setName(name);
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("State name cannot be null or empty.");
        }
        this.name = name;
    }
}
