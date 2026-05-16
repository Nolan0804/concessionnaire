package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberOnlyFilter extends DocumentFilter {
    @Override
    public void replace(
            FilterBypass fb,
            int offset,
            int length,
            String text,
            AttributeSet attrs
    ) throws BadLocationException {
        String currentText =
                fb.getDocument().getText(
                        0,
                        fb.getDocument().getLength()
                );
        String futureText =
                currentText.substring(0, offset)
                        + text
                        + currentText.substring(offset + length);

        if(futureText.matches("\\d*([,.]\\d*)?")) {
            super.replace(
                    fb,
                    offset,
                    length,
                    text,
                    attrs
            );
        }
    }
}