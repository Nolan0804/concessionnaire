package controller;

import dataAccess.EnergyDBAccess;
import model.Energy;

import java.util.List;

public class EnergyController {
    private EnergyDBAccess dao;

    public EnergyController() {
        try {
            dao = new EnergyDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Energy> getAllEnergy() {
        try {
            return dao.getAllEnergy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}