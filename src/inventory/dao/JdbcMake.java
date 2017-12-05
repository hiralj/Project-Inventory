package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class JdbcMake {
	private static Connection conn;
	
	public static void addNewMake(String make, String details) throws SQLException{
		conn = JdbcConnection.getConnection();
		CallableStatement csNewMake = conn.prepareCall("{call newMake(?, ?)}");
		csNewMake.setString(1, make);
		csNewMake.setString(2, details);
		csNewMake.execute();
	}
	
	public static Vector<String> getAllMakes() throws SQLException{
		Vector<String> makeList = new Vector<String>();
		conn = JdbcConnection.getConnection();
		CallableStatement csMakeList = conn.prepareCall("{call getAllMakes()}");
		ResultSet rs = csMakeList.executeQuery();
		while(rs.next()){
			makeList.add(rs.getString(1));
		}
		return makeList;
	}
}
