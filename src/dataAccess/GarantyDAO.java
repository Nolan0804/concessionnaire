package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Garanty;

import java.util.List;

public interface GarantyDAO {
    List<Garanty> getAllGaranty() throws DataAccessException, InvalidInputException;
}
