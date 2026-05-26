package dataAccess;
import exception.DataAccessException;
import exception.InvalidInputException;
import exception.PrimaryKeyDuplicateException;
import model.*;

import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDBAccess implements VehicleDAO {
    private Connection connection;

    public VehicleDBAccess() throws DataAccessException {
        try {
            connection = SingletonConnection.getInstance();
        } catch (SQLException e) {
            throw new DataAccessException("Error connecting to the database.");
        }
    }

    @Override
    public void insertVehicle(Vehicle vehicle) throws DataAccessException, PrimaryKeyDuplicateException {
        try {
            String sql = """
            INSERT INTO vehicle(vin, kilometer, arrival_date, sale_price, purchase_price, registration, power, gear_box_type, gear_number, door_number, seat_number, information, euro_standard,
            is_vat_deductible, production_year, garanty_type, hex_color, type_color, energy, brand_name, state, saler)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vehicle.getVIN());
            statement.setDouble(2, vehicle.getKilometer());
            statement.setDate(3, Date.valueOf(vehicle.getArrivalDate()));
            statement.setDouble(4, vehicle.getSalePrice());
            statement.setDouble(5, vehicle.getPurchasePrice());

            if(vehicle.getRegistrationNumber() != null){
                statement.setString(6, vehicle.getRegistrationNumber());
            }else{
                statement.setNull(6, Types.VARCHAR);
            }

            statement.setInt(7, vehicle.getPower());
            statement.setString(8, vehicle.getGearBox());
            statement.setInt(9, vehicle.getGearNumber());
            statement.setInt(10, vehicle.getDoorNumber());
            statement.setInt(11, vehicle.getSeatNumber());

            if(vehicle.getInformation() != null){
                statement.setString(12, vehicle.getInformation());
            }else{
                statement.setNull(12, Types.VARCHAR);
            }
            statement.setInt(13, vehicle.getEuroStandard());
            statement.setBoolean(14, vehicle.getIsVatDeductible());
            statement.setInt(15, vehicle.getYearOfProduction());
            statement.setString(16, vehicle.getGaranty().getType());
            statement.setString(17, vehicle.getHexColor());
            statement.setString(18, vehicle.getTypeColor());
            statement.setString(19, vehicle.getEnergy().getName());
            statement.setString(20, vehicle.getBrand().getName());
            statement.setString(21, vehicle.getState());
            statement.setInt(22, vehicle.getSaler().getCustomerNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            if(e.getMessage().contains("duplicate")) {
                throw new PrimaryKeyDuplicateException("A vehicle with VIN " + vehicle.getVIN() + " already exists.");
            }

            throw new DataAccessException("DATA VEHICLE : Insert impossible");
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() throws DataAccessException, InvalidInputException {
        try {
            List<Vehicle> vehicles = new ArrayList<>();

            String sql = """
                SELECT *
                FROM vehicle_complete_view
            """;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                        rs.getString("vin"),
                        rs.getDouble("kilometer"),
                        rs.getDate("arrival_date").toLocalDate(),
                        rs.getDouble("sale_price"),
                        rs.getDouble("purchase_price"),
                        rs.getString("registration"),
                        rs.getInt("power"),
                        rs.getString("gear_box_type"),
                        rs.getInt("gear_number"),
                        rs.getInt("door_number"),
                        rs.getInt("seat_number"),
                        rs.getString("information"),
                        rs.getInt("euro_standard"),
                        rs.getInt("production_year"),
                        rs.getBoolean("is_vat_deductible"),

                        new Garanty(
                                rs.getString("garanty_type"),
                                rs.getInt("garanty_duration")
                        ),

                        rs.getString("hex_color"),
                        rs.getString("type_color"),

                        new Energy(
                                rs.getString("energy_type"),
                                rs.getBoolean("is_eco_friendly")
                        ),

                        new Brand(
                                rs.getString("brand_name"),
                                rs.getInt("year_created"),

                                new Country(
                                        rs.getString("origin_country")
                                )
                        ),

                        rs.getString("state"),

                        new Customer(
                                rs.getInt("customer_number"),
                                rs.getString("customer_name"),
                                rs.getString("firstname"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                rs.getString("address"),
                                rs.getDate("birthday_date").toLocalDate(),

                                new Locality(
                                        rs.getString("locality_name"),
                                        rs.getInt("postal_code"),

                                        new Country(
                                                rs.getString("country_name")
                                        )
                                )
                        )
                );
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException e) {
            throw new DataAccessException("DATA VEHICLE : List impossible");
        }
    }

    @Override
    public void deleteVehicleVin(String vin) throws DataAccessException {
        try {
            String sql = """ 
                DELETE FROM Vehicle
                WHERE VIN = ?
                """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("DATA VEHICLE : Delete impossible");
        }
    }

    @Override
    public Vehicle getVehicleByVIN(String vin) throws DataAccessException, InvalidInputException{
        try {
            String sql = """
                SELECT *
                FROM vehicle_complete_view
                WHERE vin = ?
            """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vin);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Vehicle(
                        rs.getString("vin"),
                        rs.getDouble("kilometer"),
                        rs.getDate("arrival_date").toLocalDate(),
                        rs.getDouble("sale_price"),
                        rs.getDouble("purchase_price"),
                        rs.getString("registration"),
                        rs.getInt("power"),
                        rs.getString("gear_box_type"),
                        rs.getInt("gear_number"),
                        rs.getInt("door_number"),
                        rs.getInt("seat_number"),
                        rs.getString("information"),
                        rs.getInt("euro_standard"),
                        rs.getInt("production_year"),
                        rs.getBoolean("is_vat_deductible"),

                        new Garanty(
                                rs.getString("garanty_type"),
                                rs.getInt("garanty_duration")
                        ),

                        rs.getString("hex_color"),
                        rs.getString("type_color"),

                        new Energy(
                                rs.getString("energy_type"),
                                rs.getBoolean("is_eco_friendly")
                        ),

                        new Brand(
                                rs.getString("brand_name"),
                                rs.getInt("year_created"),

                                new Country(
                                        rs.getString("origin_country")
                                )
                        ),

                        rs.getString("state"),

                        new Customer(
                                rs.getInt("customer_number"),
                                rs.getString("customer_name"),
                                rs.getString("firstname"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                rs.getString("address"),
                                rs.getDate("birthday_date").toLocalDate(),

                                new Locality(
                                        rs.getString("locality_name"),
                                        rs.getInt("postal_code"),

                                        new Country(
                                                rs.getString("country_name")
                                        )
                                )
                        )
                );
            } else {
                throw new InvalidInputException("Vehicle with VIN " + vin + " not found.");
            }
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    };


    @Override
    public void updateVehicle(Vehicle vehicle) throws DataAccessException {
        try {
            String sql =
                    """
                    UPDATE Vehicle
                    SET
                        kilometer = ?,
                        arrival_date = ?,
                        sale_price = ?,
                        purchase_price = ?,
                        registration = ?,
                        power = ?,
                        gear_box_type = ?,
                        gear_number = ?,
                        door_number = ?,
                        seat_number = ?,
                        information = ?,
                        euro_standard = ?,
                        production_year = ?,
                        is_VAT_Deductible = ?,
                        garanty_type = ?,
                        hex_color = ?,
                        type_color = ?,
                        energy = ?,
                        brand_name = ?,
                        state = ?,
                        saler = ?
                    WHERE VIN = ?
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, vehicle.getKilometer());
            statement.setDate(2, java.sql.Date.valueOf(vehicle.getArrivalDate()));
            statement.setDouble(3, vehicle.getSalePrice());
            statement.setDouble(4, vehicle.getPurchasePrice());
            statement.setString(5, vehicle.getRegistrationNumber());
            statement.setInt(6, vehicle.getPower());
            statement.setString(7, vehicle.getGearBox());
            statement.setInt(8, vehicle.getGearNumber());
            statement.setInt(9, vehicle.getDoorNumber());
            statement.setInt(10, vehicle.getSeatNumber());
            statement.setString(11, vehicle.getInformation());
            statement.setInt(12, vehicle.getEuroStandard());
            statement.setInt(13, vehicle.getYearOfProduction());
            statement.setBoolean(14, vehicle.getIsVatDeductible());
            statement.setString(15, vehicle.getGaranty().getType());
            statement.setString(16,vehicle.getHexColor());
            statement.setString(17,vehicle.getTypeColor());
            statement.setString(18, vehicle.getEnergy().getName());
            statement.setString(19, vehicle.getBrand().getName());
            statement.setString(20, vehicle.getState());
            statement.setInt(21, vehicle.getSaler().getCustomerNumber());
            statement.setString(22, vehicle.getVIN());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("DATA VEHICLE : Update impossible");
        }
    }

    @Override
    public List<Object[]> searchVehicles(String brandName, String energyType, double maxKilometer) throws DataAccessException {
        List<Object[]> vehicles = new ArrayList<>();

        try {
            String sql = """
            SELECT
                v.vin,
                v.door_number,
                v.sale_price,
                v.kilometer,
                b.name AS brand_name,
                e.type AS energy,
                v.production_year AS year_created,
                e.is_eco_friendly
            FROM Vehicle v
            JOIN Brand b ON v.brand_name = b.name
            JOIN Energy e ON v.energy = e.type
            WHERE brand_name = ? AND energy = ? AND kilometer <= ?
            """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brandName);
            statement.setString(2, energyType);
            statement.setDouble(3, maxKilometer);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getString("vin"),
                        rs.getInt("door_number"),
                        rs.getDouble("sale_price"),
                        rs.getInt("year_created"),
                        rs.getBoolean("is_eco_friendly")
                };
                vehicles.add(row);
            }

            return vehicles;
        } catch (SQLException e) {
            throw new DataAccessException("DATA VEHICLE : Search impossible");
        }
    }

    public List<Object[]> searchTrials(String energyType, double maxKilometer, boolean isPotentialBuyer) throws DataAccessException {
        try {
            List<Object[]> results = new ArrayList<>();

            String sql = """
            SELECT
                c.name, c.firstname, c.email,
                t.date, t.duration, t.comment,
                v.vin, v.power, v.purchase_price,
                b.name AS brand_name, b.year_created
            FROM trial t
            JOIN customer c ON t.customer_number = c.customer_number
            JOIN vehicle v ON t.vin_number = v.vin
            JOIN brand b ON v.brand_name = b.name
            JOIN energy e ON v.energy = e.type
            WHERE e.type = ?
              AND v.kilometer <= ?
              AND t.is_potential_sale = ?
        """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, energyType);
            statement.setDouble(2, maxKilometer);
            statement.setBoolean(3, isPotentialBuyer);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getString("name"),
                        rs.getString("firstname"),
                        rs.getString("email"),
                        rs.getDate("date"),
                        rs.getInt("duration"),
                        rs.getString("comment"),
                        rs.getString("vin"),
                        rs.getInt("power"),
                        rs.getDouble("purchase_price"),
                        rs.getString("brand_name"),
                        rs.getInt("year_created")
                };
                results.add(row);
            }

            return results;
        } catch (SQLException e) {
            throw new DataAccessException("DATA TRIAL : Search impossible");
        }
    }

    public List<Object[]> searchSales(LocalDate dateStart, LocalDate dateEnd, double maxPrice, String paymentMethod) throws DataAccessException {
        try {
            List<Object[]> results = new ArrayList<>();

            String sql = """
            SELECT
                c.name, c.firstname, c.email,
                s.date, v.sale_price,
                v.vin, v.kilometer, v.power
            FROM sale s
            JOIN customer c ON s.customer_number = c.customer_number
            JOIN vehicle v ON s.vin_vehicle = v.vin
            WHERE s.date BETWEEN ? AND ?
              AND v.sale_price <= ?
              AND s.payment_method = ?
        """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(dateStart));
            statement.setDate(2, Date.valueOf(dateEnd));
            statement.setDouble(3, maxPrice);
            statement.setString(4, paymentMethod);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getString("name"),
                        rs.getString("firstname"),
                        rs.getString("email"),
                        rs.getDate("date"),
                        rs.getDouble("sale_price"),
                        rs.getString("vin"),
                        rs.getDouble("kilometer"),
                        rs.getInt("power")
                };
                results.add(row);
            }

            return results;
        } catch (SQLException e) {
            throw new DataAccessException("DATA SALE : Search impossible");
        }
    }

}
