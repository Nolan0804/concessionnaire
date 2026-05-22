package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Locality;


public interface LocalityDAO {

    Locality getLocalityByCodeLocality(int postalCode, String locality_name) throws DataAccessException, InvalidInputException;
}
