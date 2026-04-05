package view.components;
import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.setBackground(new Color(212, 212, 212));

        this.add(new HomeButton("Meilleure vente du mois", "bestSale.png"));
        this.add(new HomeButton("Listing Client", "listingCustomer.png"));
        this.add(new HomeButton("Listing Voiture", "vehicle.png"));
        this.add(new HomeButton("Eteindre l'application", "exit.png"));

        this.setPreferredSize(new Dimension(600, 300));
    }
}
