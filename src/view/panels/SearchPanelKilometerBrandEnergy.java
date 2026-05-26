package view.panels;

import controller.BrandController;
import controller.EnergyController;

import model.Brand;
import model.Energy;
import view.components.DialogMessage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import view.utils.ComboBoxUtils;

public class SearchPanelKilometerBrandEnergy extends JPanel {
    private JComboBox<Brand> brandComboBox;
    private JComboBox<Energy> energyComboBox;
    private JSpinner kilometerSpinner;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public SearchPanelKilometerBrandEnergy() {
        brandComboBox = new JComboBox<Brand>();
         try {
            BrandController brandController = new BrandController();
            ComboBoxUtils.loadComboBox(brandComboBox, brandController.getAllBrand());

        } catch (Exception e) {
            DialogMessage.errorMessage(
                    this,
                    "Loading Brand Error",
                    e.getMessage()
            );
        }

        energyComboBox = new JComboBox<Energy>();
        try {
            EnergyController energyController = new EnergyController();
            ComboBoxUtils.loadComboBox(energyComboBox, energyController.getAllEnergy());

        } catch (Exception e) {
            DialogMessage.errorMessage(
                    this,
                    "Loading Energy Error",
                    e.getMessage()
            );
        }


        kilometerSpinner = new JSpinner(
                new SpinnerNumberModel(
                        50000,
                        0,
                        500000,
                        1000
                )
        );

        String[] columns = {
                "VIN",
                "Doors",
                "Sale Price",
                "Brand Year",
                "Eco Friendly"
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

        formPanel.setBorder(
                BorderFactory.createTitledBorder("Vehicle Search")
        );

        formPanel.setLayout(
                new GridLayout(4, 2, 10, 10)
        );

        formPanel.add(new JLabel("Brand :"));
        formPanel.add(brandComboBox);

        formPanel.add(new JLabel("Energy :"));
        formPanel.add(energyComboBox);

        formPanel.add(new JLabel("Maximum kilometer :"));
        formPanel.add(kilometerSpinner);

        formPanel.add(new JLabel());

        JScrollPane scrollPane = new JScrollPane(resultTable);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JComboBox<Brand> getBrandComboBox() {return brandComboBox;}
    public JComboBox<Energy> getEnergyComboBox() {return energyComboBox;}
    public JSpinner getKilometerSpinner() {return kilometerSpinner;}
    public DefaultTableModel getTableModel() {return tableModel;}
}