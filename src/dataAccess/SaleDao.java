package dataAccess;

import exception.DataAccessException;
import model.RevenueResult;

import java.time.LocalDate;

public interface  SaleDao {
    RevenueResult getRevenueByPeriod(LocalDate dateStart, LocalDate dateEnd) throws DataAccessException;
}
