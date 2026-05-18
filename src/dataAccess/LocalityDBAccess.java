package dataAccess;

import exception.InvalidInputException;
import model.Country;
import model.Locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalityDBAccess implements LocalityDAO {
    private Connection connection;

    public LocalityDBAccess() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    @Override
    public Locality getLocalityByCodeLocality(int postalCode, String localityName) throws SQLException, InvalidInputException {
        String sql = """
                SELECT l.name, l.postal_code, c.name AS country_name
                FROM Locality l
                JOIN Country c
                ON l.country_name = c.name
                WHERE l.name = ? AND l.postal_code = ?
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, localityName);
        statement.setInt(2, postalCode);
        ResultSet rs = statement.executeQuery();

        if(rs.next()) {
            Country country = new Country(
                    rs.getString("country_name")
            );
            return new Locality(
                    rs.getString("name"),
                    rs.getInt("postal_code"),
                    country
            );
        }
        return null;
    }
}