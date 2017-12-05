package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcCredit {
	private static Connection conn;
	
	public static void makeCreditOperation(String grade, String shape, float size, float size2, 
			String quality, String root, String make,
			float weight, int qty, int length, String godown, String rack) throws SQLException{
		conn = JdbcConnection.getConnection();
		CallableStatement csCreditOperation = conn.prepareCall("{call creditOperation(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		csCreditOperation.setString(1, grade);
		csCreditOperation.setString(2, shape);
		csCreditOperation.setFloat(3, size);
		csCreditOperation.setFloat(4, size2);
		csCreditOperation.setString(5, quality);
		csCreditOperation.setString(6, root);
		csCreditOperation.setString(7, make);
		csCreditOperation.setFloat(8, weight);
		csCreditOperation.setInt(9, qty);
		csCreditOperation.setInt(10, length);
		csCreditOperation.setString(11, godown);
		csCreditOperation.setString(12, rack);
		
		csCreditOperation.execute();
	}
}
