package controller;
import view.MainFrame;

public class MainController {

    private final MainFrame view;

    public MainController(MainFrame view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.menuBar.getExitApps().addActionListener(new ExitListener());
        view.menuBar.getBackHome().addActionListener(e -> view.showHome());
    }
}