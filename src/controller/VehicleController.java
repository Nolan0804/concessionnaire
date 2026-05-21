package controller;

import business.VehicleBusiness;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.*;
import view.components.DialogMessage;
import view.utils.ValidForms;
import view.MainFrame;
import view.panels.AddVehiclePanel;
import view.panels.DeleteVehicleDialogPanel;

import java.time.LocalDate;
import java.util.Date;

public class VehicleController {
    private final MainFrame view;

    public VehicleController(MainFrame view) throws DataAccessException, InvalidInputException{
        this.view = view;
        initController();
    }

    public void initController() {
        view.getAddVehiclePanel().getBtnAdd().addActionListener(e -> {
            try {
                addVehicle();
            } catch (DataAccessException | InvalidInputException ex) {
                DialogMessage.errorMessage(view, "Add Vehicle", ex.getMessage());}});
    }

    public void initDeleteDialog(DeleteVehicleDialogPanel dialog) throws DataAccessException, InvalidInputException{
        dialog.getBtnCancel()
                .addActionListener(e ->
                        dialog.dispose()
                );

        dialog.getBtnDelete().addActionListener(e -> {
            try {
                    deleteVehicle(dialog);
                    DialogMessage.successMessage(view, "Vehicle", "Véhicule supprimé");
                        dialog.dispose();
                    } catch (Exception ex) {
                    DialogMessage.errorMessage(
                                view,
                                "Vehicle",
                                ex.getMessage()
                        );
                    }
                });
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
            new DialogMessage();

        } catch (Exception e) {
            DialogMessage.errorMessage(
                    view,
                    "Add Vehicle",
                    e.getMessage()
            );
        }
    }

    private void deleteVehicle(DeleteVehicleDialogPanel dialog) throws Exception {
        String vin = dialog.getTxtVin().getText();

        if(ValidForms.isEmpty(vin)) {
            throw new Exception("VIN obligatoire");
        }

        VehicleBusiness business = new VehicleBusiness();
        business.deleteVehicle(vin);
    }
}