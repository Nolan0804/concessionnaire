package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomer() throws DataAccessException, InvalidInputException;
}
