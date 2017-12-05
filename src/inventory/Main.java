package inventory;

import inventory.model.CreditModel;
import inventory.model.GSSModel;
import inventory.model.InfoLoaderModel;
import inventory.model.LocationModel;
import inventory.model.MakeModel;
import inventory.presenter.DefaultPresenter;
import inventory.view.CreditView;
import inventory.view.DebitView;
import inventory.view.InventoryView;
import inventory.view.MasterView;

public class Main {
	public static void main(String[] args) {
		DefaultPresenter presenter = new DefaultPresenter();
		

		InventoryView inventoryView = new InventoryView();
		inventoryView.setPresenter(presenter);
		
		CreditView creditView = new CreditView();
		creditView.setPresenter(presenter);
		
		DebitView debitView = new DebitView();
		debitView.setPresenter(presenter);
		
		MasterView masterView = new MasterView();
		masterView.setPresenter(presenter);
		
		masterView.addPanel(inventoryView.getInventoryPanel(), "Inventory", inventoryView);
		masterView.addPanel(creditView.getCreditPanel(), "Credit", creditView);
		masterView.addPanel(debitView.getDebitPanel(), "Debit", debitView);
		
		
		GSSModel model = new GSSModel();
		InfoLoaderModel infoLoaderModel = new InfoLoaderModel();
		LocationModel locationModel = new LocationModel();
		MakeModel makeModel = new MakeModel();
		CreditModel creditModel = new CreditModel();
		
		presenter.addModel(infoLoaderModel);
		presenter.addModel(model);
		presenter.addModel(locationModel);
		presenter.addModel(makeModel);
		presenter.addModel(creditModel);
		
		presenter.addView(masterView);
		presenter.addView(inventoryView);
		presenter.addView(creditView);
		presenter.addView(debitView);
		
		masterView.createView();
	}
}
