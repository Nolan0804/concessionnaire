package view.components;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class HomeButton extends JButton {
    public HomeButton(String textButton, String imgName) {
        super(textButton);
        if (imgName != null){
            ImageIcon icon = new ImageIcon(
                    Objects.requireNonNull(HomeButton.class.getResource("/img/" + imgName))
            );
            this.setIcon(icon);
        }
        setOpaque(true);
        setContentAreaFilled(true);
        setFocusPainted(false);
        setBorderPainted(true);
    }
}
