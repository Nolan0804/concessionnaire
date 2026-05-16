import exception.InvalidInputException;
import model.*;
import view.MainFrame;
import controller.MainController;
import dataAccess.VehicleDBAccess;
import java.util.List;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) throws InvalidInputException {
        try {
            MainFrame frame = new MainFrame();
            MainController controller = new MainController(frame);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
