import exception.InvalidInputException;
import model.*;
import view.MainFrame;
import controller.MainController;
import dataAccess.VehicleDBAccess;
import java.util.List;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) throws InvalidInputException {
        try {

            VehicleDBAccess dao = new VehicleDBAccess();

            List<Vehicle> vehicles = dao.getAllVehicles();

            for (Vehicle vehicle : vehicles) {

                System.out.println("----------------");

                System.out.println("VIN : " +
                        vehicle.getVIN());

                System.out.println("Kilometer : " +
                        vehicle.getKilometer());

                System.out.println("Arrival date : " +
                        vehicle.getArrivalDate());

                System.out.println("Sale price : " +
                        vehicle.getSalePrice());

                System.out.println("Purchase price : " +
                        vehicle.getPurchasePrice());

                System.out.println("Registration : " +
                        vehicle.getRegistrationNumber());

                System.out.println("Power : " +
                        vehicle.getPower());

                System.out.println("Gear box : " +
                        vehicle.getGearBox());

                System.out.println("Gear number : " +
                        vehicle.getGearNumber());

                System.out.println("Doors : " +
                        vehicle.getDoorNumber());

                System.out.println("Seats : " +
                        vehicle.getSeatNumber());

                System.out.println("Information : " +
                        vehicle.getInformation());

                System.out.println("Euro standard : " +
                        vehicle.getEuroStandard());

                System.out.println("Production year : " +
                        vehicle.getYearOfProduction());

                System.out.println("VAT deductible : " +
                        vehicle.getIsVatDeductible());

                System.out.println("Garanty : " +
                        vehicle.getGaranty().getType());

                System.out.println("Color : " +
                        vehicle.getColor().getHexColor());

                System.out.println("Energy : " +
                        vehicle.getEnergy().getName());

                System.out.println("Brand : " +
                        vehicle.getBrand().getName());

                System.out.println("State : " +
                        vehicle.getState());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
