package controller;

import view.MainFrame;
import view.panels.DeleteVehicleDialogPanel;
import view.components.DialogMessage;
import exception.*;

public class MainController {

    private final MainFrame view;

    private VehicleController vehicleController;
    private DeleteVehicleDialogPanel dialog;
    public MainController(MainFrame view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getmenuBarView()
                .getExitApps()
                .addActionListener(e ->
                        System.exit(0)
                );

        view.getmenuBarView()
                .getBackHome()
                .addActionListener(e ->
                        view.showHome()
                );

        view.getmenuBarView()
                .getAddVehicle()
                .addActionListener(e ->
                        view.showAddVehiclePanel()
                );

        view.getmenuBarView().getDeleteVehicle().addActionListener(e -> {
                try {
                    VehicleController vehicleController = new VehicleController(view);
                    DeleteVehicleDialogPanel dialog = view.showDeleteVehicleDialog();
                    vehicleController.initDeleteDialog(dialog);
                    dialog.setVisible(true);
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