package controller;

import business.EnergyBusiness;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Energy;
import java.util.List;

public class EnergyController {
    private EnergyBusiness energyBusiness;

    public EnergyController() throws DataAccessException, InvalidInputException {
        energyBusiness = new EnergyBusiness();
    }

    public List<Energy> getAllEnergy() throws DataAccessException, InvalidInputException {
        return energyBusiness.getAllEnergy();
    }
}