package view.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Calendar;

public class SearchPanelSalePeriod extends JPanel {
    private JSpinner dateStartSpinner;
    private JSpinner dateEndSpinner;
    private JSpinner maxPriceSpinner;
    private JComboBox<String> paymentMethodComboBox;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public SearchPanelSalePeriod() {
        SpinnerDateModel startModel = new SpinnerDateModel();
        dateStartSpinner = new JSpinner(startModel);
        dateStartSpinner.setEditor(new JSpinner.DateEditor(dateStartSpinner, "yyyy-MM-dd"));

        SpinnerDateModel endModel = new SpinnerDateModel();
        dateEndSpinner = new JSpinner(endModel);
        dateEndSpinner.setEditor(new JSpinner.DateEditor(dateEndSpinner, "yyyy-MM-dd"));
        dateEndSpinner.setValue(Calendar.getInstance().getTime());

        maxPriceSpinner = new JSpinner(new SpinnerNumberModel(50000, 0, 999999, 1000));

        paymentMethodComboBox = new JComboBox<>(new String[]{
                "Cash", "Card", "Bank Transfer", "Financing"
        });

        String[] columns = {
                "Name", "Firstname", "Email",
                "Sale Date", "Sale Price",
                "VIN", "Kilometer", "Power"
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
        formPanel.setBorder(BorderFactory.createTitledBorder("Sale Search"));
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        formPanel.add(new JLabel("Start date :"));
        formPanel.add(dateStartSpinner);

        formPanel.add(new JLabel("End date :"));
        formPanel.add(dateEndSpinner);

        formPanel.add(new JLabel("Maximum price :"));
        formPanel.add(maxPriceSpinner);

        formPanel.add(new JLabel("Payment method :"));
        formPanel.add(paymentMethodComboBox);

        formPanel.add(new JLabel());

        JScrollPane scrollPane = new JScrollPane(resultTable);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JSpinner getDateStartSpinner() { return dateStartSpinner; }
    public JSpinner getDateEndSpinner() { return dateEndSpinner; }
    public JSpinner getMaxPriceSpinner() { return maxPriceSpinner; }
    public JComboBox<String> getPaymentMethodComboBox() { return paymentMethodComboBox; }
    public DefaultTableModel getTableModel() { return tableModel; }
}