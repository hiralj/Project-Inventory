package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class JdbcLocation {
	private static Connection conn;
	
	public static void addNewGodown(String godownName) throws SQLException{
		conn = JdbcConnection.getConnection();
		CallableStatement csNewGodown = conn.prepareCall("{call newGodown(?)}");
		csNewGodown.setString(1, godownName);
		csNewGodown.execute();
	}
	
	public static Vector<String> getAllGodowns() throws SQLException{
		conn = JdbcConnection.getConnection();
		Vector<String> godownList = new Vector<String>();
		CallableStatement csGodownList = conn.prepareCall("{call getAllGodowns()}");
		ResultSet rs = csGodownList.executeQuery();
		while(rs.next()){
			godownList.add(rs.getString(1));
		}
		
		return godownList;
	}
	
	public static Vector<String> getAllRacks(String godownName) throws SQLException{
		conn = JdbcConnection.getConnection();
		Vector<String> rackList = new Vector<String>();
		CallableStatement csRackList = conn.prepareCall("{call getAllRacks(?)}");
		csRackList.setString(1, godownName);
		ResultSet rs = csRackList.executeQuery();
		while(rs.next()){
			rackList.add(rs.getString(1));
		}
		return rackList;
	}
	
	public static void addNewLocation(String godownName, String rackName) throws SQLException{
		conn = JdbcConnection.getConnection();
		CallableStatement csNewLocation = conn.prepareCall("{call newLocation(?, ?)}");
		csNewLocation.setString(1, godownName);
		csNewLocation.setString(2, rackName);
		
		csNewLocation.execute();
	}
}
