package view.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import model.Car;
import view.components.CarThread;

public class HomePanel extends JPanel {
    private ArrayList<Car> cars = new ArrayList<>();
    private Random random = new Random();

    public HomePanel() {
        setBackground(Color.WHITE);

        for (int i = 0; i < 15; i++) {
            Car car = new Car(
                    random.nextInt(1200),
                    50 + (i * 35),
                    2 + random.nextInt(5),
                    new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))
            );

            cars.add(car);

            CarThread thread = new CarThread(car, this);
            thread.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 32));

        String text = "Welcome cardealer";
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        g.drawString(text, x, y);

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