package view.components;

import javax.swing.*;

public class MenuBarView extends JMenuBar {
    private JMenuItem menu, exitApps, backHome;
    private JMenuItem vehicleMenu, showListVehicle, addVehicle;
    private JMenuItem customerMenu, showListCustomer, addCustomer;
    private JMenuItem saleMenu, showListSale, addSale;
    private JMenuItem garantyMenu, showListGaranty;

    public MenuBarView() {
        menu = new JMenu("Menu");
        backHome = new JMenuItem("Revenir à l'accueil");
        exitApps = new JMenuItem("Quitter l'application");
        menu.add(backHome);
        menu.add(exitApps);

        vehicleMenu = new JMenu("Voiture");
        showListVehicle = new JMenuItem("Liste voitures");
        addVehicle = new JMenuItem("Ajouter une voiture");
        vehicleMenu.add(showListVehicle);
        vehicleMenu.add(addVehicle);

        customerMenu = new JMenu("Client");
        showListCustomer = new JMenuItem("Liste clients");
        addCustomer = new JMenuItem("Créer un client");
        customerMenu.add(showListCustomer);
        customerMenu.add(addCustomer);

        saleMenu = new JMenu("Vente");
        showListSale = new JMenuItem("Liste ventes");
        addSale = new JMenuItem("Créer une vente");
        saleMenu.add(showListSale);
        saleMenu.add(addSale);

        garantyMenu = new JMenu("Garanties");
        showListGaranty = new JMenuItem("Voir liste garanties");
        garantyMenu.add(showListGaranty);

        add(menu);
        add(saleMenu);
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
    public JMenuItem getMenu() {
        return menu;
    }
    public JMenuItem getVehicleMenu() {
        return vehicleMenu;
    }
    public JMenuItem getShowListVehicle() {
        return showListVehicle;
    }
    public JMenuItem getAddVehicle() {
        return addVehicle;
    }
    public JMenuItem getCustomerMenu() {
        return customerMenu;
    }
    public JMenuItem getShowListCustomer() {
        return showListCustomer;
    }
    public JMenuItem getAddCustomer() {
        return addCustomer;
    }
    public JMenuItem getSaleMenu() {
        return saleMenu;
    }
    public JMenuItem getShowListSale() {
        return showListSale;
    }
    public JMenuItem getAddSale() {
        return addSale;
    }
    public JMenuItem getGarantyMenu() {
        return garantyMenu;
    }
    public JMenuItem getShowListGaranty() {
        return showListGaranty;
    }
}