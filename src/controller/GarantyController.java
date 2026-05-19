package controller;

import dataAccess.GarantyDBAccess;
import model.Garanty;

import java.util.List;

public class GarantyController {
    private GarantyDBAccess dao;

    public GarantyController() {
        try {
            dao = new GarantyDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Garanty> getAllGaranty() {
        try {
            return dao.getAllGaranty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}