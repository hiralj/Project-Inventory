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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class DebitView extends AbstractViewPane {

	private static final long serialVersionUID = 1L;
	private DefaultPresenter presenter;
	private JPanel debitPanel;
	private JComboBox cbGrade;
	private JComboBox cbShape;
	private JComboBox cbSize;
	private JComboBox cbSize2;
	private JComboBox cbQuality;
	private JButton btnGetInventory;
	private JLabel lblMaterialSelected;
	private JScrollPane scrollPaneInventory;
	private JTable inventoryTable;
	String grade;
	String shape;
	float size;
	float size2;
	String quality;

	/**
	 * Launch the application.
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
	public DebitView() {
		initialize();
	}
	
	public void setPresenter(DefaultPresenter presenter){
		this.presenter = presenter;
	}
	
	public JPanel getDebitPanel(){
		return debitPanel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		debitPanel = new JPanel();	
		
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
		
		JButton btnDebit = new JButton("Debit");
		btnDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callSelectionDebit();
			}
		});
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callSelectionTransfer();
			}
		});
		
		JButton btnNil = new JButton("Nil");
		btnNil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callSelectionNil();
			}
		});
		
		GroupLayout gl_debitPanel = new GroupLayout(debitPanel);
		gl_debitPanel.setHorizontalGroup(
			gl_debitPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_debitPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_debitPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMaterialSelected)
						.addGroup(gl_debitPanel.createSequentialGroup()
							.addComponent(lblQuality)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnGetInventory))
						.addGroup(gl_debitPanel.createSequentialGroup()
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
						.addComponent(scrollPaneInventory, GroupLayout.PREFERRED_SIZE, 693, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_debitPanel.createSequentialGroup()
							.addComponent(btnDebit, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNil, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_debitPanel.setVerticalGroup(
			gl_debitPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_debitPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_debitPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrade)
						.addComponent(cbGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShape)
						.addComponent(cbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize)
						.addComponent(cbSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize2)
						.addComponent(cbSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_debitPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_debitPanel.createSequentialGroup()
							.addGroup(gl_debitPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuality)
								.addComponent(cbQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblMaterialSelected))
						.addComponent(btnGetInventory))
					.addGap(18)
					.addComponent(scrollPaneInventory, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(gl_debitPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDebit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_debitPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNil, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		
		
		debitPanel.setLayout(gl_debitPanel);
	}

	@Override
	public void initOnTabSelection(){
		System.out.println("Debit Selected");
		loadGradeList();
		viewLoadQualityList();
		cbGrade.requestFocus();
		scrollPaneInventory.setVisible(false);
		lblMaterialSelected.setText("");
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
	
	private void loadInventory(){
		Object gradeName = cbGrade.getSelectedItem();
		Object shapeName = cbShape.getSelectedItem();
		Object sizeNum = cbSize.getSelectedItem();
		Object size2Num = cbSize2.getSelectedItem();
		Object qualityName = cbQuality.getSelectedItem();
		if(gradeName != null && shapeName != null && sizeNum != null && qualityName != null){
			grade = gradeName.toString();
			shape = shapeName.toString();
			/*
			 * Size if not null will be Float for sure since it comes from database.
			 */
			size = Float.parseFloat(sizeNum.toString());

			size2 = 0; 
			if(shape.equals("Flat")){
				if(size2Num != null){
					size2 = Float.parseFloat(size2Num.toString());
				} else{
					//TODO NOT PROPER SELECTION
				}
			} 
			quality = qualityName.toString();
			viewLabelMaterialSelected(grade, shape, size, size2, quality);
			presenter.getInventory(grade, shape, size, size2, quality);
		} else{
			//TODO NOT PROPER SELECTION
		}
		
	}
	
	private void callSelectionDebit(){
		SelectionDebit selectionDebit = new SelectionDebit(this);
		selectionDebit.execute();
	}
	
	private void callSelectionTransfer(){
		SelectionTransfer selectionTransfer = new SelectionTransfer(this);
		selectionTransfer.execute();
	}
	
	public void makeDebitOperation(int row, int qty, float wt, int length, String party, float rate){
		
		int tableRowCount = inventoryTable.getRowCount();
		if(tableRowCount > 1){
			tableRowCount--;
		}
		if(row <= tableRowCount && row > 0){
			row--;
			String root = inventoryTable.getValueAt(row, 0).toString();
			String make = inventoryTable.getValueAt(row, 1).toString();
			String godown = inventoryTable.getValueAt(row, 2).toString();
			String rack = inventoryTable.getValueAt(row, 3).toString();
			int actualLength = Integer.parseInt(inventoryTable.getValueAt(row, 6).toString());
			
			presenter.makeDebitOperation(grade, shape, size, size2, quality, root, make, wt, qty, length, actualLength, godown, rack, party, rate);
			loadInventory();
		}
		
	}
	
	public void makeTransferOperation(int row, int qty, float wt, String newGodown, String newRack){
		int tableRowCount = inventoryTable.getRowCount();
		if(tableRowCount > 1){
			tableRowCount--;
		}
		if(row <= tableRowCount && row > 0){
			row--;
			String root = inventoryTable.getValueAt(row, 0).toString();
			String make = inventoryTable.getValueAt(row, 1).toString();
			String godown = inventoryTable.getValueAt(row, 2).toString();
			String rack = inventoryTable.getValueAt(row, 3).toString();
			int length = Integer.parseInt(inventoryTable.getValueAt(row, 6).toString());
			
			presenter.makeTransferOperation(grade, shape, size, size2, quality, root, make, wt, qty, length, godown, rack, newGodown, newRack);
			loadInventory();
		}
	}
	
	private void callSelectionNil(){
		String rowString = JOptionPane.showInputDialog("Enter Row No.: ");
		try {
			int row = Integer.parseInt(rowString);
			int tableRowCount = inventoryTable.getRowCount();
			if(tableRowCount > 1){
				tableRowCount--;
			}
			if(row <= tableRowCount){
				//MAKE NILL OPERATION
				
				row--;
				String root = inventoryTable.getValueAt(row, 0).toString();
				String make = inventoryTable.getValueAt(row, 1).toString();
				String godown = inventoryTable.getValueAt(row, 2).toString();
				String rack = inventoryTable.getValueAt(row, 3).toString();
				int length = Integer.parseInt(inventoryTable.getValueAt(row, 6).toString());
				
				presenter.makeNillOperation(grade, shape, size, size2, quality, root, make, length, godown, rack);
				loadInventory();
			} else{
				JOptionPane.showMessageDialog(null, "Row must be less then or equal to "+tableRowCount);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Enter number as row");
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
			
//			tableModel = loadDebitComponent(tableModel);
			
			inventoryTable.setModel(tableModel);
			
			scrollPaneInventory.setVisible(true);			
			
		} else{
			System.out.println("Loading Inventory not a DefaultTableModel");
		}
	}
}

