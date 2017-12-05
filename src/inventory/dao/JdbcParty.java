package inventory.dao;

import inventory.presenter.DefaultPresenter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcParty {
	private static Connection conn;
	
	public static String[] getParty(String subName) throws SQLException{
		String[] partyList = new String[DefaultPresenter.PARTY_LIST];
		conn = JdbcConnection.getConnection();
		CallableStatement csParty = conn.prepareCall("{call getPossibleParty(?)}");
		csParty.setString(1, subName);
		ResultSet rs = csParty.executeQuery();
		
		int i = 0;
		while(rs.next()){
			partyList[i] = rs.getString(1);
			i++;
			if(i == DefaultPresenter.PARTY_LIST)			
				break;
		}
		return partyList;
	}
}
