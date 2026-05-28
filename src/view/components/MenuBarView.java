package view.components;

import javax.swing.*;

public class MenuBarView extends JMenuBar {
    private JMenuItem menu, exitApps, backHome;
    private JMenuItem vehicleMenu, showListVehicle, searchVehicleKilometerBrandEnergy, addVehicle;
    private JMenuItem customerMenu, showListCustomer;
    private JMenuItem saleMenu, showListSale, searchSalePeriod;
    private JMenuItem revenueCalculation;
    private JMenuItem garantyMenu, showListGaranty;
    private JMenuItem searchTrialEnergyKilometer;

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

        searchTrialEnergyKilometer = new JMenuItem("Search trials by energy kilometer potential buyer");
        customerMenu.add(searchTrialEnergyKilometer);


        saleMenu = new JMenu("Sale");
        showListSale = new JMenuItem("List sales");
        searchSalePeriod = new JMenuItem("Search sales by period");
        saleMenu.add(showListSale);
        saleMenu.add(searchSalePeriod);

        revenueCalculation = new JMenuItem("Revenue calculation");
        saleMenu.add(showListSale);
        saleMenu.add(searchSalePeriod);
        saleMenu.add(revenueCalculation);

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
    public JMenuItem getShowListSale() {
        return showListSale;
    }
    public JMenuItem getGarantyMenu() {
        return garantyMenu;
    }
    public JMenuItem getShowListGaranty() {return showListGaranty;}
    public JMenuItem getSearchTrialEnergyKilometer() { return searchTrialEnergyKilometer; }
    public JMenuItem getSearchSalePeriod() { return searchSalePeriod; }
    public JMenuItem getRevenueCalculation() { return revenueCalculation; }
}