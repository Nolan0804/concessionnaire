package view;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import view.components.MenuBarView;

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

        container = new JPanel(new GridBagLayout()); // centre automatiquement

        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(2,2,10,10)); // 3 boutons verticaux

        homePanel.add(new JButton("Meilleure vente du jour"));
        homePanel.add(new JButton("Listing Client"));
        homePanel.add(new JButton("Listing Voiture"));
        homePanel.add(new JButton("Eteindre l'application"));

        homePanel.setPreferredSize(new Dimension(600, 300));

        container.add(homePanel); // centré

        add(container, BorderLayout.CENTER);

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