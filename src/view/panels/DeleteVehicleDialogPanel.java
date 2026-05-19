package view.panels;

import utils.LimitDocumentFilter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class DeleteVehicleDialogPanel extends JDialog {
    private JTextField txtVin;
    private JButton btnDelete;
    private JButton btnCancel;

    public DeleteVehicleDialogPanel(JFrame parent) {
        super(parent, "Supprimer un véhicule", true);

        setSize(450, 220);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblVin = new JLabel("VIN du véhicule à supprimer :");
        lblVin.setFont(new Font("Arial", Font.BOLD, 14));
        contentPanel.add(lblVin, gbc);

        gbc.gridy = 1;

        txtVin = new JTextField();

        ((AbstractDocument) txtVin.getDocument()).setDocumentFilter(new LimitDocumentFilter(17));

        contentPanel.add(txtVin, gbc);

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                20,
                                10
                        )
                );

        btnDelete = new JButton("Supprimer");
        btnCancel = new JButton("Annuler");

        buttonPanel.add(btnDelete);
        buttonPanel.add(btnCancel);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTextField getTxtVin() {
        return txtVin;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }
}