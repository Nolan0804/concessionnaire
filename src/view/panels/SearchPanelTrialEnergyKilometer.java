package view.panels;

import controller.EnergyController;
import model.Energy;
import view.components.DialogMessage;
import view.utils.ComboBoxUtils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class SearchPanelTrialEnergyKilometer extends JPanel {
    private JComboBox<Energy> energyComboBox;
    private JSpinner kilometerSpinner;
    private JCheckBox potentialBuyerCheckBox;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public SearchPanelTrialEnergyKilometer() {
        energyComboBox = new JComboBox<>();
        try {
            EnergyController energyController = new EnergyController();
            ComboBoxUtils.loadComboBox(energyComboBox, energyController.getAllEnergy());
        } catch (Exception e) {
            DialogMessage.errorMessage(this, "Loading Energy Error", e.getMessage());
        }

        kilometerSpinner = new JSpinner(new SpinnerNumberModel(50000, 0, 500000, 1000));

        potentialBuyerCheckBox = new JCheckBox();
        potentialBuyerCheckBox.setSelected(false);

        String[] columns = {
                "Name", "Firstname", "Email",
                "Trial Date", "Duration (min)", "Comment",
                "VIN", "Power", "Purchase Price",
                "Brand", "Brand Year"
        };

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        resultTable = new JTable(tableModel);
        resultTable.setRowHeight(25);
        resultTable.getTableHeader().setReorderingAllowed(false);

        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createTitledBorder("Trial Search"));
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Energy :"));
        formPanel.add(energyComboBox);

        formPanel.add(new JLabel("Maximum kilometer :"));
        formPanel.add(kilometerSpinner);

        formPanel.add(new JLabel("Potential buyer :"));
        formPanel.add(potentialBuyerCheckBox);

        formPanel.add(new JLabel());

        JScrollPane scrollPane = new JScrollPane(resultTable);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JComboBox<Energy> getEnergyComboBox() { return energyComboBox; }
    public JSpinner getKilometerSpinner() { return kilometerSpinner; }
    public JCheckBox getPotentialBuyerCheckBox() { return potentialBuyerCheckBox; }
    public DefaultTableModel getTableModel() { return tableModel; }
}

