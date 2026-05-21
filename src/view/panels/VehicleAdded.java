package view.panels;
import java.awt.Component;
import javax.swing.JOptionPane;

public class VehicleAdded extends JOptionPane {
    public VehicleAdded() {
        super();
        this.showMessageDialog(
                null,
                "Vehicle added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void errorMessage(
            Component parent,
            String message
    ) {

        JOptionPane.showMessageDialog(
                parent,
                message,
                "Erreur",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void successMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(
                parent,
                message,
                "Succès",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
