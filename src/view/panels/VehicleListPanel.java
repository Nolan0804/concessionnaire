package view.panels;

import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import view.components.ButtonRenderer;
import view.components.ButtonEditor;

public class VehicleListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    public VehicleListPanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
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

                return false;
            }
        };

        table = new JTable(model);

        table.setRowHeight(30);

        table.getColumn("Modifier").setCellRenderer(new ButtonRenderer());
        table.getColumn("Modifier").setCellEditor(new ButtonEditor(
                new JCheckBox(),
                table));

        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(
                new JCheckBox(),
                table));

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