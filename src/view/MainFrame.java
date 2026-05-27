package view;

import javax.swing.*;
import java.awt.*;

import controller.VehicleController;
import view.components.*;
import view.panels.*;
import model.Vehicle;

public class MainFrame extends JFrame {
    private HomePanel homePanel;
    private MenuBarView menuBarView;
    private JPanel container;
    private AddVehiclePanel addVehiclePanel;
    private SearchPanelKilometerBrandEnergy searchPanel;
    private SearchPanelTrialEnergyKilometer searchTrialPanel;
    private SearchPanelSalePeriod searchSalePanel;
    private SearchPanelRevenue searchRevenuePanel;
    private VehicleListPanel vehicleListPanel;
    private UpdateVehiclePanel updateVehiclePanel;

    public MainFrame() {
        super("Concessionnaire SiNo");
        this.setSize(1080, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        menuBarView = new MenuBarView();
        setJMenuBar(menuBarView);

        container = new JPanel(new BorderLayout());
        add(container, BorderLayout.CENTER);

        homePanel = new HomePanel();
        addVehiclePanel = new AddVehiclePanel();
        searchPanel = new SearchPanelKilometerBrandEnergy();
        searchTrialPanel = new SearchPanelTrialEnergyKilometer();
        searchSalePanel = new SearchPanelSalePeriod();
        searchRevenuePanel = new SearchPanelRevenue();

        showHome();
        this.setVisible(true);
    }

    public MenuBarView getmenuBarView() { return menuBarView; }

    public AddVehiclePanel getAddVehiclePanel() { return addVehiclePanel; }
    public SearchPanelKilometerBrandEnergy getSearchPanel() { return searchPanel; }
    public SearchPanelTrialEnergyKilometer getSearchTrialPanel() { return searchTrialPanel; }
    public SearchPanelSalePeriod getSearchSalePanel() { return searchSalePanel; }
    public SearchPanelRevenue getSearchRevenuePanel() { return searchRevenuePanel; }

    public void showHome() {
        container.removeAll();
        container.add(homePanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showSearchPanel() {
        container.removeAll();
        container.add(searchPanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showSearchTrialPanel() {
        container.removeAll();
        container.add(searchTrialPanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showSearchSalePanel() {
        container.removeAll();
        container.add(searchSalePanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showRevenuePanel() {
        container.removeAll();
        container.add(searchRevenuePanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showUpdateVehiclePanel(Vehicle vehicle) {
        updateVehiclePanel = new UpdateVehiclePanel(vehicle);
        container.removeAll();
        container.add(updateVehiclePanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showAddVehiclePanel() {
        container.removeAll();
        container.add(addVehiclePanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showVehicleList(VehicleController controller) {
        container.removeAll();
        vehicleListPanel = new VehicleListPanel(controller);
        container.add(vehicleListPanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public VehicleListPanel getVehicleListPanel() {
        return vehicleListPanel;
    }
    public UpdateVehiclePanel getUpdateVehiclePanel() {
        return updateVehiclePanel;
    }
}