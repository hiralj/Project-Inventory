package inventory.view;

import inventory.presenter.DefaultPresenter;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class InventoryView extends AbstractViewPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultPresenter presenter;
	private JPanel inventoryPanel;
	private JComboBox cbGrade;
	private JComboBox cbShape;
	private JComboBox cbSize;
	private JComboBox cbSize2;
	private JComboBox cbQuality;
	private JButton btnGetInventory;
	private JLabel lblMaterialSelected;
	private JScrollPane scrollPaneInventory;
	private JTable inventoryTable;
	private DefaultComboBoxModel comboModel;

	/**
	 * Only to help in rendering to Design View
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryView() {
		initialize();
	}
	
	public void setPresenter(DefaultPresenter presenter){
		this.presenter = presenter;
	}
	
	public JPanel getInventoryPanel(){
		return inventoryPanel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		comboModel = new DefaultComboBoxModel();
		inventoryPanel = new JPanel();	
		
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
		
		JLabel lblSize2 = new JLabel("Size2: ");
		
		cbSize2 = new JComboBox();
		
		JLabel lblQuality = new JLabel("Quality: ");
		
		cbQuality = new JComboBox();
		
		lblMaterialSelected = new JLabel("Material");
		lblMaterialSelected.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnGetInventory = new JButton("Get Inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadInventory();
			}
		});
		inventoryTable = new JTable();
		inventoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		inventoryTable.setSize(new Dimension(400, 200));
		inventoryTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		inventoryTable.setVisible(true);
		inventoryTable.setFillsViewportHeight(true);
		scrollPaneInventory = new JScrollPane(inventoryTable);
		scrollPaneInventory.setSize(new Dimension(300, 100));
		
		GroupLayout gl_inventoryPanel = new GroupLayout(inventoryPanel);
		gl_inventoryPanel.setHorizontalGroup(
			gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inventoryPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMaterialSelected)
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addComponent(lblQuality)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnGetInventory))
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addComponent(lblGrade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblShape)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSize)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSize2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneInventory, GroupLayout.PREFERRED_SIZE, 693, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_inventoryPanel.setVerticalGroup(
			gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inventoryPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrade)
						.addComponent(cbGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShape)
						.addComponent(cbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize)
						.addComponent(cbSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize2)
						.addComponent(cbSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inventoryPanel.createSequentialGroup()
							.addGroup(gl_inventoryPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuality)
								.addComponent(cbQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblMaterialSelected))
						.addComponent(btnGetInventory))
					.addGap(18)
					.addComponent(scrollPaneInventory, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		
		
		
		inventoryPanel.setLayout(gl_inventoryPanel);
	}

	@Override
	public void initOnTabSelection(){		
		loadGradeList();
		viewLoadQualityList();
		cbGrade.requestFocus();
		scrollPaneInventory.setVisible(false);
		lblMaterialSelected.setText("");
//		cbShape.setModel(comboModel);
//		cbSize.setModel(comboModel);
//		cbSize2.setModel(comboModel);
	}
	
	private void loadGradeList(){
		// Dont know why foll. code produces NullPointerException!!
		/* No Exception when called after the tab is selected using StateChanged event of JTabbedPane */
		presenter.loadGradeList();		
	}
	
	/**
	 * Executed when Grade is selected
	 */	
	private void loadShapeList(){
		presenter.loadShapeList(cbGrade.getSelectedItem().toString());
	}
	
	/**
	 * Executed when Shape is selected
	 */
	private void loadSizeList(){
		Object shape = cbShape.getSelectedItem();
		if(shape != null){
			String shapeName = shape.toString();
			if(shapeName.equals("Flat")){
				cbSize2.setEnabled(true);
			} else{
				cbSize2.setEnabled(false);
			}
			presenter.loadSizeList(cbGrade.getSelectedItem().toString(), cbShape.getSelectedItem().toString());
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
	
	private void loadInventory(){
		Object gradeName = cbGrade.getSelectedItem();
		Object shapeName = cbShape.getSelectedItem();
		Object sizeNum = cbSize.getSelectedItem();
		Object size2Num = cbSize2.getSelectedItem();
		Object qualityName = cbQuality.getSelectedItem();
		if(gradeName != null && shapeName != null && sizeNum != null && qualityName != null){
			String grade = gradeName.toString();
			String shape = shapeName.toString();
			/*
			 * Size if not null will be Float for sure since it comes from database.
			 */
			float size = Float.parseFloat(sizeNum.toString());

			float size2 = 0; 
			if(shape.equals("Flat")){
				if(size2Num != null){
					size2 = Float.parseFloat(size2Num.toString());
				} else{
					//TODO NOT PROPER SELECTION
				}
			} 
			String quality = qualityName.toString();
			viewLabelMaterialSelected(grade, shape, size, size2, quality);
			presenter.getInventory(grade, shape, size, size2, quality);
		} else{
			//TODO NOT PROPER SELECTION
		}
		
	}
	
	@Override
	public void modelPropertyChange(PropertyChangeEvent evt){
		if(evt.getPropertyName().equals(DefaultPresenter.INFO_GRADELIST_PROPERTY)){
			viewLoadGradeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_SHAPELIST_PROPERTY)){
			viewLoadShapeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(
				DefaultPresenter.INFO_SIZELIST_PROPERTY)) {
			viewLoadSizeList(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_SIZE2LIST_PROPERTY)){
			viewLoadSize2List(evt.getNewValue());
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_INVENTORY_PROPERTY)){
			viewLoadInventoryTable(evt.getNewValue());
		}
	}
	
	private void viewLoadGradeList(Object gList){
		if (gList instanceof Vector<?>) {
			cbGrade.setModel(new DefaultComboBoxModel((Vector<String>) gList));
		} else {
			System.out.println("Loading Grade List not in Vector form");
		}
	}
	
	private void viewLoadShapeList(Object sList){
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
	
	private void viewLoadSize2List(Object sList){
		if (sList instanceof Vector<?>) {
			cbSize2.setModel(new DefaultComboBoxModel((Vector<Float>) sList));
		} else {
			System.out.println("Loading Size2 List not in Vector form");
		}
	}
	
	private void viewLoadQualityList(){
		cbQuality.setModel(new DefaultComboBoxModel(DefaultPresenter.QUALITY_LIST));
	}
	
	private void viewLabelMaterialSelected(String grade, String shape, Float size, Float size2, String quality){
		StringBuilder sb = new StringBuilder(grade+ " " + shape + " ");
		if(shape.equals("Square")){
			if(size == Math.round(size)){
				sb.append(size.intValue()+"x"+size.intValue()+" mm ");
			} else{
				sb.append(size+"x"+size+" mm ");
			}
		} else if (shape.equals("Flat")){
			if(size == Math.round(size)){
				sb.append(size.intValue()+"x");
			} else{
				sb.append(size+"x");
			}
			
			if(size2 == Math.round(size2)){
				sb.append(size2.intValue()+" mm ");
			} else{
				sb.append(size2+" mm ");
			}			
		} else{
			if(size == Math.round(size)){
				sb.append(size.intValue()+" mm ");
			}
			else{
				sb.append(size+" mm ");
			}
		}
		sb.append(quality);			
		lblMaterialSelected.setText(sb.toString());
	}
	
	private void viewLoadInventoryTable(Object inventoryTableModel){
		if(inventoryTableModel instanceof DefaultTableModel){
			DefaultTableModel tableModel = (DefaultTableModel)inventoryTableModel;
			/* Way 1 */
//			JScrollPane scrollPane = new JScrollPane(new JTable(tableModel));
//			scrollPane.setVisible(true);
//			scrollPane.setSize(500, 500);
//			scrollPane.setLocation(100, 100);
//			inventoryPanel.add(scrollPane);
			
			/* Way 2 */
//			JTable showInventoryTable = new JTable(tableModel);
//			showInventoryTable.setVisible(true);
//			showInventoryTable.setFillsViewportHeight(true);
//			showInventoryTable.setForeground(Color.BLACK);
//			showInventoryTable.setBackground(Color.WHITE);
//			scrollPaneInventory.add(showInventoryTable);
//			scrollPaneInventory.setVisible(true);
//			scrollPaneInventory.setSize(300, 300);
			
			inventoryTable.setModel(tableModel);
			scrollPaneInventory.setVisible(true);			
			
		} else{
			System.out.println("Loading Inventory not a DefaultTableModel");
		}
	}
}
