package dataAccess;

import exception.InvalidInputException;
import model.Energy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnergyDBAccess implements EnergyDAO {
    private Connection connection;

    public EnergyDBAccess()
            throws SQLException {

        connection =
                SingletonConnection.getInstance();
    }

    @Override
    public List<Energy> getAllEnergy()
            throws SQLException {

        List<Energy> energies =
                new ArrayList<>();

        String sql =
                "SELECT * FROM Energy";

        PreparedStatement statement =
                connection.prepareStatement(sql);

        ResultSet rs =
                statement.executeQuery();

        while(rs.next()) {

            Energy energy =
                    new Energy(

                            rs.getString("name"),

                            rs.getBoolean(
                                    "is_eco_friendly"
                            )
                    );

            energies.add(energy);
        }

        return energies;
    }
}