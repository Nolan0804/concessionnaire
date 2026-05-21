package view.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LimitDocumentFilter extends DocumentFilter {
    private final int limit;

    public LimitDocumentFilter(int limit) {
        this.limit = limit;
    }

    @Override
    public void replace(
            FilterBypass fb,
            int offset,
            int length,
            String text,
            AttributeSet attrs
    ) throws BadLocationException {
        int currentLength = fb.getDocument().getLength();
        int newLength = currentLength - length + text.length();

        if (newLength <= limit) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}