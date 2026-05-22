package view.panels;

import exception.DataAccessException;
import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import view.components.ButtonRenderer;
import view.components.ButtonEditor;
import controller.VehicleController;
public class VehicleListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private VehicleController controller;

    public VehicleListPanel(VehicleController controller) {
        setLayout(new BorderLayout());
        this.controller = controller;
        String[] columns = {
                "VIN",
                "Brand",
                "Kilometer",
                "Price",
                "State",
                "Modifier",
                "Supprimer"
        };

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5 || column == 6;
            }
        };

        table = new JTable(model);

        table.setRowHeight(30);

        table.getColumn("Modifier").setCellRenderer(new ButtonRenderer());
        table.getColumn("Modifier").setCellEditor(new ButtonEditor(new JCheckBox(), table, controller,"update", "Modifier"));

        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox(), table, controller,"delete", "Supprimer"));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void loadVehicles(List<Vehicle> vehicles) {
        model.setRowCount(0);
        for (Vehicle vehicle : vehicles) {
            model.addRow(new Object[]{
                    vehicle.getVIN(),
                    vehicle.getBrand().getName(),
                    vehicle.getKilometer(),
                    vehicle.getSalePrice(),
                    vehicle.getState(),
                    "Modifier",
                    "Supprimer"
            });
        }
    }

    public JTable getTable() {
        return table;
    }
}