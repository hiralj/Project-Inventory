package inventory.model;

import inventory.presenter.DefaultPresenter;

public class LocationModel extends AbstractModel{
	private String godown;
	private String rack;
	private LocationModel location;
	
	public LocationModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LocationModel(String godown, String rack) {
		super();
		this.godown = godown;
		this.rack = rack;
	}


	public String getGodown() {
		return godown;
	}
	public void setGodown(String godown) {
		String oldGodown = this.godown;
		this.godown = godown;
		firePropertyChange(DefaultPresenter.LOCATION_GODOWN_PROPERTY, oldGodown, godown);
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
	
	public LocationModel getLocation() {
		return location;
	}
	public void setLocation(LocationModel location) {
		LocationModel oldLocation = this.location;
		this.location = location;
		firePropertyChange(DefaultPresenter.LOCATION_PROPERTY, oldLocation, location);
	}
	
	
}
