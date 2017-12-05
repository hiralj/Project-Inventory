package inventory.view;

import inventory.dao.JdbcLocation;

import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionTransfer {

	private JFrame frame;
	private JTextField txtRow;
	private JTextField txtQty;
	private JTextField txtWt;
	private JComboBox cbNewGodown;
	private JComboBox cbNewRack;
	private DebitView debitView;

	/**
	 * Launch the application.
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame.setVisible(true);
					txtRow.requestFocus();
					Vector<String> godownList = JdbcLocation.getAllGodowns();
					cbNewGodown.setModel(new DefaultComboBoxModel(godownList));					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectionTransfer(DebitView debitView) {
		this.debitView = debitView;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 400, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblRow = new JLabel("Row: ");
		
		txtRow = new JTextField();
		txtRow.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtRow.selectAll();
			}
		});
		txtRow.setText("1");
		txtRow.setColumns(10);
		
		JLabel lblQty = new JLabel("Qty: ");
		
		txtQty = new JTextField();
		txtQty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtQty.selectAll();
			}
		});
		txtQty.setText("0");
		txtQty.setColumns(10);
		
		JLabel lblWt = new JLabel("Wt: ");
		
		txtWt = new JTextField();
		txtWt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtWt.selectAll();
			}
		});
		txtWt.setText("0");
		txtWt.setColumns(10);
		
		JLabel lblNewGodown = new JLabel("New Godown: ");
		
		cbNewGodown = new JComboBox();
		cbNewGodown.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				loadRackList();
			}
		});
		cbNewGodown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadRackList();
			}
		});
		
		JLabel lblNewRack = new JLabel("New Rack: ");
		
		cbNewRack = new JComboBox();
		
		JButton btnMakeTransfer = new JButton("Make Transfer");
		btnMakeTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeTransferOperation();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewRack)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbNewRack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewGodown)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbNewGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQty)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnMakeTransfer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblWt)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtWt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(290, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRow)
						.addComponent(txtRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQty)
						.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWt)
						.addComponent(txtWt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewGodown)
						.addComponent(cbNewGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewRack)
						.addComponent(cbNewRack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnMakeTransfer)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void loadRackList(){
		Vector<String> rackList = null;
		Object godownObject = cbNewGodown.getSelectedItem();
		if(godownObject != null){
			String godown = godownObject.toString();
			try {
				rackList = JdbcLocation.getAllRacks(godown);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cbNewRack.setModel(new DefaultComboBoxModel(rackList));
		}
	}
	
	private void makeTransferOperation(){
		try {
			int row = Integer.parseInt(txtRow.getText());
			int qty = Integer.parseInt(txtQty.getText());
			float wt = Float.parseFloat(txtWt.getText());
			String newGodown = cbNewGodown.getSelectedItem().toString();
			String newRack = cbNewRack.getSelectedItem().toString();
			
			debitView.makeTransferOperation(row, qty, wt, newGodown, newRack);
			frame.dispose();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Enter data in correct format");
			txtRow.requestFocus();
		}
	}
}
