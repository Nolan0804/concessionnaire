package view.utils;

public class ValidForms {

    public static boolean isEmpty(String text) {
        return text == null
                || text.trim().isEmpty();
    }

    public static boolean isValidVIN(String vin) {
        return vin != null && vin.length() == 17;
    }

    public static boolean isPositiveDouble(String value) {
        try {
            return Double.parseDouble(
                    value.replace(",", ".")
            ) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isPositiveInteger(String value) {
        try {
            return Integer.parseInt(value) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}