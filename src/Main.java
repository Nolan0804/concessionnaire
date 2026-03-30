import javax.swing.*;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Concessionnaire SiNo");

        frame.setSize(1080, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new MainFrame()); // 👈 ta page ici

        frame.setVisible(true);
    }
}