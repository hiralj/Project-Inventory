package inventory.model;

import inventory.presenter.DefaultPresenter;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class InfoLoaderModel extends AbstractModel {
	private Vector<String> gradeList;
	private Vector<String> godownList;
	private Vector<String> shapeList;
	private Vector<Float> sizeList;
	private Vector<Float> size2List;
	private Vector<String> makeList;
	private Vector<String> rackList;
	private DefaultTableModel inventory;

	public Vector<String> getGradeList() {

		return gradeList;
	}

	public void setGradeList(Vector<String> gradeList) {
		Vector<String> oldGradeList = this.gradeList;
		this.gradeList = gradeList;
		firePropertyChange(DefaultPresenter.INFO_GRADELIST_PROPERTY,
				oldGradeList, gradeList);
	}

	public Vector<String> getGodownList() {
		return godownList;
	}

	public void setGodownList(Vector<String> godownList) {
		Vector<String> oldGodownList = this.godownList;
		this.godownList = godownList;
		firePropertyChange(DefaultPresenter.INFO_GODOWNLIST_PROPERTY,
				oldGodownList, godownList);
	}

	public Vector<String> getShapeList() {
		return shapeList;
	}

	public void setShapeList(Vector<String> shapeList) {
		Vector<String> oldShapeList = this.shapeList;
		this.shapeList = shapeList;
		firePropertyChange(DefaultPresenter.INFO_SHAPELIST_PROPERTY,
				oldShapeList, shapeList);
	}

	public Vector<Float> getSizeList() {
		return sizeList;
	}

	public void setSizeList(Vector<Float> sizeList) {
		Vector<Float> oldSizeList = this.sizeList;
		this.sizeList = sizeList;
		firePropertyChange(DefaultPresenter.INFO_SIZELIST_PROPERTY,
				oldSizeList, sizeList);
	}

	public Vector<Float> getSize2List() {
		return size2List;
	}

	public void setSize2List(Vector<Float> size2List) {
		Vector<Float> oldSize2List = this.size2List;
		this.size2List = size2List;
		firePropertyChange(DefaultPresenter.INFO_SIZE2LIST_PROPERTY,
				oldSize2List, size2List);
	}

	public Vector<String> getMakeList() {
		return makeList;
	}

	public void setMakeList(Vector<String> makeList) {
		Vector<String> oldMakeList = this.makeList;
		this.makeList = makeList;
		firePropertyChange(DefaultPresenter.INFO_MAKELIST_PROPERTY,
				oldMakeList, makeList);
	}

	public Vector<String> getRackList() {
		return rackList;
	}

	public void setRackList(Vector<String> rackList) {
		Vector<String> oldRackList = this.rackList;
		this.rackList = rackList;
		firePropertyChange(DefaultPresenter.INFO_RACKLIST_PROPERTY,
				oldRackList, rackList);
	}

//	public Vector<InventoryModel> getInventoryList() {
//		return inventoryList;
//	}
//
//	public void setInventoryList(Vector<InventoryModel> inventoryList) {
//		Vector<InventoryModel> oldInventory = this.inventoryList;
//		this.inventoryList = inventoryList;
//		firePropertyChange(DefaultPresenter.INFO_INVENTORY_PROPERTY, oldInventory, inventoryList);
//	}

	public DefaultTableModel getInventory() {
		return inventory;
	}

	public void setInventory(DefaultTableModel inventory) {
		DefaultTableModel oldInventory = this.inventory;
		this.inventory = inventory;
		firePropertyChange(DefaultPresenter.INFO_INVENTORY_PROPERTY, oldInventory, inventory);
	}

}
