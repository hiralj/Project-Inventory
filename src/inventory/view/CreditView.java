package inventory.view;

import inventory.model.CreditModel;
import inventory.presenter.DefaultPresenter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.beans.PropertyChangeEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CreditView extends AbstractViewPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel creditPanel;
	private DefaultPresenter presenter;
	
	private JComboBox cbGrade;
	private JComboBox cbQuality;
	private JComboBox cbShape;
	private JComboBox cbSize;
	private JComboBox cbSize2;
	private JComboBox cbRoot;
	private JComboBox cbMake;
	private JLabel lblWeight;
	private JTextField txtWeight;
	private JLabel lblQty;
	private JTextField txtQty;
	private JLabel lblLength;
	private JTextField txtLength;
	private JLabel lblGodown;
	private JComboBox cbGodown;
	private JLabel lblRack;
	private JComboBox cbRack;
	private JButton btnCreditMaterial;
	private JLabel lblCreditOperation;
	private DefaultComboBoxModel comboModel;

	/**
	 * Launch the application.
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					CreditView window = new CreditView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreditView() {
		initialize();
	}

	public DefaultPresenter getPresenter() {
		return presenter;
	}

	public void setPresenter(DefaultPresenter presenter) {
		this.presenter = presenter;
	}

	public JPanel getCreditPanel() {
		return creditPanel;
	}

	public void setCreditPanel(JPanel creditPanel) {
		this.creditPanel = creditPanel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		creditPanel = new JPanel();
		frame.getContentPane().add(creditPanel, BorderLayout.CENTER);
						
		comboModel = new DefaultComboBoxModel();
		JLabel lblGrade = new JLabel("Grade: ");

		cbGrade = new JComboBox();
		cbGrade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				loadShapeList();
			}
		});
		cbGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadShapeList();
			}
		});

		JLabel lblShape = new JLabel("Shape: ");

		cbShape = new JComboBox();
		cbShape.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				loadSizeList();
			}
		});
		cbShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadSizeList();
			}
		});

		JLabel lblSize = new JLabel("Size: ");

		cbSize = new JComboBox();
		cbSize.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				loadSize2List();
			}
		});
		cbSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadSize2List();
			}
		});

		JLabel lblSize_1 = new JLabel("Size2: ");

		cbSize2 = new JComboBox();
		cbSize2.setEnabled(false);

		JLabel lblQuality = new JLabel("Quality :");

		cbQuality = new JComboBox();

		JLabel lblRoot = new JLabel("Root: ");

		cbRoot = new JComboBox();

		JLabel lblMake = new JLabel("Make: ");

		cbMake = new JComboBox();
		
		lblWeight = new JLabel("Weight: ");
		
		txtWeight = new JTextField();
		txtWeight.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtWeight.selectAll();
			}
		});
		txtWeight.setText("0");
		txtWeight.setColumns(10);
		
		lblQty = new JLabel("Qty: ");
		
		txtQty = new JTextField();
		txtQty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtQty.selectAll();
			}
		});
		txtQty.setText("0");
		txtQty.setColumns(10);
		
		lblLength = new JLabel("Length: ");
		
		txtLength = new JTextField();
		txtLength.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtLength.selectAll();
			}
		});
		txtLength.setText("0");
		txtLength.setColumns(10);
		
		lblGodown = new JLabel("Godown: ");
		
		cbGodown = new JComboBox();
		cbGodown.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				loadRackList();
			}
		});
		cbGodown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadRackList();
			}
		});
		
		lblRack = new JLabel("Rack: ");
		
		cbRack = new JComboBox();
		
		btnCreditMaterial = new JButton("Credit Material");
		btnCreditMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeCreditOperation();
			}
		});
		
		lblCreditOperation = new JLabel("");
		lblCreditOperation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCreditOperation.setForeground(new Color(0, 128, 0));
		GroupLayout gl_creditPanel = new GroupLayout(creditPanel);
		gl_creditPanel.setHorizontalGroup(
			gl_creditPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_creditPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_creditPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_creditPanel.createSequentialGroup()
							.addComponent(lblWeight)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblQty)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLength)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_creditPanel.createSequentialGroup()
							.addGroup(gl_creditPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_creditPanel.createSequentialGroup()
									.addComponent(lblGrade)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_creditPanel.createSequentialGroup()
									.addComponent(lblQuality)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(26)
							.addGroup(gl_creditPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_creditPanel.createSequentialGroup()
									.addComponent(lblShape)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_creditPanel.createSequentialGroup()
									.addComponent(lblRoot)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cbRoot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(33)
							.addGroup(gl_creditPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_creditPanel.createSequentialGroup()
									.addComponent(lblSize)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(lblSize_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_creditPanel.createSequentialGroup()
									.addComponent(lblMake)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cbMake, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_creditPanel.createSequentialGroup()
							.addComponent(lblGodown)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblRack)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbRack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_creditPanel.createSequentialGroup()
							.addComponent(btnCreditMaterial, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(lblCreditOperation)))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		gl_creditPanel.setVerticalGroup(
			gl_creditPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_creditPanel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_creditPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrade)
						.addComponent(cbGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShape)
						.addComponent(cbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize)
						.addComponent(cbSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize_1)
						.addComponent(cbSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_creditPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuality)
						.addComponent(cbQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRoot)
						.addComponent(cbRoot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMake)
						.addComponent(cbMake, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_creditPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeight)
						.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQty)
						.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLength)
						.addComponent(txtLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_creditPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGodown)
						.addComponent(cbGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRack)
						.addComponent(cbRack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_creditPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreditMaterial, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCreditOperation))
					.addContainerGap())
		);
		creditPanel.setLayout(gl_creditPanel);
	}
	
	@Override
	public void initOnTabSelection(){		
		cbGrade.requestFocus();
		loadGradeList();
		viewLoadAllQuality();
		viewLoadAllRoot();
		loadMakeList();
		loadGodownList();		
//		cbShape.setModel(comboModel);
//		cbSize.setModel(comboModel);
//		cbSize2.setModel(comboModel);
	}

	private void loadGradeList() {
		presenter.loadGradeList();
	}
	
	private void loadMakeList(){
		presenter.loadMakeList();
	}
	
	private void loadGodownList(){
		presenter.loadGodownList();
	}

	private void loadShapeList() {
		presenter.loadShapeList(cbGrade.getSelectedItem().toString());
	}

	private void loadSizeList() {
		Object shape = cbShape.getSelectedItem();
		if(shape != null){
			String shapeName = shape.toString();
			if(shapeName.equals("Flat")){
				cbSize2.setEnabled(true);
			} else{
				cbSize2.setEnabled(false);
			}
			
			presenter.loadSizeList(cbGrade.getSelectedItem().toString(), shapeName);
		}
				
	}

	private void loadSize2List() {
		Object shape = cbShape.getSelectedItem();
		if(shape != null){
			String shapeName = shape.toString();
			if (shapeName.equals("Flat")) {
				String gradeName = cbGrade.getSelectedItem().toString();
				float size = 0;
				try {
					size = Float.parseFloat(cbSize.getSelectedItem().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				presenter.loadSize2List(gradeName, shapeName, size);
			}
		}		
	}
	
	private void loadRackList(){
		String godownName = cbGodown.getSelectedItem().toString();
		presenter.loadRackList(godownName);
	}
	
	private void makeCreditOperation(){
		String gradeName = cbGrade.getSelectedItem().toString();
		String shapeName = cbShape.getSelectedItem().toString();
		//TODO Check for NumberFormatException here
		float sizeNum = Float.parseFloat(cbSize.getSelectedItem().toString());
		float size2Num;
		if(shapeName.equals("Flat")){
			size2Num = Float.parseFloat(cbSize2.getSelectedItem().toString());
		} else {
			size2Num = 0;
		}
		String quality = cbQuality.getSelectedItem().toString();
		String root = cbRoot.getSelectedItem().toString();
		String make = cbMake.getSelectedItem().toString();
		
		//TODO Check for NumberFormatException here
		float weight = Float.parseFloat(txtWeight.getText());
		int qty = Integer.parseInt(txtQty.getText());
		int length = Integer.parseInt(txtLength.getText());

		String godown = cbGodown.getSelectedItem().toString();
		String rack = cbRack.getSelectedItem().toString();
		presenter.makeCreditOperation(gradeName, shapeName, sizeNum, size2Num, 
				quality, root, make, weight, qty, length, godown, rack);
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(
				DefaultPresenter.INFO_GRADELIST_PROPERTY)) {
			viewLoadGradeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(
				DefaultPresenter.INFO_SHAPELIST_PROPERTY)) {
			viewLoadShapeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(
				DefaultPresenter.INFO_SIZELIST_PROPERTY)) {
			viewLoadSizeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(
				DefaultPresenter.INFO_SIZE2LIST_PROPERTY)) {
			viewLoadSize2List(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_MAKELIST_PROPERTY)){
			viewLoadMakeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_GODOWNLIST_PROPERTY)){
			viewLoadGodownList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_RACKLIST_PROPERTY)){
			viewLoadRackList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.CREDIT_PROPERTY)){
			viewCreditOperation(evt.getNewValue());
		}

	}

	private void viewLoadGradeList(Object gList) {
		if (gList instanceof Vector<?>) {
			cbGrade.setModel(new DefaultComboBoxModel((Vector<String>) gList));
		} else {
			System.out.println("Loading Grade List not in Vector form");
		}
	}
	
	private void viewLoadMakeList(Object mList){
		if(mList instanceof Vector<?>){
			cbMake.setModel(new DefaultComboBoxModel((Vector<String>) mList));
		} else {
			System.out.println("Loading Make List not in Vector form");
		}
	}
	
	private void viewLoadGodownList(Object gList){
		if (gList instanceof Vector<?>) {
			cbGodown.setModel(new DefaultComboBoxModel((Vector<String>) gList));
		} else {
			System.out.println("Loading Godown List not in Vector form");
		}
	}

	private void viewLoadShapeList(Object sList) {
		if (sList instanceof Vector<?>) {
			cbShape.setModel(new DefaultComboBoxModel((Vector<String>) sList));
		} else {
			System.out.println("Loading Shape List not in Vector form");
		}
	}

	private void viewLoadSizeList(Object sList) {
		if (sList instanceof Vector<?>) {
			cbSize.setModel(new DefaultComboBoxModel((Vector<Float>) sList));
		} else {
			System.out.println("Loading Size List not in Vector form");
		}
	}

	private void viewLoadSize2List(Object sList) {
		if (sList instanceof Vector<?>) {
			cbSize2.setModel(new DefaultComboBoxModel((Vector<Float>) sList));
		} else {
			System.out.println("Loading Size2 List not in Vector form");
		}
	}

	private void viewLoadAllQuality() {
		cbQuality.setModel(new DefaultComboBoxModel(
				DefaultPresenter.QUALITY_LIST));
	}

	private void viewLoadAllRoot() {
		cbRoot.setModel(new DefaultComboBoxModel(DefaultPresenter.ROOT_LIST));
	}

	private void viewLoadRackList(Object rList){
		if (rList instanceof Vector<?>) {
			cbRack.setModel(new DefaultComboBoxModel((Vector<String>) rList));
		} else {
			System.out.println("Loading Rack List not in Vector form");
		}
	}
	
	private void viewCreditOperation(Object credit){
		if(credit instanceof CreditModel){
			CreditModel myCredit = (CreditModel) credit;
			lblCreditOperation.setText("Material added to "+myCredit.getLocation().getGodown()+" >> "+ myCredit.getLocation().getRack());
			cbGrade.requestFocus();
		}
		
	}
}
