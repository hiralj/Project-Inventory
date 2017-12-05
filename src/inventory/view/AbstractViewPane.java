package inventory.view;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

public abstract class AbstractViewPane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void modelPropertyChange(PropertyChangeEvent evt);
	
	public void initOnTabSelection(){
		System.out.println("Init on tab selection of SuperClass");
	}
}
