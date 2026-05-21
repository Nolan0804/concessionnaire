package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Brand;

import java.sql.SQLException;
import java.util.List;

public interface BrandDAO {
    List<Brand> getAllBrand() throws DataAccessException, InvalidInputException;
}
