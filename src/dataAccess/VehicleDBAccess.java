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
    public void insert(Vehicle vehicle) throws SQLException {
        String sql = """
            INSERT INTO vehicle(vin, kilometer, arrival_date, sale_price, purchase_price, registration, power, gear_box_type, door_number, seat_number, information, euro_standard,
            is_vat_deductible, year, guaranty_type, flex_color, type_color, energy, brand_name, state, saler)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, vehicle.getVIN());

        if(vehicle.getKilometer() != null)
            statement.setDouble(2, vehicle.getKilometer());
        else
            statement.setNull(2, Types.DOUBLE);

        if(vehicle.getArrivalDate() != null)
            statement.setDate(
                    3,
                    Date.valueOf(vehicle.getArrivalDate())
            );
        else
            statement.setNull(3, Types.DATE);

        if(vehicle.getSalePrice() != null)
            statement.setDouble(4, vehicle.getSalePrice());
        else
            statement.setNull(4, Types.DOUBLE);

        if(vehicle.getPurchasePrice() != null)
            statement.setDouble(5, vehicle.getPurchasePrice());
        else
            statement.setNull(5, Types.DOUBLE);

        if(vehicle.getRegistrationNumber() != null)
            statement.setString(6, vehicle.getRegistrationNumber());
        else
            statement.setNull(6, Types.VARCHAR);

        if(vehicle.getPower() != null)
            statement.setInt(7, vehicle.getPower());
        else
            statement.setNull(7, Types.INTEGER);

        if(vehicle.getGearBox() != null)
            statement.setString(8, vehicle.getGearBox());
        else
            statement.setNull(8, Types.VARCHAR);

        if(vehicle.getDoorNumber() != null)
            statement.setInt(9, vehicle.getDoorNumber());
        else
            statement.setNull(9, Types.INTEGER);

        if(vehicle.getSeatNumber() != null)
            statement.setInt(10, vehicle.getSeatNumber());
        else
            statement.setNull(10, Types.INTEGER);

        if(vehicle.getInformation() != null)
            statement.setString(11, vehicle.getInformation());
        else
            statement.setNull(11, Types.VARCHAR);

        if(vehicle.getEuroStandard() != null)
            statement.setInt(12, vehicle.getEuroStandard());
        else
            statement.setNull(12, Types.INTEGER);

        if(vehicle.getIsVatDeductible() != null)
            statement.setBoolean(13, vehicle.getIsVatDeductible());
        else
            statement.setBoolean(13, Types.INTEGER);

        if(vehicle.getYear() != null)
            statement.setInt(14, vehicle.getYear());
        else
            statement.setNull(14, Types.INTEGER);

        if(vehicle.getGuarantyType() != null)
            statement.setString(15, vehicle.getGuarantyType());
        else
            statement.setNull(15, Types.VARCHAR);

        if(vehicle.getFlexColor() != null)
            statement.setString(16, vehicle.getFlexColor());
        else
            statement.setNull(16, Types.VARCHAR);

        if(vehicle.getTypeColor() != null)
            statement.setString(17, vehicle.getTypeColor());
        else
            statement.setNull(17, Types.VARCHAR);

        if(vehicle.getEnergy() != null)
            statement.setString(18, vehicle.getEnergy());
        else
            statement.setNull(18, Types.VARCHAR);

        if(vehicle.getBrandName() != null)
            statement.setString(19, vehicle.getBrandName());
        else
            statement.setNull(19, Types.VARCHAR);

        if(vehicle.getState() != null)
            statement.setString(20, vehicle.getState());
        else
            statement.setNull(20, Types.VARCHAR);

        if(vehicle.getSaler() != null)
            statement.setInt(21, vehicle.getSaler());
        else
            statement.setNull(21, Types.INTEGER);

        statement.executeUpdate();
    }

    List<Vehicle> getAllVehicles() throws SQLException{
        return new ArrayList<>();
    };

    Vehicle getVehicleVin(String vinNumber) throws SQLException{
        return null;
    };

    void deleteVehicleVin(String vinNumber) throws SQLException{

    };

    void updateVehicle(Vehicle vehicle) throws SQLException{

    };

}
