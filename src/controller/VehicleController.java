package controller;

import business.VehicleBusiness;
import model.*;
import view.utils.ValidForms;
import view.MainFrame;
import view.panels.AddVehiclePanel;
import view.panels.DeleteVehicleDialogPanel;
import view.panels.VehicleAdded;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;

public class VehicleController {
    private final MainFrame view;

    public VehicleController(MainFrame view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getAddVehiclePanel().getBtnAdd().addActionListener(e -> addVehicle());
    }

    public void initDeleteDialog(DeleteVehicleDialogPanel dialog) {
        dialog.getBtnCancel().addActionListener(e -> dialog.dispose());
        dialog.getBtnDelete().addActionListener(e -> deleteVehicle(dialog));
    }

    private void addVehicle() {
        try {
            AddVehiclePanel panel = view.getAddVehiclePanel();

            if(ValidForms.isEmpty(panel.getTxtVin().getText())) {
                VehicleAdded.errorMessage(view, "VIN obligatoire");
                return;
            }

            if(!ValidForms.isValidVIN(panel.getTxtVin().getText())) {
                VehicleAdded.errorMessage(view, "Le VIN doit contenir 17 caractères");
                return;
            }

            if(!ValidForms.isPositiveDouble(panel.getTxtKilometer().getText())) {
                VehicleAdded.errorMessage(view, "Kilométrage invalide");
                return;
            }

            if(!ValidForms.isPositiveDouble(panel.getTxtSalePrice().getText())) {
                VehicleAdded.errorMessage(view, "Prix de vente invalide");
                return;
            }

            if(!ValidForms.isPositiveDouble(panel.getTxtPurchasePrice().getText())) {
                VehicleAdded.errorMessage(view, "Prix d'achat invalide");
                return;
            }

            if(!ValidForms.isPositiveInteger(panel.getTxtPower().getText())) {
                VehicleAdded.errorMessage(view, "Puissance invalide");
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
            new VehicleAdded();

        } catch (Exception e) {
            VehicleAdded.errorMessage(
                    view,
                    e.getMessage()
            );
        }
    }

    private void deleteVehicle(DeleteVehicleDialogPanel dialog) {
        try {
            String vin = dialog.getTxtVin().getText();

            if(ValidForms.isEmpty(vin)) {
                VehicleAdded.errorMessage(
                        view,
                        "VIN obligatoire"
                );
                return;
            }

            if(!ValidForms.isValidVIN(vin)) {
                VehicleAdded.errorMessage(
                        view,
                        "VIN invalide"
                );
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                            view,
                            "Supprimer le véhicule ?",
                            "Confirmation",
                            JOptionPane.YES_NO_OPTION
                    );

            if(confirm != JOptionPane.YES_OPTION) {
                return;
            }

            VehicleBusiness business = new VehicleBusiness();
            if(!business.vehicleExists(vin)) {
                VehicleAdded.errorMessage(
                        view,
                        "Ce VIN n'existe pas"
                );
                return;
            }

            business.deleteVehicle(vin);
            VehicleAdded.successMessage(
                    view,
                    "Véhicule supprimé"
            );
            dialog.dispose();
        } catch (Exception e) {
            VehicleAdded.errorMessage(
                    view,
                    e.getMessage()
            );
        }
    }
}