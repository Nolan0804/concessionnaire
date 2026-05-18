package dataAccess;

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

    public GarantyDBAccess() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    @Override
    public List<Garanty> getAllGaranty() throws SQLException, InvalidInputException {
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
    }
}
