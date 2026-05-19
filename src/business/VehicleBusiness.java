package business;

import dataAccess.VehicleDBAccess;
import model.Vehicle;

public class VehicleBusiness {
    private VehicleDBAccess dao;

    public VehicleBusiness() {
        try {
            dao = new VehicleDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}