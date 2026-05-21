package dataAccess;

import exception.DataAccessException;
import exception.InvalidInputException;
import model.Energy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnergyDBAccess implements EnergyDAO {
    private Connection connection;

    public EnergyDBAccess() throws DataAccessException {
        try {
            connection = SingletonConnection.getInstance();
        } catch (SQLException e) {
            throw new DataAccessException("Erreur connexion base de données.");
        }
    }

    @Override
    public List<Energy> getAllEnergy() throws DataAccessException, InvalidInputException {
        try {
            List<Energy> energies = new ArrayList<>();

            String sql = "SELECT * FROM Energy";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Energy energy = new Energy(rs.getString("type"), rs.getBoolean("is_eco_friendly"));
                energies.add(energy);
            }

            return energies;
        } catch (SQLException e) {
            throw new DataAccessException("DATA ENERGY : List impossible");
        }
    }

}