package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcStock {

    public ResultSet getMaterialStock() throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        CallableStatement stmt = connection.prepareCall(RawSQL.totalStock);
        ResultSet resultSet = stmt.executeQuery();
        return resultSet;
    }
}
