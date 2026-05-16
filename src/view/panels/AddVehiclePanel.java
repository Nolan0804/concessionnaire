package view.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddVehiclePanel extends JPanel {

    private JTextField txtVin;
    private JTextField txtKilometer;
    private JTextField txtSalePrice;
    private JTextField txtPurchasePrice;
    private JTextField txtRegistration;
    private JTextField txtPower;
    private JTextArea txtInformation;
    private JSpinner spArrivalDate;
    private JSpinner spGearNumber;
    private JSpinner spDoorNumber;
    private JSpinner spSeatNumber;
    private JSpinner spEuroStandard;
    private JSpinner spProductionYear;
    private JCheckBox chkVatDeductible;
    private JComboBox<String> cbGearBox;
    private JComboBox<String> cbGaranty;
    private JComboBox<String> cbEnergy;
    private JComboBox<String> cbBrand;
    private JComboBox<String> cbState;
    private JComboBox<String> cbColorType;
    private JComboBox<String> cbSaler;
    private JTextField txtHexColor;
    private JButton btnAdd;
    private JButton btnReset;

    public AddVehiclePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(230,230,230));

        JLabel title = new JLabel("Ajouter voiture dans le catalogue");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(new EmptyBorder(20,0,20,0));
        add(title, BorderLayout.NORTH);

        JPanel wrapper = new JPanel(
                new FlowLayout(FlowLayout.CENTER)
        );
        wrapper.setBackground(new Color(230,230,230));

        JPanel formPanel = new JPanel(
                new GridBagLayout()
        );
        formPanel.setPreferredSize(
                new Dimension(700, 950)
        );
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(200,200,200)
                        ),
                        new EmptyBorder(20,20,20,20)
                )
        );

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        txtVin = new JTextField();
        txtKilometer = new JTextField();
        txtSalePrice = new JTextField();
        txtPurchasePrice = new JTextField();
        txtRegistration = new JTextField();
        txtPower = new JTextField();
        txtInformation = new JTextArea(5,20);
        txtInformation.setLineWrap(true);
        txtInformation.setWrapStyleWord(true);
        txtHexColor = new JTextField();
        spArrivalDate = new JSpinner(
                new SpinnerDateModel()
        );

        JSpinner.DateEditor editor =
                new JSpinner.DateEditor(
                        spArrivalDate,
                        "yyyy-MM-dd"
                );
        spArrivalDate.setEditor(editor);
        spGearNumber = new JSpinner(
                new SpinnerNumberModel(6,1,12,1)
        );
        spDoorNumber = new JSpinner(
                new SpinnerNumberModel(5,1,10,1)
        );
        spSeatNumber = new JSpinner(
                new SpinnerNumberModel(5,1,10,1)
        );
        spEuroStandard = new JSpinner(
                new SpinnerNumberModel(6,1,10,1)
        );
        spProductionYear = new JSpinner(
                new SpinnerNumberModel(2024,1900,2100,1)
        );
        chkVatDeductible = new JCheckBox("VAT deductible");
        chkVatDeductible.setBackground(Color.WHITE);

        cbGearBox = new JComboBox<>();
        cbGearBox.addItem("Automatic");
        cbGearBox.addItem("Manual");

        cbGaranty = new JComboBox<>();
        cbGaranty.addItem("Basic");
        cbGaranty.addItem("Premium");
        cbGaranty.addItem("Gold");

        cbEnergy = new JComboBox<>();
        cbEnergy.addItem("Petrol");
        cbEnergy.addItem("Diesel");
        cbEnergy.addItem("Hybrid");
        cbEnergy.addItem("Electric");

        cbBrand = new JComboBox<>();
        cbBrand.addItem("BMW");
        cbBrand.addItem("Audi");
        cbBrand.addItem("Toyota");
        cbBrand.addItem("Ford");
        cbBrand.addItem("Renault");

        cbState = new JComboBox<>();
        cbState.addItem("New");
        cbState.addItem("Excellent");
        cbState.addItem("Good");
        cbState.addItem("Average");
        cbState.addItem("Damaged");
        cbState.addItem("Sold");

        cbColorType = new JComboBox<>();
        cbColorType.addItem("Glossy");
        cbColorType.addItem("Matte");
        cbColorType.addItem("Metallic");
        cbColorType.addItem("Pearl");

        cbSaler = new JComboBox<>();
        cbSaler.addItem("1");
        cbSaler.addItem("2");
        cbSaler.addItem("3");

        btnAdd = new JButton("Ajouter");

        btnReset = new JButton("Reset");

        btnAdd.setPreferredSize(new Dimension(140,40));
        btnReset.setPreferredSize(new Dimension(140,40));

        int y = 0;
        addLine(formPanel, gbc, y++, "VIN (Vehicle Identification Number)", txtVin);
        addLine(formPanel, gbc, y++, "Kilometer", txtKilometer);
        addLine(formPanel, gbc, y++, "Arrival date", spArrivalDate);
        addLine(formPanel, gbc, y++, "Sale price", txtSalePrice);
        addLine(formPanel, gbc, y++, "Purchase price", txtPurchasePrice);
        addLine(formPanel, gbc, y++, "Registration", txtRegistration);
        addLine(formPanel, gbc, y++, "Power", txtPower);
        addLine(formPanel, gbc, y++, "Gear box", cbGearBox);
        addLine(formPanel, gbc, y++, "Gear number", spGearNumber);
        addLine(formPanel, gbc, y++, "Doors", spDoorNumber);
        addLine(formPanel, gbc, y++, "Seats", spSeatNumber);

        gbc.gridx = 0;
        gbc.gridy = y;

        formPanel.add(new JLabel("Information"), gbc);

        gbc.gridx = 1;

        JScrollPane infoScroll =
                new JScrollPane(txtInformation);

        infoScroll.setPreferredSize(
                new Dimension(300,120)
        );

        formPanel.add(infoScroll, gbc);

        y++;

        addLine(formPanel, gbc, y++, "Euro standard", spEuroStandard);

        gbc.gridx = 0;
        gbc.gridy = y;

        formPanel.add(new JLabel("VAT"), gbc);

        gbc.gridx = 1;

        formPanel.add(chkVatDeductible, gbc);

        y++;

        addLine(formPanel, gbc, y++, "Production year", spProductionYear);
        addLine(formPanel, gbc, y++, "Garanty", cbGaranty);
        addLine(formPanel, gbc, y++, "Hex color", txtHexColor);
        addLine(formPanel, gbc, y++, "Color type", cbColorType);
        addLine(formPanel, gbc, y++, "Energy", cbEnergy);
        addLine(formPanel, gbc, y++, "Brand", cbBrand);
        addLine(formPanel, gbc, y++, "State", cbState);
        addLine(formPanel, gbc, y++, "Saler", cbSaler);

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        10
                )
        );

        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnReset);

        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 2;

        formPanel.add(buttonPanel, gbc);
        wrapper.add(formPanel);

        JScrollPane scrollPane =
                new JScrollPane(wrapper);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void addLine(JPanel panel, GridBagConstraints gbc, int y, String label, Component component) {
        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.weightx = 0.3;
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        panel.add(jLabel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.7;


        panel.add(component, gbc);
    }
}