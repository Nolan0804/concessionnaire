package controller;

import dataAccess.BrandDBAccess;
import dataAccess.EnergyDAO;
import dataAccess.EnergyDBAccess;
import model.Energy;

import java.util.List;

public class BrandController {
    private EnergyController dao;

    public BrandController() {
        try {
            dao = new BrandDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Energy> getAllBrand() {
        try {
            return dao.getAllBrand();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
