package business;

import dataAccess.SaleDAO;
import dataAccess.SaleDBAccess;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.RevenueResult;

import java.time.LocalDate;

public class RevenueBusiness {
    private SaleDAO dao;

    public RevenueBusiness() {
        try {
            dao = new SaleDBAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double calculateNetProfit(RevenueResult result) throws InvalidInputException {
        if (result == null) {
            throw new InvalidInputException("Le résultat ne peut pas être null.");
        }
        return result.getNetProfit();
    }

    public boolean isPeriodValid(LocalDate dateStart, LocalDate dateEnd) {
        if (dateStart == null || dateEnd == null) return false;
        if (dateStart.isAfter(dateEnd)) return false;
        if (dateStart.isAfter(LocalDate.now())) return false;
        return true;
    }

    public RevenueResult calculateRevenue(LocalDate dateStart, LocalDate dateEnd)
            throws InvalidInputException, DataAccessException {

        if (!isPeriodValid(dateStart, dateEnd)) {
            throw new InvalidInputException("La période est invalide : vérifiez que les dates ne sont pas nulles, que le début est avant la fin, et que la période n'est pas dans le futur.");
        }

        return dao.getRevenueByPeriod(dateStart, dateEnd);
    }


}
