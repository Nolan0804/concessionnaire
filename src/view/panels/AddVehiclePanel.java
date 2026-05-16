package view.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.Year;
import java.util.Date;
import java.util.Calendar;
import javax.swing.text.AbstractDocument;
import utils.LimitDocumentFilter;
import utils.NumberOnlyFilter;

public class AddVehiclePanel extends JPanel {
    private JTextField txtVin;
    private JTextField txtKilometer;
    private JTextField txtSalePrice;
    private JTextField txtPurchasePrice;
    private JTextField txtRegistration;
    private JTextField txtPower;
    private JTextField txtHexColor;
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
    private JButton btnAdd;

    public AddVehiclePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(230,230,230));

        JLabel title = new JLabel("Ajouter voiture dans le catalogue");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(new EmptyBorder(20,0,20,0));
        add(title, BorderLayout.NORTH);

        JPanel wrapper = new JPanel(
                new FlowLayout(FlowLayout.CENTER)
        );
        wrapper.setBackground(new Color(230,230,230));

        JPanel formPanel = new JPanel(new GridBagLayout());

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

        txtVin = new JTextField("XXXXXXXXXXXXXXXXX");
        ((AbstractDocument) txtVin.getDocument()).setDocumentFilter(new LimitDocumentFilter(17));

        txtKilometer = new JTextField("0.00");
        ((AbstractDocument) txtKilometer.getDocument()).setDocumentFilter(new NumberOnlyFilter());

        txtSalePrice = new JTextField("0.00");
        ((AbstractDocument) txtSalePrice.getDocument()).setDocumentFilter(new NumberOnlyFilter());

        txtPurchasePrice = new JTextField("0.00");
        ((AbstractDocument) txtPurchasePrice.getDocument()).setDocumentFilter(new NumberOnlyFilter());

        txtRegistration = new JTextField("X-XXX-XXX");

        txtPower = new JTextField("0.00");
        ((AbstractDocument) txtPower.getDocument()).setDocumentFilter(new NumberOnlyFilter());

        spArrivalDate = new JSpinner(
                new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_MONTH)
        );

        JSpinner.DateEditor editorDate = new JSpinner.DateEditor(spArrivalDate, "yyyy-MM-dd");
        spArrivalDate.setEditor(editorDate);

        spGearNumber = new JSpinner(
                new SpinnerNumberModel(6,5,8,1)
        );
        spDoorNumber = new JSpinner(
                new SpinnerNumberModel(5,3,5,1)
        );
        spSeatNumber = new JSpinner(
                new SpinnerNumberModel(5,1,9,1)
        );
        spEuroStandard = new JSpinner(
                new SpinnerNumberModel(1,1,7,1)
        );
        spProductionYear = new JSpinner(
                new SpinnerNumberModel(2020,1886,Year.now().getValue(),1)
        );

        JSpinner.NumberEditor editorProductionYear = new JSpinner.NumberEditor(spProductionYear, "#");
        spProductionYear.setEditor(editorProductionYear);

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

        txtHexColor = new JTextField("#fcba03");

        cbColorType = new JComboBox<>();
        cbColorType.addItem("Glossy");
        cbColorType.addItem("Matte");
        cbColorType.addItem("Satin");
        cbColorType.addItem("Metallic");
        cbColorType.addItem("Pearlescent");

        cbSaler = new JComboBox<>();
        cbSaler.addItem("1");
        cbSaler.addItem("2");
        cbSaler.addItem("3");

        btnAdd = new JButton("Ajouter");

        btnAdd.setPreferredSize(new Dimension(140,40));

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

        gbc.gridy = y;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 1;

        txtInformation = new JTextArea(8, 35);
        txtInformation.setLineWrap(true);
        txtInformation.setWrapStyleWord(true);
        addLine(formPanel, gbc, y++, "Information", txtInformation);
        JScrollPane infoScroll = new JScrollPane(txtInformation);

        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(infoScroll, gbc);
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        jLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(jLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        if(!(component instanceof JScrollPane)) {
            component.setPreferredSize(new Dimension(300,35));
        }
        panel.add(component, gbc);
    }
}