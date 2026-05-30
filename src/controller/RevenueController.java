package controller;

import business.RevenueBusiness;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.RevenueResult;

import java.time.LocalDate;

public class RevenueController {
    private RevenueBusiness business;

    public RevenueController() {
        business = new RevenueBusiness();
    }

    public RevenueResult calculateRevenue(LocalDate dateStart, LocalDate dateEnd)
            throws InvalidInputException, DataAccessException {
        return business.calculateRevenue(dateStart, dateEnd);
    }

}