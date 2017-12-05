package inventory.presenter;

import inventory.model.AbstractModel;
import inventory.view.AbstractViewPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class AbstractPresenter implements PropertyChangeListener {
	private ArrayList<AbstractModel> registeredModels;
	private ArrayList<AbstractViewPane> registeredViews;

	public AbstractPresenter() {
		registeredModels = new ArrayList<AbstractModel>();
		registeredViews = new ArrayList<AbstractViewPane>();
	}

	public void addModel(AbstractModel model) {
		registeredModels.add(model);
		model.addPropertyChangeListener(this);
	}

	public void removeModel(AbstractModel model) {
		registeredModels.remove(model);
		model.removePropertyChangeListener(this);
	}

	public void addView(AbstractViewPane view) {
		registeredViews.add(view);
	}

	public void removeView(AbstractViewPane view) {
		registeredViews.remove(view);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		for (AbstractViewPane view : registeredViews) {
			view.modelPropertyChange(evt);
		}
	}

	/**
	 * Following method is invoked by some AbstractPresenter by its method which
	 * gets called by some AbstractViewPane when some event occurs
	 * 
	 * Uses Reflection
	 */
	public void setModelProperty(String propertyName, Object newValue) {
		for (AbstractModel model : registeredModels) {
			try {
				Method method = model.getClass().getMethod(
						"set" + propertyName,
						new Class[] { newValue.getClass() });
				method.invoke(model, newValue);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
