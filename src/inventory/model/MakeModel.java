package inventory.model;

import inventory.presenter.DefaultPresenter;

public class MakeModel extends AbstractModel{
	private String makeName;
	private String details;
	private MakeModel make;
	
	public MakeModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MakeModel(String makeName, String details) {
		super();
		this.makeName = makeName;
		this.details = details;
	}


	public String getMakeName() {
		return makeName;
	}
	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public MakeModel getMake() {
		return make;
	}
	public void setMake(MakeModel make) {
		MakeModel oldMake = this.make;
		this.make = make;
		firePropertyChange(DefaultPresenter.MAKE_PROPERTY, oldMake, make);
	}
	
	
}
