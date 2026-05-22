package view.panels;

import model.*;

import javax.swing.*;
import java.awt.*;

public class UpdateVehiclePanel extends JPanel {

    private JTextField txtVin;
    private JTextField txtKilometer;
    private JTextField txtSalePrice;
    private JTextField txtPurchasePrice;
    private JTextField txtRegistration;
    private JTextField txtPower;
    private JTextField txtHexColor;

    private JTextArea txtInformation;

    private JCheckBox chkVatDeductible;

    private JComboBox<String> cbGearBox;
    private JComboBox<String> cbState;
    private JComboBox<String> cbColorType;

    private JComboBox<Garanty> cbGaranty;
    private JComboBox<Energy> cbEnergy;
    private JComboBox<Brand> cbBrand;
    private JComboBox<Customer> cbSaler;

    private JSpinner spGearNumber;
    private JSpinner spDoorNumber;
    private JSpinner spSeatNumber;
    private JSpinner spEuroStandard;
    private JSpinner spProductionYear;

    private JButton btnUpdate;

    public UpdateVehiclePanel(
            Vehicle vehicle
    ) {

 }
}