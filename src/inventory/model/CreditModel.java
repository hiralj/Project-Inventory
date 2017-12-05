package inventory.model;

import inventory.presenter.DefaultPresenter;

public class CreditModel extends AbstractModel{ 
	private GSSModel material;
	private String quality;
	private String root;
	private String make;
	private float weight;
	private int qty;
	private int length;
	private LocationModel location;
	private CreditModel credit;
	
	public CreditModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CreditModel(GSSModel material, String quality, String root,
			String make, float weight, int qty, int length,
			LocationModel location) {
		super();
		this.material = material;
		this.quality = quality;
		this.root = root;
		this.make = make;
		this.weight = weight;
		this.qty = qty;
		this.length = length;
		this.location = location;
	}


	public GSSModel getMaterial() {
		return material;
	}
	public void setMaterial(GSSModel material) {
		this.material = material;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
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
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public LocationModel getLocation() {
		return location;
	}
	public void setLocation(LocationModel location) {
		this.location = location;
	}


	public CreditModel getCredit() {
		return credit;
	}


	public void setCredit(CreditModel credit) {
		CreditModel oldCredit = this.credit;
		this.credit = credit;
		firePropertyChange(DefaultPresenter.CREDIT_PROPERTY, oldCredit, credit);
	}
	
	
}
