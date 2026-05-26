package view.utils;

import javax.swing.*;
import java.util.List;

public class ComboBoxUtils {
    public static <T> void loadComboBox(JComboBox<T> comboBox, List<T> items) {
        for (T item : items) {
            comboBox.addItem(item);
        }
    }
}