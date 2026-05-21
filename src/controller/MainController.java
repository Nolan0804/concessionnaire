package controller;

import view.MainFrame;
import view.panels.DeleteVehicleDialogPanel;

public class MainController {

    private final MainFrame view;

    private VehicleController vehicleController;

    public MainController(MainFrame view) {
        this.view = view;
        vehicleController = new VehicleController(view);

        view.getmenuBarView().getExitApps().addActionListener(e ->{
            System.exit(0);
        });

        view.getmenuBarView()
                .getBackHome()
                .addActionListener(e -> {
                    view.showHome();
                });

        view.getmenuBarView().getAddVehicle().addActionListener(e -> {view.showAddVehiclePanel();});

        view.getmenuBarView()
                .getDeleteVehicle()
                .addActionListener(e -> {
                    DeleteVehicleDialogPanel dialog = new DeleteVehicleDialogPanel(view);
                    vehicleController.initDeleteDialog(dialog);
                    dialog.setVisible(true);
                });
    }
}