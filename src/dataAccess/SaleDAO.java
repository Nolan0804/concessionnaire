package dataAccess;

import exception.DataAccessException;
import model.RevenueResult;

import java.time.LocalDate;

public interface SaleDAO {
    RevenueResult getRevenueByPeriod(LocalDate dateStart, LocalDate dateEnd) throws DataAccessException;
}
