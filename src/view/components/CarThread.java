package view.components;

import model.Car;
import view.panels.HomePanel;

public class CarThread extends Thread {
    private Car car;
    private HomePanel panel;
    public CarThread(Car car, HomePanel panel) {
        this.car = car;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int newX = car.getX();
            car.setX(newX + car.getSpeed());

            if (car.getX() > panel.getWidth()) {
                car.setX(-60);
            }
            panel.repaint();
        }
    }
}