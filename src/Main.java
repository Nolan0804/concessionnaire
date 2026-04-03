import javax.swing.*;
import view.MainFrame;
import controller.MainController;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        new MainController(frame);
    }
}
