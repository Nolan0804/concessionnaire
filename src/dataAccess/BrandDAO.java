package dataAccess;

import exception.InvalidInputException;
import model.Brand;

import java.sql.SQLException;
import java.util.List;

public interface BrandDAO {
    List<Brand> getAllBrand() throws SQLException, InvalidInputException;
}
