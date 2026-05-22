package view.components;

import controller.VehicleController;
import javax.swing.*;
import java.awt.*;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String action;
    private String vin;
    private String label;

    private boolean clicked;
    private VehicleController controller;
    private JTable table;

    public ButtonEditor(JCheckBox checkBox, JTable table, VehicleController controller, String action, String Label) {
        super(checkBox);
        this.table = table;
        this.action = action;
        this.controller = controller;
        this.label = Label;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        vin = table.getValueAt(row, 0).toString();
        button.setText(value.toString());
        clicked = true;

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        String vin = table.getValueAt(table.getSelectedRow(), 0).toString();

        try {
            if(action.equals("delete")) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if(confirm == JOptionPane.YES_OPTION) {
                    controller.deleteVehicle(vin);
                    controller.loadVehicles();
                }
            } else if(action.equals("update")) {
                controller.showUpdateVehicle(vin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return label;
    }
}