package controller;

import java.awt.event.*;

public class ExitListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}