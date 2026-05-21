package view.components;

import controller.VehicleController;
import exception.DataAccessException;
import exception.InvalidInputException;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.sql.SQLException;

public class ButtonEditor extends DefaultCellEditor {

    private JButton button;

    private String vin;

    private boolean clicked;
    private VehicleController controller;
    private JTable table;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);

        this.table = table;

        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        vin = table.getValueAt(row, 0).toString();

        button.setText(value.toString());

        clicked = true;

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if(clicked) {
            try {
                controller.deleteVehicle(vin);

                JOptionPane.showMessageDialog(button,
                        "Véhicule supprimé");

                ((javax.swing.table.DefaultTableModel)
                        table.getModel()).removeRow(table.getSelectedRow());

            } catch (InvalidInputException e) {
                e.printStackTrace();
            }
        }

        clicked = false;

        return button.getText();
    }
}