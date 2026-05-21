package controller;

import business.BrandBusiness;

import exception.DataAccessException;
import exception.InvalidInputException;

import model.Brand;
import java.util.List;

public class BrandController {
    private BrandBusiness brandBusiness;

    public BrandController() throws DataAccessException, InvalidInputException {
        brandBusiness = new BrandBusiness();
    }

    public List<Brand> getAllBrand() throws DataAccessException, InvalidInputException {
        return brandBusiness.getAllBrand();
    }
}