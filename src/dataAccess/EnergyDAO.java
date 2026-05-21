package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Energy;

import java.sql.SQLException;
import java.util.List;

public interface EnergyDAO {

    List<Energy> getAllEnergy() throws DataAccessException, InvalidInputException;
}