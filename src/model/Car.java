package model;

import java.awt.*;

public class Car {
    private int x;
    private int y;
    private int speed;
    private Color color;

    public Car(int x, int y, int speed, Color color) {
        setX(x);
        setY(y);
        setSpeed(speed);
        setColor(color);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}