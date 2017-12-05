package inventory.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractModel {
	protected PropertyChangeSupport propertyChangeSupport;
	
	public AbstractModel() {
		// TODO Auto-generated constructor stub
		propertyChangeSupport = new PropertyChangeSupport(this);
	}
	 
	public void addPropertyChangeListener(PropertyChangeListener l){
		propertyChangeSupport.addPropertyChangeListener(l);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener l){
		propertyChangeSupport.removePropertyChangeListener(l);
	}
	
	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue){
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}
