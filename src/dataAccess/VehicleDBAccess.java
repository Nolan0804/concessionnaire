package dataAccess;
import model.Vehicle;

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
            INSERT INTO vehicle(vin, kilometer, arrival_date, sale_price, purchase_price, registration, power, gear_box_type, door_number, seat_number, information, euro_standard,
            is_vat_deductible, production_year, garanty_type, hex_color, type_color, energy, brand_name, state, saler)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";

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
        statement.setInt(9, vehicle.getDoorNumber());
        statement.setInt(10, vehicle.getSeatNumber());

        if(vehicle.getInformation() != null){
            statement.setString(11, vehicle.getInformation());
        }else{
            statement.setNull(11, Types.VARCHAR);
        }

        statement.setInt(12, vehicle.getEuroStandard());
        statement.setBoolean(13, vehicle.getIsVatDeductible());
        statement.setInt(14, vehicle.getYearOfProduction());
        statement.setString(15, vehicle.getGaranty().getType());
        statement.setString(16, vehicle.getColor().getHexColor());
        statement.setString(17, vehicle.getColor().getType());
        statement.setString(18, vehicle.getEnergy().getName());
        statement.setString(19, vehicle.getBrand().getName());
        statement.setString(20, vehicle.getState());
        statement.setInt(21, vehicle.getSaler().getCustomerNumber());

        statement.executeUpdate();
    }

}
