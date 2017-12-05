package inventory.view;

import inventory.presenter.DefaultPresenter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class MasterView extends AbstractViewPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtNewGrade;
	private DefaultPresenter presenter;
	private JLabel lblGradeAdded;
	private JComboBox icbGradeList;
	private JTabbedPane tabbedPane;
	private JTextField itxtSize;
	private JTextField itxtSize2;
	private JComboBox icbShape;
	private JTextField itxtNewGodown;
	private JTextField itxtRack;
	private JComboBox icbGodown;
	private JTextField itxtMake;
	private JTextArea itxtAreaDetails;
	private Map<String, AbstractViewPane> tabMap;

	/**
	 * Launch the application.
	 */
	public void createView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					initOnTabSelection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MasterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void setPresenter(DefaultPresenter presenter) {
		this.presenter = presenter;
	}

	public void addPanel(JPanel panel, String panelName, AbstractViewPane view){
		tabbedPane.addTab(panelName, null, panel, null);
		tabMap.put(panelName, view);
	}
	
	@Override
	public void initOnTabSelection() {
		loadGradeList();
		loadGodownList();		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabMap = new HashMap<String, AbstractViewPane>();
		

		JPanel initializationTab = new JPanel();
		tabbedPane.addTab("Initialize", null, initializationTab, null);
//		tabbedPane.addTab("Credit", null, new CreditView().getCreditPanel(), null);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				/* Get object of the class whose panel is selected on tab change */
				Object tabObject = tabMap.get(tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
				if(tabObject != null){
					System.out.println(tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
					((AbstractViewPane)tabObject).initOnTabSelection();
				} else{
					initOnTabSelection();
				}
			}
		});				

		JLabel lblNewGrade = new JLabel("New Grade :");
		lblNewGrade.setHorizontalAlignment(SwingConstants.CENTER);

		txtNewGrade = new JTextField();
		txtNewGrade.setHorizontalAlignment(SwingConstants.LEFT);
		txtNewGrade.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtNewGrade.setAlignmentY(Component.TOP_ALIGNMENT);
		txtNewGrade.setColumns(10);

		JButton ibtnNewGrade = new JButton("Add");
		ibtnNewGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNewGrade.getText() != null
						|| !txtNewGrade.getText().equals("")) {
					createNewGrade(txtNewGrade.getText());
				}
			}
		});

		
		

		JLabel lblAddMaterial = new JLabel("Add Material :-");
		lblAddMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel ilblGrade = new JLabel("Grade: ");
		ilblGrade.setHorizontalAlignment(SwingConstants.CENTER);

		icbGradeList = new JComboBox();
		
		JLabel ilblShape = new JLabel("Shape: ");
		
		icbShape = new JComboBox();
		icbShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewInitToggleSize2();
			}
		});
		icbShape.setModel(new DefaultComboBoxModel(new String[] {"Round", "Flat", "Square", "Hex"}));
		
		JLabel ilblSize = new JLabel("Size: ");
		
		itxtSize = new JTextField();
		itxtSize.setColumns(10);
		
		JLabel ilblSize2 = new JLabel("Size2:  ");
		
		itxtSize2 = new JTextField();
		itxtSize2.setEnabled(false);
		itxtSize2.setColumns(10);
		
		JButton ibtnNewMaterial = new JButton("Add");
		ibtnNewMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewMaterial();
			}
		});
		
		lblGradeAdded = new JLabel("");
		
		JLabel ilblAddGodown = new JLabel("Add Godown :-");
		ilblAddGodown.setHorizontalAlignment(SwingConstants.CENTER);
		ilblAddGodown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel ilblNewGodown = new JLabel("New Godown:  ");
		ilblNewGodown.setHorizontalAlignment(SwingConstants.CENTER);
		
		itxtNewGodown = new JTextField();
		itxtNewGodown.setColumns(10);
		
		JButton ibtnNewGodown = new JButton("Add");
		ibtnNewGodown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewGodown();
			}
		});
		
		JLabel ilblAddLocation = new JLabel("Add Location :-");
		ilblAddLocation.setHorizontalAlignment(SwingConstants.CENTER);
		ilblAddLocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel ilblGodown = new JLabel("Godown:  ");
		ilblGodown.setHorizontalAlignment(SwingConstants.CENTER);
		
		icbGodown = new JComboBox();
		
		JLabel ilblRack = new JLabel("Rack:   ");
		ilblRack.setHorizontalAlignment(SwingConstants.CENTER);
		
		itxtRack = new JTextField();
		itxtRack.setColumns(10);
		
		JButton ibtnNewLocation = new JButton("Add");
		ibtnNewLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewLocation();
			}
		});
		
		JLabel ilblAddMake = new JLabel("Add Make :-");
		ilblAddMake.setHorizontalAlignment(SwingConstants.CENTER);
		ilblAddMake.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel ilblMakeName = new JLabel("Make Name: ");
		
		itxtMake = new JTextField();
		itxtMake.setColumns(10);
		
		JLabel lblDetails = new JLabel("Details: ");
		
		itxtAreaDetails = new JTextArea();
		itxtAreaDetails.setBackground(Color.WHITE);
		itxtAreaDetails.setTabSize(30);
		itxtAreaDetails.setLineWrap(true);
		itxtAreaDetails.setColumns(60);
		itxtAreaDetails.setRows(3);
		
		JButton ibtnNewMake = new JButton("Add");
		ibtnNewMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewMake();
			}
		});
		

		GroupLayout gl_initializationTab = new GroupLayout(initializationTab);
		gl_initializationTab.setHorizontalGroup(
			gl_initializationTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_initializationTab.createSequentialGroup()
					.addGroup(gl_initializationTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_initializationTab.createSequentialGroup()
							.addGap(31)
							.addComponent(ilblGrade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(icbGradeList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ilblShape)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(icbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ilblSize)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(itxtSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ilblSize2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(itxtSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(ibtnNewMaterial, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_initializationTab.createSequentialGroup()
							.addGroup(gl_initializationTab.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_initializationTab.createSequentialGroup()
									.addContainerGap(122, Short.MAX_VALUE)
									.addGroup(gl_initializationTab.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_initializationTab.createSequentialGroup()
											.addComponent(lblNewGrade)
											.addGap(18)
											.addComponent(txtNewGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
											.addGroup(gl_initializationTab.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblGradeAdded)
												.addGroup(gl_initializationTab.createSequentialGroup()
													.addComponent(ibtnNewGrade)
													.addGap(31))))
										.addGroup(gl_initializationTab.createSequentialGroup()
											.addGroup(gl_initializationTab.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_initializationTab.createParallelGroup(Alignment.LEADING)
													.addComponent(ilblAddLocation, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
													.addComponent(ilblAddGodown, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
													.addComponent(ilblAddMake, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_initializationTab.createSequentialGroup()
														.addGap(10)
														.addComponent(ilblMakeName)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(itxtMake, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addComponent(ilblNewGodown, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
											.addGroup(gl_initializationTab.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_initializationTab.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(itxtNewGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(ibtnNewGodown, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_initializationTab.createSequentialGroup()
													.addGap(39)
													.addComponent(lblDetails)
													.addGap(18)
													.addComponent(itxtAreaDetails, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_initializationTab.createSequentialGroup()
											.addComponent(ilblRack, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(itxtRack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblAddMaterial, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_initializationTab.createSequentialGroup()
									.addGap(120)
									.addComponent(ilblGodown, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(icbGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(34)
							.addGroup(gl_initializationTab.createParallelGroup(Alignment.TRAILING)
								.addComponent(ibtnNewLocation, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(ibtnNewMake))))
					.addGap(194))
		);
		gl_initializationTab.setVerticalGroup(
			gl_initializationTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_initializationTab.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_initializationTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_initializationTab.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_initializationTab.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewGrade)
								.addComponent(txtNewGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ibtnNewGrade)))
						.addGroup(gl_initializationTab.createSequentialGroup()
							.addGap(5)
							.addComponent(lblGradeAdded)))
					.addGap(18)
					.addComponent(lblAddMaterial, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_initializationTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(ilblGrade)
						.addComponent(icbGradeList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ilblShape)
						.addComponent(icbShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ilblSize)
						.addComponent(itxtSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ilblSize2)
						.addComponent(itxtSize2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ibtnNewMaterial))
					.addGap(18)
					.addComponent(ilblAddGodown, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_initializationTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(itxtNewGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ibtnNewGodown)
						.addComponent(ilblNewGodown))
					.addGap(21)
					.addComponent(ilblAddLocation, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_initializationTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(ilblGodown)
						.addComponent(icbGodown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ibtnNewLocation)
						.addComponent(itxtRack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ilblRack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(42)
					.addComponent(ilblAddMake, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_initializationTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(ilblMakeName)
						.addComponent(itxtMake, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDetails)
						.addComponent(itxtAreaDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ibtnNewMake))
					.addGap(435))
		);
		initializationTab.setLayout(gl_initializationTab);
		initializationTab.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ilblGrade, ilblShape, icbGradeList, icbShape, ilblSize, itxtSize, ilblSize2, itxtSize2, ibtnNewMaterial, lblNewGrade, txtNewGrade, lblGradeAdded, ibtnNewGrade, ilblAddLocation, ilblAddGodown, ilblAddMake, ilblMakeName, itxtMake, ilblNewGodown, itxtNewGodown, ibtnNewGodown, lblDetails, itxtAreaDetails, ilblRack, itxtRack, lblAddMaterial, ilblGodown, icbGodown, ibtnNewLocation, ibtnNewMake}));
	}

	private void createNewGrade(String gradeName) {
		presenter.createNewGrade(gradeName);
	}

	private void loadGradeList() {
		presenter.loadGradeList();
		// cbGradeList.setModel(new DefaultComboBoxModel(gradeList));
	}
	
	private void loadGodownList(){
		presenter.loadGodownList();
	}
	
	private void createNewMaterial(){
		String gradeName = icbGradeList.getSelectedItem().toString();
		String shapeName = icbShape.getSelectedItem().toString();
		float sizeNum = 0, size2Num = 0;
		try {
			sizeNum = Float.parseFloat(itxtSize.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		if(itxtSize2.isEnabled()){
			try {
				size2Num = Float.parseFloat(itxtSize2.getText());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		presenter.createNewMaterial(gradeName, shapeName, sizeNum, size2Num);
		itxtSize.setText("");
		itxtSize.requestFocus();
	}
	
	private void createNewGodown(){		
		presenter.createNewGodown(itxtNewGodown.getText());
	}
	
	private void createNewLocation(){
		String godown = icbGodown.getSelectedItem().toString();
		String rack = itxtRack.getText();
		presenter.createNewLocation(godown, rack);
	}
	
	private void createNewMake(){
		String makeName = itxtMake.getText();
		String details = itxtAreaDetails.getText();
		presenter.createNewMake(makeName, details);
	}

	@Override
	public void modelPropertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getPropertyName().equals(DefaultPresenter.GSS_GRADE_PROPERTY)) {
			lblGradeAdded.setText(evt.getNewValue().toString() + " added");
			txtNewGrade.setText("");
			txtNewGrade.requestFocus();
			loadGradeList();
		} else if (evt.getPropertyName().equals(DefaultPresenter.LOCATION_GODOWN_PROPERTY)){
			itxtNewGodown.setText("");
			itxtNewGodown.requestFocus();
			loadGodownList();
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_GRADELIST_PROPERTY)) {								
				viewLoadGradeList(evt.getNewValue());						
		} else if (evt.getPropertyName().equals(DefaultPresenter.INFO_GODOWNLIST_PROPERTY)){
			viewLoadGodownList(evt.getNewValue());
		} else if(evt.getPropertyName().equals(DefaultPresenter.LOCATION_PROPERTY)){
			itxtRack.setText("");
			itxtRack.requestFocus();
		} else if(evt.getPropertyName().equals(DefaultPresenter.MAKE_PROPERTY)){
			itxtMake.setText("");
			itxtAreaDetails.setText("");
			itxtMake.requestFocus();
		}
		
	}
	
	private void viewLoadGradeList(Object gList){
		Vector<String> gradeList = null;
		if(gList instanceof Vector<?>){
			gradeList = (Vector<String>) gList;
			icbGradeList.setModel(new DefaultComboBoxModel(gradeList));
		} else{
			System.out.println("Loading Grade List not in Vector form");
		}		
	}
	
	private void viewLoadGodownList(Object gList){
		Vector<String> godownList = null;
		if(gList instanceof Vector<?>){
			godownList = (Vector<String>) gList;
			icbGodown.setModel(new DefaultComboBoxModel(godownList));
		} else{
			System.out.println("Loading Godown List not in Vector form");
		}
		
	}
	
	private void viewInitToggleSize2(){
		if(icbShape.getSelectedItem().toString().equals("Flat")){
			itxtSize2.setEnabled(true);
		} else{
			itxtSize2.setEnabled(false);
		}
	}
}
