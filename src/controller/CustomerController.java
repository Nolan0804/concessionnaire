package controller;

import dataAccess.CustomerDBAccess;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.Customer;
import java.util.List;

public class CustomerController {
    private CustomerDBAccess dao;

    public CustomerController() throws DataAccessException, InvalidInputException{
        try {
            dao = new CustomerDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomer() throws DataAccessException, InvalidInputException {
        try {
            return dao.getAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}