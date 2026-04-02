import javax.swing.*;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Concessionnaire SiNo");
        ImageIcon icon = new ImageIcon(
            Main.class.getResource("/img/logo.png")
        );
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setSize(1080, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(new MainFrame());
        mainFrame.setVisible(true);
    }
}
