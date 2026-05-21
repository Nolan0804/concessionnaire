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
        backHome = new JMenuItem("Back to home");
        exitApps = new JMenuItem("Leave the app");
        menu.add(backHome);
        menu.add(exitApps);

        vehicleMenu = new JMenu("Vehicle");
        addVehicle = new JMenuItem("Add a car");
        deleteVehicle = new JMenuItem("Delete a car");
        updateVehicle = new JMenuItem("Update a car");
        showListVehicle = new JMenuItem("List cars");
        vehicleMenu.add(addVehicle);
        vehicleMenu.add(deleteVehicle);
        vehicleMenu.add(updateVehicle);
        vehicleMenu.add(showListVehicle);

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
    public JMenuItem getSaleMenu() {
        return saleMenu;
    }
    public JMenuItem getShowListSale() {
        return showListSale;
    }
    public JMenuItem getGarantyMenu() {
        return garantyMenu;
    }
    public JMenuItem getShowListGaranty() {
        return showListGaranty;
    }
}