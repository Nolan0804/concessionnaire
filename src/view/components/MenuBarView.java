package view.components;

import javax.swing.*;

public class MenuBarView extends JMenuBar {
    private JMenuItem menu, exitApps, backHome;
    private JMenuItem vehicleMenu, showListVehicle, searchVehicleKilometerBrandEnergy, addVehicle;
    private JMenuItem customerMenu;
    private JMenuItem saleMenu, searchSalePeriod;
    private JMenuItem revenueCalculation;
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
        searchTrialEnergyKilometer = new JMenuItem("Search trials by energy kilometer potential buyer");
        customerMenu.add(searchTrialEnergyKilometer);

        saleMenu = new JMenu("Sale");
        searchSalePeriod = new JMenuItem("Search sales by period");
        revenueCalculation = new JMenuItem("Revenue calculation");
        saleMenu.add(searchSalePeriod);
        saleMenu.add(revenueCalculation);

        add(menu);
        add(saleMenu);
        add(vehicleMenu);
        add(customerMenu);
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
    public JMenuItem getSearchTrialEnergyKilometer() { return searchTrialEnergyKilometer; }
    public JMenuItem getSearchSalePeriod() { return searchSalePeriod; }
    public JMenuItem getRevenueCalculation() { return revenueCalculation; }
}