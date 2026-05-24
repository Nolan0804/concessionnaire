package controller;

import view.MainFrame;
import view.components.DialogMessage;
import exception.*;

public class MainController {
    private final MainFrame view;

    public MainController(MainFrame view) {
        this.view = view;
        try {
            new VehicleController(view);
        } catch (DataAccessException | InvalidInputException e) {
            DialogMessage.errorMessage(
                    view,
                    "Vehicle Controller Error",
                    e.getMessage()
            );
        }
        initController();
    }

    private void initController() {
        view.getmenuBarView().getExitApps().addActionListener(e -> System.exit(0));
        view.getmenuBarView().getBackHome().addActionListener(e -> view.showHome());
        view.getmenuBarView().getSearchVehicleKilometerBrandEnergy().addActionListener(e -> view.showSearchPanel());
        view.getmenuBarView().getSearchTrialEnergyKilometer().addActionListener(e -> view.showSearchTrialPanel());
        view.getmenuBarView().getSearchSalePeriod().addActionListener(e -> view.showSearchSalePanel());
        view.getmenuBarView().getAddVehicle().addActionListener(e -> view.showAddVehiclePanel());
        view.getmenuBarView().getShowListVehicle().addActionListener(e -> {
                try {
                    VehicleController vehicleController = new VehicleController(view);
                    vehicleController.loadVehicles();
                } catch (DataAccessException | InvalidInputException ex) {
                    DialogMessage.errorMessage(
                            view,
                            "Delete Vehicle Error",
                            ex.getMessage()
                    );
                }
            });

    }

}