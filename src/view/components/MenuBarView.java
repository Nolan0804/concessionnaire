package view.components;

import javax.swing.*;

public class MenuBarView extends JMenuBar {
    private JMenuItem menu;
    private JMenuItem exitApps;
    private JMenuItem backHome;
    public JMenuItem showListVehicle;
    public JMenuItem addVehicle;


    public MenuBarView() {
        menu = new JMenu("Menu");
        backHome = new JMenuItem("Revenir à l'accueil");
        exitApps = new JMenuItem("Quitter l'application");
        menu.add(backHome);
        menu.add(exitApps);

        JMenu vehicleMenu = new JMenu("Voitures");
        showListVehicle = new JMenuItem("Voir liste voitures");
        addVehicle = new JMenuItem("Ajouter une voiture");
        vehicleMenu.add(showListVehicle);
        vehicleMenu.add(addVehicle);

        JMenu customerMenu = new JMenu("Clients");
        JMenuItem showListCustomer = new JMenuItem("Voir liste clients");
        JMenuItem addCustomer = new JMenuItem("Créer un client");
        customerMenu.add(showListCustomer);
        customerMenu.add(addCustomer);

        JMenu garantyMenu = new JMenu("Garanties");
        JMenuItem showListGaranty = new JMenuItem("Voir liste garanties");
        garantyMenu.add(showListGaranty);

        add(menu);
        add(vehicleMenu);
        add(customerMenu);
        add(garantyMenu);
    }

    public JMenuItem getExitApps() {
        return exitApps;
    }

    public JMenuItem getBackHome() {
        return backHome;
    }

}