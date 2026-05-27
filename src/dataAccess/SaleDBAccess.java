package dataAccess;

import exception.DataAccessException;
import model.RevenueResult;

import java.sql.*;
import java.time.LocalDate;

public class SaleDBAccess implements SaleDao {
    private Connection connection;

    public SaleDBAccess() throws DataAccessException {
        try {
            connection = SingletonConnection.getInstance();
        } catch (SQLException e) {
            throw new DataAccessException("Erreur connexion base de données.");
        }
    }

    @Override
    public RevenueResult getRevenueByPeriod(LocalDate dateStart, LocalDate dateEnd) throws DataAccessException {
        try {
            String sql = """
                SELECT
                    COUNT(*) AS number_of_sales,
                    SUM(v.sale_price) AS total_revenue,
                    SUM(v.purchase_price) AS total_costs,
                    MAX(v.sale_price) AS max_sale_price,
                    MIN(v.sale_price) AS min_sale_price,
                    MAX(v.purchase_price) AS max_purchase_price,
                    MIN(v.purchase_price) AS min_purchase_price
                FROM sale s
                JOIN vehicle v ON s.vin_vehicle = v.vin
                WHERE s.date BETWEEN ? AND ?
            """;

            PreparedStatement statement  = connection.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(dateStart));
            statement.setDate(2, Date.valueOf(dateEnd));
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int numberOfSales = rs.getInt("number_of_sales");
                double totalRevenue = rs.getDouble("total_revenue");
                double totalCosts = rs.getDouble("total_costs");
                double maxSalePrice = rs.getDouble("max_sale_price");
                double minSalePrice = rs.getDouble("min_sale_price");
                double maxPurchasePrice = rs.getDouble("max_purchase_price");
                double minPurchasePrice = rs.getDouble("min_purchase_price");

                return new RevenueResult(
                        totalRevenue,
                        totalCosts,
                        numberOfSales,
                        maxSalePrice,
                        minSalePrice,
                        maxPurchasePrice,
                        minPurchasePrice
                );

            }

            return new RevenueResult(0, 0, 0, 0, 0, 0, 0);

        } catch (SQLException e) {
            throw new DataAccessException("SaleDBAccess : Revenue impossible");
        }

    }


}
