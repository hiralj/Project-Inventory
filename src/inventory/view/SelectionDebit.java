package inventory.view;

import inventory.dao.JdbcParty;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionDebit {

	private JFrame frame;
	private JTextField txtQty;
	private JTextField txtWt;
	private JTextField txtLength;
	private JTextField txtParty;
	private JTextField txtRate;
	private JLabel lblParty;
	private JList listParty;
	private JButton btnMakeDebit;
	private DebitView debitView;
	private JLabel lblRow;
	private JTextField txtRow;

	/**
	 * Launch the application.
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame.setVisible(true);
					txtRow.requestFocus();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectionDebit(DebitView debitView) {
		this.debitView = debitView;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 400, 642, 360);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		
		JLabel lblWeight = new JLabel("Weight: ");
		
		txtWt = new JTextField();
		txtWt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtWt.selectAll();
			}
		});
		txtWt.setText("0");
		txtWt.setColumns(10);
		
		JLabel lblLength = new JLabel("Length: ");
		
		txtLength = new JTextField();
		txtLength.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtLength.selectAll();
			}
		});
		txtLength.setText("0");
		txtLength.setColumns(10);		
		
		lblParty = new JLabel("Party: ");
		
		txtParty = new JTextField();
		txtParty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				getPossibleParty();
			}
		});
		txtParty.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate: ");
		
		txtRate = new JTextField();
		txtRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtRate.selectAll();
			}
		});
		txtRate.setText("0");
		txtRate.setColumns(10);
		listParty = new JList();
		listParty.setVisible(false);
		listParty.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				viewPartySelected();
			}
		});
		
		btnMakeDebit = new JButton("Make Debit");
		btnMakeDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeDebitOperation();
			}
		});
		
		lblRow = new JLabel("Row: ");
		
		txtRow = new JTextField();
		txtRow.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtRow.selectAll();
			}
		});
		txtRow.setText("1");
		txtRow.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblQty)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblParty)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtParty, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLength)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblWeight)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtWt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRate)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnMakeDebit, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
							.addGap(109))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(177)))
					.addComponent(listParty, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(listParty, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRow)
								.addComponent(txtRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQty)
								.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWeight)
								.addComponent(txtWt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLength)
								.addComponent(txtLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblParty)
								.addComponent(txtParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRate)
								.addComponent(txtRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addComponent(btnMakeDebit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void viewPartySelected(){
		
		txtParty.setText(listParty.getSelectedValue().toString());
	}
	
	private void getPossibleParty(){
		String [] partyList = null;
		try {
			partyList = JdbcParty.getParty(txtParty.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listParty.setVisible(true);
		listParty.setListData(partyList);
	}
	
	private void makeDebitOperation(){
		try {
			int row = Integer.parseInt(txtRow.getText().toString());
			int qty = Integer.parseInt(txtQty.getText().toString());
			float wt = Float.parseFloat(txtWt.getText().toString());
			int length = Integer.parseInt(txtLength.getText().toString());
			String party = txtParty.getText().toString();
			float rate = Float.parseFloat(txtRate.getText().toString());
			
			debitView.makeDebitOperation(row, qty, wt, length, party, rate);
			frame.dispose();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Enter data in proper format");
			txtRow.requestFocus();
		}				
	}
}

