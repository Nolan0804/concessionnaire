package controller;
import view.MainFrame;

public class MainController {
    private final MainFrame view;

    public MainController(MainFrame view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getmenuBarView().getExitApps().addActionListener(new ExitListener());
        view.getmenuBarView().getBackHome().addActionListener(e -> view.showHome());
    }
}