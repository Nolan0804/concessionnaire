package dataAccess;

import exception.InvalidInputException;
import model.Brand;
import model.Energy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDBAccess implements BrandDAO {
    private Connection connection;

    public BrandDBAccess() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    @Override
    public List<Brand> getAllBrand() throws SQLException, InvalidInputException {
        List<Brand> brands = new ArrayList<>();

        String sql = "SELECT * FROM Brand";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()) {
            Brand brand = new Brand(
                    rs.getString("name"),
                    rs.getInt("year_created"),
                    rs.getBoolean("is_eco_friendly"));
            brands.add(brand);
        }

        return energies;
    }
}
