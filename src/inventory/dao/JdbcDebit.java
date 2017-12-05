package inventory.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDebit {
	private static Connection conn;

	public static void makeDebitOperation(String grade, String shape,
			float size, float size2, String quality, String root, String make,
			float wt, int qty, int lengthDebited, int actualLength,
			String godown, String rack, String party, float rate)
			throws SQLException {
		conn = JdbcConnection.getConnection();
		CallableStatement csMakeDebit = conn
				.prepareCall("{call debitOperation2(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		csMakeDebit.setString(1, grade);
		csMakeDebit.setString(2, shape);
		csMakeDebit.setFloat(3, size);
		csMakeDebit.setFloat(4, size2);
		csMakeDebit.setString(5, quality);
		csMakeDebit.setString(6, root);
		csMakeDebit.setString(7, make);
		csMakeDebit.setFloat(8, wt);
		csMakeDebit.setInt(9, qty);
		csMakeDebit.setInt(10, lengthDebited);
		csMakeDebit.setInt(11, actualLength);
		csMakeDebit.setString(12, godown);
		csMakeDebit.setString(13, rack);
		csMakeDebit.setString(14, party);
		csMakeDebit.setFloat(15, rate);

		csMakeDebit.execute();
	}

	public static void makeNillOperation(String grade, String shape,
			float size, float size2, String quality, String root, String make,
			int length, String godown, String rack) throws SQLException {
		conn = JdbcConnection.getConnection();
		CallableStatement csMakeNill = conn
				.prepareCall("{call nillOperation(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		csMakeNill.setString(1, grade);
		csMakeNill.setString(2, shape);
		csMakeNill.setFloat(3, size);
		csMakeNill.setFloat(4, size2);
		csMakeNill.setString(5, quality);
		csMakeNill.setString(6, root);
		csMakeNill.setString(7, make);
		csMakeNill.setInt(8, length);
		csMakeNill.setString(9, godown);
		csMakeNill.setString(10, rack);

		csMakeNill.execute();
	}

	public static void makeTransferOperation(String grade, String shape,
			float size, float size2, String quality, String root, String make,
			float wt, int qty, int length, String godown, String rack,
			String newGodown, String newRack) throws SQLException {
		conn = JdbcConnection.getConnection();
		CallableStatement csMakeTransfer = conn
				.prepareCall("{call transferOperation(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		csMakeTransfer.setString(1, grade);
		csMakeTransfer.setString(2, shape);
		csMakeTransfer.setFloat(3, size);
		csMakeTransfer.setFloat(4, size2);
		csMakeTransfer.setString(5, quality);
		csMakeTransfer.setString(6, root);
		csMakeTransfer.setString(7, make);
		csMakeTransfer.setFloat(8, wt);
		csMakeTransfer.setInt(9, qty);
		csMakeTransfer.setInt(10, length);
		csMakeTransfer.setString(11, godown);
		csMakeTransfer.setString(12, rack);
		csMakeTransfer.setString(13, newGodown);
		csMakeTransfer.setString(14, newRack);

		csMakeTransfer.execute();
	}

}
