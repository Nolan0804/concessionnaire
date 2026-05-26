package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import exception.PrimaryKeyDuplicateException;
import model.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {
    void insertVehicle(Vehicle vehicle) throws DataAccessException, PrimaryKeyDuplicateException;
    List<Vehicle> getAllVehicles() throws DataAccessException, InvalidInputException;
    List<Object[]> searchVehicles(String brand, String energy, double kilometerMax) throws DataAccessException;
    void deleteVehicleVin(String vinNumber) throws DataAccessException;
    void updateVehicle(Vehicle vehicle) throws DataAccessException;
    Vehicle getVehicleByVIN(String vin) throws DataAccessException, InvalidInputException;
}
