package view.components;

import javax.swing.*;
import java.awt.*;

public class DialogMessage {
    public static void errorMessage(Component parent, String title, String message) {
        JOptionPane.showMessageDialog(
                parent,
                message,
                title,
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void successMessage(Component parent, String title, String message) {
        JOptionPane.showMessageDialog(
                parent,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static int confirmMessage(Component parent, String message) {

        return JOptionPane.showConfirmDialog(
                parent,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );
    }
}