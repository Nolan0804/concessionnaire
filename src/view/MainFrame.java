package view;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import view.components.MenuBarView;

public class MainFrame extends JFrame {
    public MenuBarView menuBar;
    public MainFrame() {
        super("Concessionnaire SiNo");
        menuBar = new MenuBarView();
        setJMenuBar(menuBar);

        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(MainFrame.class.getResource("/img/logo.png"))
        );

        this.setIconImage(icon.getImage());
        this.setSize(1080, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void showHome(){
        getContentPane().removeAll();
    }
}