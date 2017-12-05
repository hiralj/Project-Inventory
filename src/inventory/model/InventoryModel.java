package inventory.model;

public class InventoryModel extends AbstractModel{
	String root;
	String make;
	String godown;
	String rack;
	Integer qty;
	Float wt;
	Integer length;
	InventoryModel inventory;
	
	public InventoryModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public InventoryModel(String root, String make, String godown, String rack,
			Integer qty, Float wt, Integer length) {
		super();
		this.root = root;
		this.make = make;
		this.godown = godown;
		this.rack = rack;
		this.qty = qty;
		this.wt = wt;
		this.length = length;
	}


	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getGodown() {
		return godown;
	}
	public void setGodown(String godown) {
		this.godown = godown;
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Float getWt() {
		return wt;
	}
	public void setWt(Float wt) {
		this.wt = wt;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public InventoryModel getInventory() {
		return inventory;
	}
	public void setInventory(InventoryModel inventory) {		
		this.inventory = inventory;
	}
}
