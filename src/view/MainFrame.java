package view;

import javax.swing.*;
import java.awt.*;

import view.components.*;
import view.panels.*;

public class MainFrame extends JFrame {
    private HomePanel homePanel;
    private  MenuBarView menuBarView;
    private JPanel container;
    private AddVehiclePanel addVehiclePanel;
    private SearchPanelKilometerBrandEnergy searchPanel;
    private VehicleListPanel vehicleListPanel;

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
        vehicleListPanel = new VehicleListPanel();
        addVehiclePanel = new AddVehiclePanel();
        searchPanel = new SearchPanelKilometerBrandEnergy();

        showHome();
        this.setVisible(true);
    }

    public MenuBarView getmenuBarView() {return menuBarView;}

    public AddVehiclePanel getAddVehiclePanel() {return addVehiclePanel;}
    public SearchPanelKilometerBrandEnergy getSearchPanel() {return searchPanel;}

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

    public void showAddVehiclePanel() {
        container.removeAll();
        container.add(addVehiclePanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public void showVehicleList() {
        container.removeAll();
        container.add(vehicleListPanel, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    public VehicleListPanel getVehicleListPanel() {
        return vehicleListPanel;
    }
}