//class ButtonRenderer extends JButton implements TableCellRenderer {
//
//	  public ButtonRenderer() {
//	    setOpaque(true);
//	  }
//
//	  public Component getTableCellRendererComponent(JTable table, Object value,
//	      boolean isSelected, boolean hasFocus, int row, int column) {
////	    if (isSelected) {
////	      setForeground(table.getSelectionForeground());
////	      setBackground(table.getSelectionBackground());
////	    } else {
////	      setForeground(table.getForeground());
////	      setBackground(UIManager.getColor("Button.background"));
////	    }
//	    setText(value == null ? "" : value.toString());
//	    return this;
//	  }
//	}

//class DebitButtonEditor extends DefaultCellEditor{
//
//	private static final long serialVersionUID = 1L;
//	
//	private JButton button;
//	
//	public DebitButtonEditor(JCheckBox arg0) {
//		super(arg0);
//		button = new JButton();
//	}
//	
//	@Override
//	public Component getTableCellEditorComponent(JTable arg0, Object arg1,
//			boolean arg2, int arg3, int arg4) {
//		if (arg1 != null){
//			button.setText(arg1.toString());			
//		}
//		final int row = arg3;
//		final int col = arg4;
//		final Object o = arg1;
////		button.addActionListener(new ActionListener() {
////			
////			@Override
////			public void actionPerformed(ActionEvent arg0) {
////				JOptionPane.showMessageDialog(null, col+" " + o);
////			}
////		});
//		return button;
//	}
//	
//	
//	
//}