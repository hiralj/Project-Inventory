package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class JdbcMaterial {
	private static Connection conn;
	
	public static void addGrade(String gradeName) throws SQLException{
		
		conn = JdbcConnection.getConnection();
		CallableStatement csNewGrade = conn.prepareCall("{call newGrade(?)}");
		csNewGrade.setString(1, gradeName);
		csNewGrade.execute();
	}
	
	public static Vector<String> getAllGrades() throws SQLException{
		Vector<String> allGrades = new Vector<String>();
		conn = JdbcConnection.getConnection();
		CallableStatement csAllGrades = conn.prepareCall("{call getAllGrades()}");
		ResultSet rsAllGrades = csAllGrades.executeQuery();
		while(rsAllGrades.next()){
			allGrades.add(rsAllGrades.getString(1));
		}
		return allGrades;
	}
	
	public static void addMaterial(String gradeName, String shapeName, float size, float size2) throws SQLException{
		conn = JdbcConnection.getConnection();
		CallableStatement csNewMaterial = null;
		if(!shapeName.equals("Flat")){
			csNewMaterial = conn.prepareCall("{call newNonFlatGrade(?, ?, ?)}");
			csNewMaterial.setString(1, gradeName);
			csNewMaterial.setString(2, shapeName);
			csNewMaterial.setFloat(3, size);
		} else{
			csNewMaterial = conn.prepareCall("{call newFlatMaterial(?, ?, ?, ?)}");
			csNewMaterial.setString(1, gradeName);
			csNewMaterial.setString(2, shapeName);
			csNewMaterial.setFloat(3, size);
			csNewMaterial.setFloat(4, size2);
		}
		csNewMaterial.execute();
	}
	
	public static Vector<String> getShapes(String gradeName) throws SQLException{
		Vector<String> shapesList = new Vector<String>();
		conn = JdbcConnection.getConnection();
		CallableStatement csShapes = conn.prepareCall("{call getShapes(?)}");
		csShapes.setString(1, gradeName);
		ResultSet rs = csShapes.executeQuery();
		while(rs.next()){
			shapesList.add(rs.getString(1));
		}
		return shapesList;
	}
	
	public static Vector<Float> getSizes(String gradeName, String shapeName) throws SQLException{
		Vector<Float> sizeList = new Vector<Float>();
		conn = JdbcConnection.getConnection();
		CallableStatement csSizes = conn.prepareCall("{call getSize(?, ?)}");
		csSizes.setString(1, gradeName);
		csSizes.setString(2, shapeName);
		ResultSet rs = csSizes.executeQuery();
		while(rs.next()){
			sizeList.add(rs.getFloat(1));
		}		
		return sizeList;
	}
	
	public static Vector<Float> getSizes2(String gradeName, String shapeName, float size) throws SQLException{
		Vector<Float> size2List = new Vector<Float>();
		conn = JdbcConnection.getConnection();
		CallableStatement csSizes2 = conn.prepareCall("{call getSize2(?, ?, ?)}");
		csSizes2.setString(1, gradeName);
		csSizes2.setString(2, shapeName);
		csSizes2.setFloat(3, size);
		ResultSet rs = csSizes2.executeQuery();
		while(rs.next()){
			size2List.add(rs.getFloat(1));
		}		
		return size2List;
	}
}
