package view.panels;

import controller.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.Year;
import config.AppConfig;
import view.components.DialogMessage;
import view.utils.ComboBoxUtils;

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
    private JComboBox<String> cbColorType;
    private JComboBox<String> cbState;

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

    public UpdateVehiclePanel(Vehicle vehicle) {
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Update VIN n° : " + vehicle.getVIN());

        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));

        add(lblTitle, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Kilometer"));
        txtKilometer = new JTextField(String.valueOf(vehicle.getKilometer()));
        formPanel.add(txtKilometer);

        formPanel.add(new JLabel("Sale price"));
        txtSalePrice = new JTextField(String.valueOf(vehicle.getSalePrice()));
        formPanel.add(txtSalePrice);

        formPanel.add(new JLabel("Purchase price"));
        txtPurchasePrice = new JTextField(String.valueOf(vehicle.getPurchasePrice()));
        formPanel.add(txtPurchasePrice);

        formPanel.add(new JLabel("Registration"));
        txtRegistration = new JTextField(vehicle.getRegistrationNumber());
        formPanel.add(txtRegistration);

        formPanel.add(new JLabel("Power"));
        txtPower = new JTextField(String.valueOf(vehicle.getPower()));
        formPanel.add(txtPower);

        formPanel.add(new JLabel("Hex color"));
        txtHexColor = new JTextField(vehicle.getHexColor());
        formPanel.add(txtHexColor);

        formPanel.add(new JLabel("Information"));
        txtInformation = new JTextArea(vehicle.getInformation());
        formPanel.add(new JScrollPane(txtInformation));

        formPanel.add(new JLabel("VAT deductible"));
        chkVatDeductible = new JCheckBox();
        chkVatDeductible.setSelected(vehicle.getIsVatDeductible());
        formPanel.add(chkVatDeductible);

        formPanel.add(new JLabel("Gear box"));
        cbGearBox = new JComboBox<>(AppConfig.GEARBOX_TYPES);
        cbGearBox.setSelectedItem(vehicle.getGearBox());
        formPanel.add(cbGearBox);

        formPanel.add(new JLabel("Color type"));
        cbColorType = new JComboBox<>(AppConfig.COLOR_TYPES);
        cbColorType.setSelectedItem(vehicle.getTypeColor());
        formPanel.add(cbColorType);

        formPanel.add(new JLabel("State"));
        cbState = new JComboBox<>(AppConfig.VEHICLE_STATES);
        cbState.setSelectedItem(vehicle.getState());

        formPanel.add(cbState);

        formPanel.add(new JLabel("Garanty"));
        cbGaranty = new JComboBox<Garanty>();
        try {
            GarantyController garantyController = new GarantyController();
            ComboBoxUtils.loadComboBox(cbGaranty, garantyController.getAllGaranty());
        } catch (Exception e) {
            DialogMessage.errorMessage(
                    this,
                    "Loading Garanty Error",
                    e.getMessage()
            );
        }
        System.out.println("Selected garanty : " + vehicle.getGaranty());
        cbGaranty.setSelectedItem(vehicle.getGaranty());
        formPanel.add(cbGaranty);

        formPanel.add(new JLabel("Energy"));
        cbEnergy = new JComboBox<Energy>();
        try {
            EnergyController energyController = new EnergyController();
            ComboBoxUtils.loadComboBox(cbEnergy, energyController.getAllEnergy());
        } catch (Exception e) {
            DialogMessage.errorMessage(
                    this,
                    "Loading Energy Error",
                    e.getMessage()
            );
        }
        cbEnergy.setSelectedItem(vehicle.getEnergy());
        formPanel.add(cbEnergy);


        formPanel.add(new JLabel("Brand"));
        cbBrand = new JComboBox<Brand>();
        try {
            BrandController brandController = new BrandController();
            ComboBoxUtils.loadComboBox(cbBrand, brandController.getAllBrand());
        } catch (Exception e) {
            DialogMessage.errorMessage(
                    this,
                    "Loading Brand Error",
                    e.getMessage()
            );
        }
        cbBrand.setSelectedItem(vehicle.getBrand());
        formPanel.add(cbBrand);

        formPanel.add(new JLabel("Saler"));
        cbSaler = new JComboBox<Customer>();
        try {
            CustomerController customerController = new CustomerController();
            ComboBoxUtils.loadComboBox(cbSaler, customerController.getAllCustomer());
        } catch (Exception e) {
            DialogMessage.errorMessage(
                    this,
                    "Loading Customer Error",
                    e.getMessage()
            );
        }
        cbSaler.setSelectedItem(vehicle.getSaler());
        formPanel.add(cbSaler);

        formPanel.add(new JLabel("Gear number"));
        spGearNumber = new JSpinner(new SpinnerNumberModel((int) vehicle.getGearNumber(),AppConfig.GEARBOX_LOWEST,AppConfig.GEARBOX_HIGHEST,1));
        formPanel.add(spGearNumber);

        formPanel.add(new JLabel("Door number"));
        spDoorNumber = new JSpinner(new SpinnerNumberModel((int) vehicle.getDoorNumber(), AppConfig.DOOR_LOWEST, AppConfig.DOOR_HIGHEST, 1));
        formPanel.add(spDoorNumber);

        formPanel.add(new JLabel("Seat number"));
        spSeatNumber = new JSpinner(new SpinnerNumberModel((int) vehicle.getSeatNumber(), AppConfig.SEAT_LOWEST, AppConfig.SEAT_HIGHEST, 1));
        formPanel.add(spSeatNumber);

        formPanel.add(new JLabel("Euro standard"));

        spEuroStandard =
                new JSpinner(
                        new SpinnerNumberModel(
                                (int) vehicle.getEuroStandard(),
                                AppConfig.EURO_STANDARD_LOWEST,
                                AppConfig.SEAT_HIGHEST,
                                1
                        )
                );

        formPanel.add(spEuroStandard);

        formPanel.add(new JLabel("Production year"));
        spProductionYear =
                new JSpinner(new SpinnerNumberModel(
                        (int) vehicle.getYearOfProduction(),
                        AppConfig.YEAR_PRODUCTION_LOWEST,
                        Year.now().getValue(),
                        1)
                );
        formPanel.add(spProductionYear);

        btnUpdate = new JButton("Valider la modification");

        formPanel.add(new JLabel());
        formPanel.add(btnUpdate);
        add(new JScrollPane(formPanel), BorderLayout.CENTER);
    }

    public JButton getBtnUpdate() {return btnUpdate;}
    public JTextField getTxtKilometer() {return txtKilometer;}
    public JTextField getTxtSalePrice() {return txtSalePrice;}
    public JTextField getTxtPurchasePrice() {
        return txtPurchasePrice;
    }
    public JTextField getTxtRegistration() {return txtRegistration;}
    public JTextField getTxtPower() {return txtPower;}
    public JTextField getTxtHexColor() {return txtHexColor;}
    public JTextArea getTxtInformation() {return txtInformation;}
    public JCheckBox getChkVatDeductible() {return chkVatDeductible;}
    public JComboBox<String> getCbGearBox() {return cbGearBox;}
    public JComboBox<String> getCbColorType() {return cbColorType;}
    public JComboBox<String> getCbState() {return cbState;}
    public JComboBox<Garanty> getCbGaranty() {return cbGaranty;}
    public JComboBox<Energy> getCbEnergy() {return cbEnergy;}
    public JComboBox<Brand> getCbBrand() {return cbBrand;}
    public JComboBox<Customer> getCbSaler() {return cbSaler;}
    public JSpinner getSpGearNumber() {return spGearNumber;}
    public JSpinner getSpDoorNumber() {return spDoorNumber;}
    public JSpinner getSpSeatNumber() {return spSeatNumber;}
    public JSpinner getSpEuroStandard() {return spEuroStandard;}
    public JSpinner getSpProductionYear() {return spProductionYear;}
}