package controller;

import business.VehicleBusiness;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.*;
import view.components.DialogMessage;
import view.utils.ValidForms;
import view.MainFrame;
import java.util.List;
import view.panels.*;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import view.panels.UpdateVehiclePanel;

public class VehicleController {
    private final MainFrame view;

    public VehicleController(MainFrame view) throws DataAccessException, InvalidInputException{
        this.view = view;
        view.getSearchPanel().getBrandComboBox().addActionListener(e -> refreshTable());
        view.getSearchPanel().getEnergyComboBox().addActionListener(e -> refreshTable());
        view.getSearchPanel().getKilometerSpinner().addChangeListener(e -> refreshTable());
        refreshTable();

        view.getSearchTrialPanel().getEnergyComboBox().addActionListener(e -> refreshTrialTable());
        view.getSearchTrialPanel().getKilometerSpinner().addChangeListener(e -> refreshTrialTable());
        view.getSearchTrialPanel().getPotentialBuyerCheckBox().addActionListener(e -> refreshTrialTable());
        refreshTrialTable();

        view.getSearchSalePanel().getPaymentMethodComboBox().addActionListener(e -> refreshSaleTable());
        view.getSearchSalePanel().getMaxPriceSpinner().addChangeListener(e -> refreshSaleTable());
        view.getSearchSalePanel().getDateStartSpinner().addChangeListener(e -> refreshSaleTable());
        view.getSearchSalePanel().getDateEndSpinner().addChangeListener(e -> refreshSaleTable());
        refreshSaleTable();


        view.getAddVehiclePanel().getBtnAdd().addActionListener(e -> {
            try {
                addVehicle();
            } catch (DataAccessException | InvalidInputException ex) {
                DialogMessage.errorMessage(view, "Add Vehicle", ex.getMessage());}});

    }

    public void loadVehicles() {
        try {
            VehicleBusiness business = new VehicleBusiness();
            List<Vehicle> vehicles = business.getAllVehicle();
            view.showVehicleList(this);
            view.getVehicleListPanel().loadVehicles(vehicles);
        } catch (DataAccessException | InvalidInputException e) {
            e.printStackTrace();
        }
    }

    private void addVehicle() throws DataAccessException, InvalidInputException {
        try {
            AddVehiclePanel panel = view.getAddVehiclePanel();

            if(ValidForms.isEmpty(panel.getTxtVin().getText())) {
                DialogMessage.errorMessage(view, "VIN","VIN obligatoire");
                return;
            }

            if(!ValidForms.isValidVIN(panel.getTxtVin().getText())) {
                DialogMessage.errorMessage(view, "VIN", "Le VIN doit contenir 17 caractères");
                return;
            }

            if(!ValidForms.isPositiveDouble(panel.getTxtKilometer().getText())) {
                DialogMessage.errorMessage(view, "Kilometer","Kilométrage invalide");
                return;
            }

            if(!ValidForms.isPositiveDouble(panel.getTxtSalePrice().getText())) {
                DialogMessage.errorMessage(view, "Sale Price", "Prix de vente invalide");
                return;
            }

            if(!ValidForms.isPositiveDouble(panel.getTxtPurchasePrice().getText())) {
                DialogMessage.errorMessage(view, "Purshase Price", "Prix d'achat invalide");
                return;
            }

            if(!ValidForms.isPositiveInteger(panel.getTxtPower().getText())) {
                DialogMessage.errorMessage(view, "Power", "Puissance invalide");
                return;
            }

            String vin = panel.getTxtVin().getText();
            double kilometer = Double.parseDouble(panel.getTxtKilometer().getText().replace(",", "."));
            Date date = (Date) panel.getSpArrivalDate().getValue();
            LocalDate arrivalDate = LocalDate.now();
            double salePrice = Double.parseDouble(panel.getTxtSalePrice().getText().replace(",", "."));
            double purchasePrice = Double.parseDouble(panel.getTxtPurchasePrice().getText().replace(",", "."));
            String registration = panel.getTxtRegistration().getText();
            Integer power = Integer.parseInt(panel.getTxtPower().getText());
            String gearBox = (String) panel.getCbGearBox().getSelectedItem();
            Integer gearNumber = (Integer) panel.getSpGearNumber().getValue();
            Integer doorNumber = (Integer) panel.getSpDoorNumber().getValue();
            Integer seatNumber = (Integer) panel.getSpSeatNumber().getValue();
            String information = panel.getTxtInformation().getText();
            Integer euroStandard = (Integer) panel.getSpEuroStandard().getValue();
            boolean vatDeductible = panel.getChkVatDeductible().isSelected();
            Integer productionYear = (Integer) panel.getSpProductionYear().getValue();
            Garanty garanty = (Garanty) panel.getCbGaranty().getSelectedItem();
            Energy energy = (Energy) panel.getCbEnergy().getSelectedItem();
            Brand brand = (Brand) panel.getCbBrand().getSelectedItem();
            String hexColor = panel.getTxtHexColor().getText();
            String typeColor = panel.getCbColorType().getSelectedItem().toString();
            String state = (String) panel.getCbState().getSelectedItem();
            Customer saler = (Customer) panel.getCbSaler().getSelectedItem();

            Vehicle vehicle =
                    new Vehicle(
                            vin,
                            kilometer,
                            arrivalDate,
                            salePrice,
                            purchasePrice,
                            registration,
                            power,
                            gearBox,
                            gearNumber,
                            doorNumber,
                            seatNumber,
                            information,
                            euroStandard,
                            productionYear,
                            vatDeductible,
                            garanty,
                            hexColor,
                            typeColor,
                            energy,
                            brand,
                            state,
                            saler
                    );

            VehicleBusiness business = new VehicleBusiness();
            business.addVehicle(vehicle);
            DialogMessage.successMessage(view, "Add Vehicle", "Véhicule ajouté avec succès !");
        } catch (Exception e) {
            DialogMessage.errorMessage(view, "Add Vehicle", e.getMessage());
        }
    }

