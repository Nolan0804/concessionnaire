package controller;
import view.MainFrame;

public class MainController {
    private final MainFrame view;

    public MainController(MainFrame view) {
        this.view = view;
        view.getmenuBarView().getExitApps().addActionListener(new ExitListener());
        view.getmenuBarView().getAddVehicle().addActionListener(e -> view.showAddVehiclePanel());
    }

}