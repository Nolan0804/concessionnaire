import exception.InvalidInputException;
import view.MainFrame;
import controller.MainController;
import business.VehicleBusiness;
import java.util.List;

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

