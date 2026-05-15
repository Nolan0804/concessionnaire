package dataAccess;

import model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {
    void insertVehicle(Vehicle vehicle) throws SQLException;

    // List<Vehicle> getAllVehicles() throws SQLException;

    //Vehicle getVehicleVin(String vinNumber) throws SQLException;

    // void deleteVehicleVin(String vinNumber) throws SQLException;

    // void updateVehicle(Vehicle vehicle) throws SQLException;
}
