package model;

import exception.InvalidInputException;

public class Color {
    private String hexColor;
    private String type;

    public Color(String hexColor, String type) throws InvalidInputException {
        setHexColor(hexColor);
        this.type = type;
    }

    public void setHexColor(String hexColor) throws InvalidInputException {
        if(hexColor == null || !hexColor.matches("^#[0-9A-Fa-f]{6}$")) {
            throw new InvalidInputException("Invalid hex color format");
        }
        this.hexColor = hexColor;
    }
}
