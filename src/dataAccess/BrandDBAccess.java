package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;

import model.Brand;
import model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class BrandDBAccess implements BrandDAO {
    private Connection connection;

    public BrandDBAccess() throws DataAccessException {
        try {
            connection = SingletonConnection.getInstance();
        } catch (SQLException e) {
            throw new DataAccessException("Error connecting to the database.");
        }
    }

    @Override
    public List<Brand> getAllBrand() throws DataAccessException, InvalidInputException {
        try {
            List<Brand> brands = new ArrayList<>();
            String sql = "SELECT * FROM Brand";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Country country =
                        new Country(
                                rs.getString(
                                        "origin_country"
                                )
                        );

                Brand brand =
                        new Brand(
                                rs.getString("name"),
                                rs.getInt("year_created"),
                                country
                        );

                brands.add(brand);
            }

            return brands;
        } catch (SQLException e) {
            throw new DataAccessException("DATA BRAND : List impossible");
        }
    }
}