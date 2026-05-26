package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Vehicle;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface VehicleDAO {
    void insertVehicle(Vehicle vehicle) throws DataAccessException;
    List<Vehicle> getAllVehicles() throws DataAccessException, InvalidInputException;
    Boolean vehicleExists(String vinNumber) throws DataAccessException;
    List<Object[]> searchVehicles(String brand, String energy, double kilometerMax) throws DataAccessException;
    void deleteVehicleVin(String vinNumber) throws DataAccessException;
    void updateVehicle(Vehicle vehicle) throws DataAccessException;
    Vehicle getVehicleByVIN(String vin) throws DataAccessException, InvalidInputException;
    List<Object[]> searchTrials(String energy, double maxKilometer, boolean isPotentialBuyer) throws DataAccessException;
    List<Object[]> searchSales(LocalDate dateStart, LocalDate dateEnd, double maxPrice, String paymentMethod) throws DataAccessException;
}
