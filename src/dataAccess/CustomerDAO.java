package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomer() throws DataAccessException, InvalidInputException;
}
