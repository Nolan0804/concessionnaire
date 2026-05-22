package config;

public class AppConfig {
    public static final int GEARBOX_LOWEST = 5;
    public static final int GEARBOX_HIGHEST = 8;

    public static final int DOOR_LOWEST = 3;
    public static final int DOOR_HIGHEST = 5;

    public static final int SEAT_LOWEST = 1;
    public static final int SEAT_HIGHEST = 9;

    public static final int EURO_STANDARD_LOWEST = 1;
    public static final int EURO_STANDARD_HIGHEST = 7;

    public static final int YEAR_PRODUCTION_LOWEST = 1886;

    public static final String[] COLOR_TYPES = {
            "Glossy",
            "Matte",
            "Satin",
            "Metallic",
            "Pearlescent"
    };

    public static final String[] GEARBOX_TYPES = {
            "Automatic",
            "Manual"
    };

    public static final String[] VEHICLE_STATES = {
            "New",
            "Excellent",
            "Good",
            "Average",
            "Damaged",
    };
}