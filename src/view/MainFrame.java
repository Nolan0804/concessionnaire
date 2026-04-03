package view;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import view.components.MenuBarView;

public class MainFrame extends JFrame {
    public MenuBarView menuBarView;

    public MainFrame() {
        super("Concessionnaire SiNo");
        menuBarView = new MenuBarView();
        setJMenuBar(menuBarView);

        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(MainFrame.class.getResource("/img/logo.png"))
        );
        this.setIconImage(icon.getImage());
        this.setSize(1080, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public MenuBarView getmenuBarView() {
        return menuBarView;
    }

    public void showHome(){
        getContentPane().removeAll();
        revalidate();
        repaint();
    }
}