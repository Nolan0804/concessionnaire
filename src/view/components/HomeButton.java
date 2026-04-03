package view.components;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HomeButton extends JButton {

    private Image image;
    private boolean hover = false;
    private boolean pressed = false;

    public HomeButton(String textButton, String imgName) {

        super(textButton);

        // 🔥 IMAGE
        if (imgName != null) {
            image = new ImageIcon(
                    Objects.requireNonNull(
                            HomeButton.class.getResource("/img/" + imgName)
                    )
            ).getImage();
        }

        // 🎨 STYLE TEXTE
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 16));

        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);

        // 🔥 IMPORTANT (sinon fond par défaut)
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        // 🎯 CURSEUR
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 🔥 EVENTS (hover + click)
        addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent e) {
                hover = true;
                repaint();
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                hover = false;
                pressed = false;
                repaint();
            }

            public void mousePressed(java.awt.event.MouseEvent e) {
                pressed = true;
                repaint();
            }

            public void mouseReleased(java.awt.event.MouseEvent e) {
                pressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // 🔥 IMAGE FOND (plein bouton)
        if (image != null) {
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }

        // 🔥 OVERLAY (lisibilité texte)
        if (pressed) {
            g2.setColor(new Color(0, 0, 0, 180)); // plus sombre
        } else if (hover) {
            g2.setColor(new Color(0, 0, 0, 120)); // hover
        } else {
            g2.setColor(new Color(0, 0, 0, 80));  // normal
        }

        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
        super.paintComponent(g);
    }
}
