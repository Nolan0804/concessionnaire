package view.components;
import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(2,2,10,10));
        homePanel.setBackground(new Color(212, 212, 212));
        homePanel.add(new HomeButton("Meilleure vente du mois", "logo.webp"));
        homePanel.add(new HomeButton("Listing Client", "logo.webp"));
        homePanel.add(new HomeButton("Listing Voiture", "logo.webp"));
        homePanel.add(new HomeButton("Eteindre l'application", "logo.webp"));
        homePanel.setPreferredSize(new Dimension(600, 300));
    }
}
