package view;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import view.components.*;

public class MainFrame extends JFrame {
    public MenuBarView menuBarView;
    private JPanel container;
    public MainFrame() {
        super("Concessionnaire SiNo");
        ImageIcon icon = new ImageIcon(
                Objects.requireNonNull(MainFrame.class.getResource("/img/logo.png"))
        );
        this.setIconImage(icon.getImage());
        this.setSize(1080, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        menuBarView = new MenuBarView();
        setJMenuBar(menuBarView);

        container = new JPanel(new GridBagLayout());
        container.setBackground(new Color(212, 212, 212));

        container.add(new HomePanel()); // centré

        add(container, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public MenuBarView getmenuBarView() {
        return menuBarView;
    }

    public void showHome(){
        getContentPane().removeAll();
        getContentPane().add(container, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}