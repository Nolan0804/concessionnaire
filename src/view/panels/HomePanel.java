package view.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import view.components.Car;

public class HomePanel extends JPanel {
    private ArrayList<Car> cars = new ArrayList<>();
    private Random random = new Random();

    public HomePanel() {
        setBackground(Color.WHITE);

        for (int i = 0; i < 30; i++) {
            cars.add(new Car(
                    random.nextInt(1200), 50 + (i * 50),
                    2 + random.nextInt(5),
                    new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))
            ));
        }
        startAnimation();
    }

    private void startAnimation() {
        Timer timer = new Timer(30, e -> {
            for (Car car : cars) {
                int newX = car.getX();
                car.setX(newX + car.getSpeed());
                if (car.getX() > getWidth()) {
                    car.setX(-40);
                    car.setY(random.nextInt(500));
                }
            }
            repaint();
        });

        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Car car : cars) {
            g.setColor(car.getColor());
            g.fillRoundRect(car.getX(), car.getY(), 50, 20, 10, 10);
            g.fillRoundRect(car.getX() + 10, car.getY() - 10, 30, 15, 10, 10);
            g.setColor(Color.BLACK);
            g.fillOval(car.getX() + 5, car.getY() + 15, 10, 10);
            g.fillOval(car.getX() + 35, car.getY() + 15, 10, 10);
        }
    }
}