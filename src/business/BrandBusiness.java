package business;

import dataAccess.BrandDBAccess;

import exception.DataAccessException;
import exception.InvalidInputException;

import model.Brand;
import java.util.List;

public class BrandBusiness {
    private BrandDBAccess dao;

    public BrandBusiness() throws DataAccessException {
        dao = new BrandDBAccess();
    }

    public List<Brand> getAllBrand() throws DataAccessException, InvalidInputException {
        return dao.getAllBrand();
    }
}