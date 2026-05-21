package controller;

import dataAccess.GarantyDBAccess;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.Garanty;
import java.util.List;

public class GarantyController {
    private GarantyDBAccess dao;

    public GarantyController() throws DataAccessException, InvalidInputException{
        try {
            dao = new GarantyDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Garanty> getAllGaranty() throws DataAccessException, InvalidInputException {
        try {
            return dao.getAllGaranty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}