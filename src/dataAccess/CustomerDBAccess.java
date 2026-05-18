package dataAccess;

import exception.InvalidInputException;
import model.Country;
import model.Customer;
import model.Locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBAccess implements CustomerDAO {
    private Connection connection;

    public CustomerDBAccess() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    @Override
    public List<Customer> getAllCustomer() throws SQLException, InvalidInputException {
        List<Customer> customers = new ArrayList<>();
        LocalityDBAccess localityDAO = new LocalityDBAccess();
        String sql = "SELECT * FROM Customer";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()) {
            Locality locality;

            Customer customer = new Customer(
                    rs.getInt("customer_number"),
                    rs.getString("name"),
                    rs.getString("firstname"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("address"),
                    rs.getDate("birthday_date").toLocalDate(),
                    localityDAO.getLocalityByCodeLocality(rs.getInt("postal_code"), rs.getString("locality_name"))
            );
            customers.add(customer);
        }

        return customers;
    }
}
