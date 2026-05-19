package view;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import view.components.*;
import view.panels.*;

public class MainFrame extends JFrame {
    public MenuBarView menuBarView;
    private JPanel container;
    private AddVehiclePanel addVehiclePanel;
    public MainFrame() {
        super("Concessionnaire SiNo");
        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(MainFrame.class.getResource("/img/logo.png"))
        );
        this.setIconImage(icon.getImage());
        this.setSize(1080, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        menuBarView = new MenuBarView();
        setJMenuBar(menuBarView);

        container = new JPanel(new BorderLayout());
        container.setBackground(new Color(212, 212, 212));

        add(container, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public MenuBarView getmenuBarView() {
        return menuBarView;
    }

    public void showAddVehiclePanel() {
        container.removeAll();
        addVehiclePanel = new AddVehiclePanel();
        container.add(addVehiclePanel);
        container.revalidate();
        container.repaint();
    }

    public void showDeleteVehicleDialogPanel() {
        DeleteVehicleDialogPanel deleteVehicleDialogPanel = new DeleteVehicleDialogPanel(this);
    }
    public AddVehiclePanel getAddVehiclePanel() {
        return addVehiclePanel;
    }

}