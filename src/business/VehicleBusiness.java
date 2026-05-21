package business;

import dataAccess.VehicleDBAccess;
import model.Vehicle;
import java.util.List;

public class VehicleBusiness {
    private VehicleDBAccess dao;

    public VehicleBusiness() {
        try {
            dao = new VehicleDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicle() throws Exception {
        return dao.getAllVehicles();
    }

    public void addVehicle(Vehicle vehicle) throws Exception {
        if(vehicle == null) {
            throw new Exception(
                    "Vehicle null"
            );
        }
        if(vehicle.getVIN().length() != 17) {
            throw new Exception(
                    "VIN invalide"
            );
        }
        dao.insertVehicle(vehicle);
    }

    public void deleteVehicle(String vin) throws Exception {
        if(vin == null || vin.trim().isEmpty()) {
            throw new Exception("VIN obligatoire");
        }
        dao.deleteVehicleVin(vin);
    }

    public boolean vehicleExists(String vin) throws Exception {
        if(vin == null || vin.trim().isEmpty()) {
            throw new Exception(
                    "VIN obligatoire"
            );
        }
        return dao.vehicleExists(vin);
    }
}