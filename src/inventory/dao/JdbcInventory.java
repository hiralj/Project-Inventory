package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;



public class JdbcInventory {
	public static Connection conn;
	
	public static DefaultTableModel getInventory(String grade, String shape, float size, float size2, String quality) throws SQLException{
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		Vector<String> columnNames = new Vector<String>();
		
		conn = JdbcConnection.getConnection();
		CallableStatement csGetInventory = conn.prepareCall("{call getInventory(?, ?, ?, ?, ?)}");
		csGetInventory.setString(1, grade);
		csGetInventory.setString(2, shape);
		csGetInventory.setFloat(3, size);
		csGetInventory.setFloat(4, size2);
		csGetInventory.setString(5, quality);
		
		ResultSet rs = csGetInventory.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		while(rs.next()){
			Vector<Object> row = new Vector<Object>();
			for(int i = 1; i <= columnCount; i++){				
				row.add(rs.getObject(i));
			}
			tableData.add(row);
		}		
		
		for(int i = 1; i <= columnCount; i++){
			columnNames.add(metaData.getColumnName(i));
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);
		
		int noOfRows = tableModel.getRowCount();
		if(noOfRows > 1){
			int totalQty = 0;
			float totalWt = 0;
			for(int i = 0; i < noOfRows; i++){
				totalQty += Integer.parseInt((tableModel.getValueAt(i, 4)).toString());
				totalWt += Float.parseFloat((tableModel.getValueAt(i, 5)).toString());
			}
			
			tableModel.addRow(new Object[] {"","","","", totalQty, totalWt, ""});
		}
		
				
		return tableModel;
	}
}
