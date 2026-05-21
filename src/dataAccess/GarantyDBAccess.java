package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Energy;
import model.Garanty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GarantyDBAccess implements GarantyDAO {
    private Connection connection;

    public GarantyDBAccess() throws DataAccessException {
        try {
            connection = SingletonConnection.getInstance();
        } catch (SQLException e) {
            throw new DataAccessException("Erreur connexion base de données.");
        }
    }

    @Override
    public List<Garanty> getAllGaranty() throws DataAccessException, InvalidInputException {
        try {
            List<Garanty> garanties = new ArrayList<>();

            String sql = "SELECT * FROM Garanty";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Garanty garanty = new Garanty(
                        rs.getString("type"),
                        rs.getInt("duration"));
                garanties.add(garanty);
            }

            return garanties;
        } catch (SQLException e) {
            throw new DataAccessException("DATA GARANTY : List impossible");
        }
    }
}
