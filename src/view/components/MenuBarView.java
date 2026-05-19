package view.components;

import javax.swing.*;

public class MenuBarView extends JMenuBar {
    private JMenuItem menu, exitApps, backHome;
    private JMenuItem vehicleMenu, showListVehicle, deleteVehicle, updateVehicle, addVehicle;
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
        addVehicle = new JMenuItem("Ajouter une voiture");
        deleteVehicle = new JMenuItem("Supprimer une voiture");
        updateVehicle = new JMenuItem("Mettre à jour une voiture");
        showListVehicle = new JMenuItem("Liste voitures");
        vehicleMenu.add(addVehicle);
        vehicleMenu.add(deleteVehicle);
        vehicleMenu.add(updateVehicle);
        vehicleMenu.add(showListVehicle);

        customerMenu = new JMenu("Client");
        addCustomer = new JMenuItem("Ajouter un client");
        showListCustomer = new JMenuItem("Liste clients");
        customerMenu.add(addCustomer);
        customerMenu.add(showListCustomer);

        saleMenu = new JMenu("Vente");
        addSale = new JMenuItem("Ajouter une vente");
        showListSale = new JMenuItem("Liste ventes");
        saleMenu.add(addSale);
        saleMenu.add(showListSale);

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
    public JMenuItem getDeleteVehicle() {
        return deleteVehicle;
    }
    public JMenuItem getUpdateVehicle() {return updateVehicle;}
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