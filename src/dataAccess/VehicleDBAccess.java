package dataAccess;
import exception.InvalidInputException;
import model.Vehicle;
import model.Garanty;
import model.Color;
import model.Energy;
import model.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDBAccess implements VehicleDAO {

    private Connection connection;

    public VehicleDBAccess() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    @Override
    public void insertVehicle(Vehicle vehicle) throws SQLException {
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
        statement.setString(17, vehicle.getColor().getHexColor());
        statement.setString(18, vehicle.getColor().getType());
        statement.setString(19, vehicle.getEnergy().getName());
        statement.setString(20, vehicle.getBrand().getName());
        statement.setString(21, vehicle.getState());
        statement.setInt(22, vehicle.getSaler().getCustomerNumber());

        statement.executeUpdate();
    }

    @Override
    public List<Vehicle> getAllVehicles() throws SQLException, InvalidInputException {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicle";
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
                            0
                    ),

                    new Color(
                            rs.getString("hex_color"),
                            rs.getString("type_color")
                    ),

                    new Energy(
                            rs.getString("energy"),
                            false
                    ),

                    new Brand(
                            rs.getString("brand_name"),
                            1890,
                            null
                    ),
                    rs.getString("state"),
                    null
            );

            vehicles.add(vehicle);
        }

        return vehicles;
    }
}
