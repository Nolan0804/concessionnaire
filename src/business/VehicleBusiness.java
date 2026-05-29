package business;

import dataAccess.VehicleDAO;
import dataAccess.VehicleDBAccess;
import exception.*;
import model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public class VehicleBusiness {
    private VehicleDAO dao;

    public VehicleBusiness() {
        try {
            dao = new VehicleDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicle() throws DataAccessException, InvalidInputException {
        return dao.getAllVehicles();
    }

    public void updateVehicle(Vehicle vehicle) throws DataAccessException, InvalidInputException {
        if(vehicle == null) {
            throw new DataAccessException("Vehicle null");
        }
        if(vehicle.getVIN().length() != 17) {
            throw new InvalidInputException("VIN invalide");
        }
        dao.updateVehicle(vehicle);
    }

    public void addVehicle(Vehicle vehicle) throws VehicleNull, InvalidInputException, DataAccessException, PrimaryKeyDuplicateException {
        if(vehicle == null) {
            throw new VehicleNull("Vehicle null");
        }
        if(vehicle.getVIN().length() != 17) {
            throw new InvalidInputException("VIN invalide");
        }
        dao.insertVehicle(vehicle);
    }

    public Vehicle getVehicleByVIN(String vin) throws DataAccessException, InvalidInputException {
        if(vin == null || vin.trim().isEmpty()) {
            throw new InvalidInputException("VIN obligatoire");
        }
        return dao.getVehicleByVIN(vin);
    }

    public void deleteVehicle(String vin) throws InvalidInputException, VehicleNotFoundException {
        try {
            if(vin == null || vin.trim().isEmpty()) {
                throw new InvalidInputException("VIN obligatoire");
            }
            dao.deleteVehicleByVin(vin);
        } catch (DataAccessException e) {
            throw new VehicleNotFoundException("Vehicle not found with VIN: " + vin);
        }
    }

    public List<Object[]> searchVehicles(String brand, String energy, double maxKilometer) throws DataAccessException {
        return dao.searchVehicles(brand, energy, maxKilometer);
    }

    public List<Object[]> searchTrials(String energy, double maxKilometer, boolean isPotentialBuyer) throws DataAccessException {
        return dao.searchTrials(energy, maxKilometer, isPotentialBuyer);
    }

    public List<Object[]> searchSales(LocalDate dateStart, LocalDate dateEnd, double maxPrice, String paymentMethod) throws DataAccessException {
        return dao.searchSales(dateStart, dateEnd, maxPrice, paymentMethod);
    }

}