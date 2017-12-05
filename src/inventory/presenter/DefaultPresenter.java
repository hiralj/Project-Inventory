package inventory.presenter;

import inventory.dao.JdbcCredit;
import inventory.dao.JdbcDebit;
import inventory.dao.JdbcInventory;
import inventory.dao.JdbcLocation;
import inventory.dao.JdbcMake;
import inventory.dao.JdbcMaterial;
import inventory.model.CreditModel;
import inventory.model.GSSModel;
import inventory.model.InventoryModel;
import inventory.model.LocationModel;
import inventory.model.MakeModel;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class DefaultPresenter extends AbstractPresenter {
	public static final String GSS_GRADE_PROPERTY = "Grade";
	public static final String GSS_MATERIAL_PROPERTY = "Material";
	public static final String INFO_GRADELIST_PROPERTY = "GradeList";
	public static final String INFO_GODOWNLIST_PROPERTY = "GodownList";
	public static final String INFO_RACKLIST_PROPERTY = "RackList";
	public static final String INFO_SHAPELIST_PROPERTY = "ShapeList";
	public static final String INFO_SIZELIST_PROPERTY = "SizeList";
	public static final String INFO_SIZE2LIST_PROPERTY = "Size2List";
	public static final String INFO_MAKELIST_PROPERTY = "MakeList";
	public static final String INFO_INVENTORY_PROPERTY = "Inventory";
	public static final String LOCATION_GODOWN_PROPERTY = "Godown";
	public static final String LOCATION_RACK_PROPERTY = "Rack";
	public static final String LOCATION_PROPERTY = "Location";
	public static final String MAKE_PROPERTY = "Make";
	public static final String CREDIT_PROPERTY = "Credit";

	public static final int PARTY_LIST = 10;
	/**
	 * For Credit
	 */
	public static final String[] QUALITY_LIST = { "Black", "Bright", "CG" };
	/**
	 * For Init
	 */
	public static final String[] SHAPE_LIST = { "Round", "Flat", "Square",
			"Hex" };
	/**
	 * For Credit
	 */
	public static final String[] ROOT_LIST = { "Rolling", "VD", "AOD" };

	public void createNewGrade(String gradeName) {
		try {
			JdbcMaterial.addGrade(gradeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(GSS_GRADE_PROPERTY, gradeName);
	}

	public void loadGradeList() {
		Vector<String> gradeList = null;
		try {
			gradeList = JdbcMaterial.getAllGrades();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setModelProperty(INFO_GRADELIST_PROPERTY, gradeList);
	}

	public void createNewMaterial(String gradeName, String shapeName,
			float size, float size2) {
		try {
			JdbcMaterial.addMaterial(gradeName, shapeName, size, size2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setModelProperty(GSS_MATERIAL_PROPERTY, new GSSModel(gradeName,
				shapeName, size, size2));
	}

	public void createNewGodown(String godownName) {
		try {
			JdbcLocation.addNewGodown(godownName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(LOCATION_GODOWN_PROPERTY, godownName);
	}

	public void loadGodownList() {
		Vector<String> godownList = new Vector<String>();
		try {
			godownList = JdbcLocation.getAllGodowns();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_GODOWNLIST_PROPERTY, godownList);
	}

	public void loadRackList(String godownName) {
		Vector<String> rackList = new Vector<String>();
		try {
			rackList = JdbcLocation.getAllRacks(godownName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_RACKLIST_PROPERTY, rackList);
	}

	public void createNewLocation(String godown, String rack) {
		try {
			JdbcLocation.addNewLocation(godown, rack);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(LOCATION_PROPERTY, new LocationModel(godown, rack));
	}

	public void createNewMake(String makeName, String details) {
		try {
			JdbcMake.addNewMake(makeName, details);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(MAKE_PROPERTY, new MakeModel(makeName, details));
	}

	public void loadShapeList(String gradeName) {
		Vector<String> shapesList = null;
		try {
			shapesList = JdbcMaterial.getShapes(gradeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_SHAPELIST_PROPERTY, shapesList);
	}

	public void loadSizeList(String gradeName, String shapeName) {
		Vector<Float> sizeList = null;
		try {
			sizeList = JdbcMaterial.getSizes(gradeName, shapeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_SIZELIST_PROPERTY, sizeList);
	}

	public void loadSize2List(String gradeName, String shapeName, float size) {
		Vector<Float> size2List = null;
		try {
			size2List = JdbcMaterial.getSizes2(gradeName, shapeName, size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_SIZE2LIST_PROPERTY, size2List);
	}

	public void loadMakeList() {
		Vector<String> makeList = null;
		try {
			makeList = JdbcMake.getAllMakes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_MAKELIST_PROPERTY, makeList);
	}

	public void makeCreditOperation(String grade, String shape, float size,
			float size2, String quality, String root, String make,
			float weight, int qty, int length, String godown, String rack) {
		try {
			JdbcCredit.makeCreditOperation(grade, shape, size, size2, quality,
					root, make, weight, qty, length, godown, rack);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GSSModel material = new GSSModel(grade, shape, size, size2);
		LocationModel location = new LocationModel(godown, rack);
		setModelProperty(CREDIT_PROPERTY, new CreditModel(material, quality,
				root, make, weight, qty, length, location));
	}

	public void getInventory(String grade, String shape, float size,
			float size2, String quality) {
		DefaultTableModel inventoryList = null;
		try {
			inventoryList = JdbcInventory.getInventory(grade, shape, size,
					size2, quality);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setModelProperty(INFO_INVENTORY_PROPERTY, inventoryList);
	}

	public void makeDebitOperation(String grade, String shape, float size,
			float size2, String quality, String root, String make, float wt,
			int qty, int lengthDebited, int actualLength, String godown, String rack, String party,
			float rate) {
		try {
			JdbcDebit.makeDebitOperation(grade, shape, size, size2, quality,
					root, make, wt, qty, lengthDebited, actualLength, godown, rack, party, rate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void makeNillOperation(String grade, String shape, float size,
			float size2, String quality, String root, String make, int length,
			String godown, String rack) {
		try {
			JdbcDebit.makeNillOperation(grade, shape, size, size2, quality,
					root, make, length, godown, rack);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeTransferOperation(String grade, String shape,
			float size, float size2, String quality, String root, String make,
			float wt, int qty, int length, String godown, String rack,
			String newGodown, String newRack){
		try {
			JdbcDebit.makeTransferOperation(grade, shape, size, size2, quality, root, make, wt, qty, length, godown, rack, newGodown, newRack);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
