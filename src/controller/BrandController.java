package controller;

import dataAccess.BrandDBAccess;
import model.Brand;
import java.util.List;

public class BrandController {
    private BrandDBAccess dao;
    public BrandController() {
        try {
            dao = new BrandDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Brand> getAllBrand() {
        try {
            return dao.getAllBrand();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}