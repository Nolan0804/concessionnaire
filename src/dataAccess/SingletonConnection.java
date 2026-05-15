package dataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    private SingletonConnection() {
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookdb?useSSL=false",
                    "root",
                    "root"
            );
        }
        return connection;
    }
}