    public void updateVehicle(UpdateVehiclePanel view, Vehicle vehicle) {
        view.getBtnUpdate().addActionListener(e -> {
            try {
                Vehicle updatedVehicle = new Vehicle(
                        vehicle.getVIN(),
                        Double.parseDouble(view.getTxtKilometer().getText()),
                        vehicle.getArrivalDate(),
                        Double.parseDouble(view.getTxtSalePrice().getText()),
                        Double.parseDouble(view.getTxtPurchasePrice().getText()),
                        view.getTxtRegistration().getText(),
                        Integer.parseInt(view.getTxtPower().getText()),
                        view.getCbGearBox().getSelectedItem().toString(),
                        (Integer) view.getSpGearNumber().getValue(),
                        (Integer) view.getSpDoorNumber().getValue(),
                        (Integer) view.getSpSeatNumber().getValue(),
                        view.getTxtInformation().getText(),
                        (Integer) view.getSpEuroStandard().getValue(),
                        (Integer) view.getSpProductionYear().getValue(),
                        view.getChkVatDeductible().isSelected(),
                        (Garanty) view.getCbGaranty().getSelectedItem(),
                        view.getTxtHexColor().getText(),
                        view.getCbColorType().getSelectedItem().toString(),
                        (Energy) view.getCbEnergy().getSelectedItem(),
                        (Brand) view.getCbBrand().getSelectedItem(),
                        view.getCbState().getSelectedItem().toString(),
                        (Customer) view.getCbSaler().getSelectedItem()
                );

                VehicleBusiness vehicleBusiness = new VehicleBusiness();
                vehicleBusiness.updateVehicle(updatedVehicle);

                DialogMessage.successMessage(view, "Update Vehicle", "Véhicule mis à jour avec succès !");

            } catch (Exception ex) {
                ex.printStackTrace();
                DialogMessage.errorMessage(view, "Update Vehicle", ex.getMessage());
            }
        });
    }

    public void deleteVehicle(String vin) throws InvalidInputException {
        if(ValidForms.isEmpty(vin)) {
            throw new InvalidInputException("VIN obligatoire");
        }
        try {
            VehicleBusiness business = new VehicleBusiness();
            business.deleteVehicle(vin);
        } catch (InvalidInputException e) {
            DialogMessage.errorMessage(view, "Delete Vehicle", e.getMessage());
        }
    }

    public void showUpdateVehicle(String vin) throws Exception {
        VehicleBusiness business = new VehicleBusiness();
        Vehicle vehicle = business.getVehicleByVIN(vin);
        view.showUpdateVehiclePanel(vehicle);
    }

    private void refreshTable() {
        try {
            VehicleBusiness vehicleBusiness = new VehicleBusiness();
            Brand brand = (Brand) view.getSearchPanel().getBrandComboBox().getSelectedItem();
            Energy energy = (Energy) view.getSearchPanel().getEnergyComboBox().getSelectedItem();
            double kilometer = ((Number) view.getSearchPanel().getKilometerSpinner().getValue()).doubleValue();

            List<Object[]> vehicles = vehicleBusiness.searchVehicles(brand.getName(), energy.getName(), kilometer);

            DefaultTableModel model = view.getSearchPanel().getTableModel();
            model.setRowCount(0);

            for (Object[] row : vehicles) {
                model.addRow(row);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void refreshTrialTable() {
        try {
            VehicleBusiness vehicleBusiness = new VehicleBusiness();
            Energy energy = (Energy) view.getSearchTrialPanel().getEnergyComboBox().getSelectedItem();
            double kilometer = ((Number) view.getSearchTrialPanel().getKilometerSpinner().getValue()).doubleValue();
            boolean isPotentialBuyer = view.getSearchTrialPanel().getPotentialBuyerCheckBox().isSelected();

            List<Object[]> results = vehicleBusiness.searchTrials(energy.getName(), kilometer, isPotentialBuyer);

            DefaultTableModel model = view.getSearchTrialPanel().getTableModel();
            model.setRowCount(0);

            for (Object[] row : results) {
                model.addRow(row);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void refreshSaleTable() {
        try {
            VehicleBusiness vehicleBusiness = new VehicleBusiness();

            Date startDate = (Date) view.getSearchSalePanel().getDateStartSpinner().getValue();
            Date endDate = (Date) view.getSearchSalePanel().getDateEndSpinner().getValue();

            LocalDate dateStart = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateEnd = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            double maxPrice = ((Number) view.getSearchSalePanel().getMaxPriceSpinner().getValue()).doubleValue();
            String paymentMethod = (String) view.getSearchSalePanel().getPaymentMethodComboBox().getSelectedItem();

            List<Object[]> results = vehicleBusiness.searchSales(dateStart, dateEnd, maxPrice, paymentMethod);

            DefaultTableModel model = view.getSearchSalePanel().getTableModel();
            model.setRowCount(0);
            for (Object[] row : results) model.addRow(row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}