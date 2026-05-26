package view.components;

import javax.swing.*;

public class MenuBarView extends JMenuBar {
    private JMenuItem menu, exitApps, backHome;
    private JMenuItem vehicleMenu, showListVehicle, searchVehicleKilometerBrandEnergy, addVehicle;
    private JMenuItem customerMenu, showListCustomer;
    private JMenuItem saleMenu, showListSale;
    private JMenuItem garantyMenu, showListGaranty;

    public MenuBarView() {
        menu = new JMenu("Menu");
        backHome = new JMenuItem("Back to home");
        exitApps = new JMenuItem("Leave the app");
        menu.add(backHome);
        menu.add(exitApps);

        vehicleMenu = new JMenu("Vehicle");
        addVehicle = new JMenuItem("Add a car");
        showListVehicle = new JMenuItem("List cars");
        searchVehicleKilometerBrandEnergy = new JMenuItem("Search cars by kilometer brand energy");
        vehicleMenu.add(addVehicle);
        vehicleMenu.add(showListVehicle);
        vehicleMenu.add(searchVehicleKilometerBrandEnergy);

        customerMenu = new JMenu("Customer");
        showListCustomer = new JMenuItem("List customers");
        customerMenu.add(showListCustomer);

        saleMenu = new JMenu("Sale");
        showListSale = new JMenuItem("Liste ventes");
        saleMenu.add(showListSale);

        garantyMenu = new JMenu("Garanty");
        showListGaranty = new JMenuItem("List garanties");
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
    public JMenuItem getShowListVehicle() {
        return showListVehicle;
    }
    public JMenuItem getAddVehicle() {
        return addVehicle;
    }
    public JMenuItem getSearchVehicleKilometerBrandEnergy() {return searchVehicleKilometerBrandEnergy;}
}