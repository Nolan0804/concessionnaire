package business;

import dataAccess.EnergyDAO;
import dataAccess.EnergyDBAccess;

import exception.DataAccessException;
import exception.InvalidInputException;

import model.Energy;
import java.util.List;

public class EnergyBusiness {
    private EnergyDAO dao;

    public EnergyBusiness() throws DataAccessException {
        dao = new EnergyDBAccess();
    }

    public List<Energy> getAllEnergy() throws DataAccessException, InvalidInputException {
        return dao.getAllEnergy();
    }
}