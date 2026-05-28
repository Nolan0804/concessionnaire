package dataAccess;

import exception.*;
import model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface VehicleDAO {
    void insertVehicle(Vehicle vehicle) throws DataAccessException, PrimaryKeyDuplicateException;
    List<Vehicle> getAllVehicles() throws DataAccessException, InvalidInputException;
    List<Object[]> searchVehicles(String brand, String energy, double kilometerMax) throws DataAccessException;
    void deleteVehicleByVin(String vinNumber) throws DataAccessException, VehicleNotFoundException;
    void updateVehicle(Vehicle vehicle) throws DataAccessException;
    Vehicle getVehicleByVIN(String vin) throws DataAccessException, InvalidInputException;
    List<Object[]> searchTrials(String energy, double maxKilometer, boolean isPotentialBuyer) throws DataAccessException;
    List<Object[]> searchSales(LocalDate dateStart, LocalDate dateEnd, double maxPrice, String paymentMethod) throws DataAccessException;
}
