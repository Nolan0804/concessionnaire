package controller;

import dataAccess.CustomerDBAccess;
import model.Customer;
import java.util.List;

public class CustomerController {
    private CustomerDBAccess dao;

    public CustomerController() {
        try {
            dao = new CustomerDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomer() {
        try {
            return dao.getAllCustomer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}