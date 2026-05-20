package view;

import javax.swing.*;
import java.awt.*;

import view.components.*;
import view.panels.*;

public class MainFrame extends JFrame {

    private HomePanel homePanel;

    public MenuBarView menuBarView;

    private JPanel container;

    private AddVehiclePanel addVehiclePanel;

    public MainFrame() {

        super("Concessionnaire SiNo");

        this.setSize(1080, 600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        // MENU
        menuBarView = new MenuBarView();

        setJMenuBar(menuBarView);

        // CONTAINER PRINCIPAL
        container = new JPanel(new BorderLayout());

        add(container, BorderLayout.CENTER);

        // PANELS
        homePanel = new HomePanel();

        addVehiclePanel = new AddVehiclePanel();

        // HOME AU DEMARRAGE
        showHome();

        this.setVisible(true);
    }

    public MenuBarView getmenuBarView() {

        return menuBarView;
    }

    public AddVehiclePanel getAddVehiclePanel() {

        return addVehiclePanel;
    }

    // HOME
    public void showHome() {

        container.removeAll();

        container.add(homePanel, BorderLayout.CENTER);

        container.revalidate();

        container.repaint();
    }

    // ADD VEHICLE
    public void showAddVehiclePanel() {

        container.removeAll();

        container.add(addVehiclePanel, BorderLayout.CENTER);

        container.revalidate();

        container.repaint();
    }

    // DELETE
    public void showDeleteVehicleDialogPanel() {

        new DeleteVehicleDialogPanel(this);
    }
}