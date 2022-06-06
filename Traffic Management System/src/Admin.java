import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Diversion.Diversion;
import Emergency.Emergency;
import Login.UserData;
import Route.Route;
import TrafficPolice.Traffic;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.JTextArea;

public class Admin {

	private JFrame TrafficManagementSystem;
	
	static DefaultTableModel traffic = new DefaultTableModel();
	static JTable trafficTable = new JTable();
	private JTextField trafficID;
	private JTextField trafficFirstname;
	private JTextField trafficSurname;
	private JTextField trafficUsername;
	private JTextField trafficPassword;
	
	static DefaultTableModel route = new DefaultTableModel();
	static JTable routeTable = new JTable();
	
	static DefaultTableModel emergency = new DefaultTableModel();
	static JTable emergencyTable = new JTable();
	
	static DefaultTableModel userData = new DefaultTableModel();
	static JTable userDataTable = new JTable();
	
	private JTextField routeID;
	private JTextField routeName;
	private JTextField routeLength;
	private JTextField routeInformation;
	
	static DefaultTableModel diversion = new DefaultTableModel();
	static JTable diversionTable = new JTable();
	private JTextField diversionID;
	private JTextField diversionName;
	private JTextField diversionDescription;
	private JTextField diversionRoute;
	private JTextField diversionDate;
	
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.TrafficManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	



	public Admin() {
		initialize();
		createTrafficColumns();
		createRouteColumns();
		createDiversionColumns();
		createEmergencyColumns();
		createUserDataColumns();
		
		displayTraffic();
		displayRoute();
		displayDiversion();
		displayEmergency();
		displayUserData();
		TrafficManagementSystem.setVisible(true);
		
	}

	private void initialize() {
		TrafficManagementSystem = new JFrame();
		TrafficManagementSystem.setBounds(100, 100, 1100, 535);
		TrafficManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TrafficManagementSystem.getContentPane().setLayout(null);
		TrafficManagementSystem.setLocationRelativeTo(null);
		TrafficManagementSystem.setResizable(false);
		
		Panel sidePanel = new Panel();
		sidePanel.setBackground(new Color(0, 153, 153));
		sidePanel.setBounds(0, 0, 188, 513);
		TrafficManagementSystem.getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setBounds(65, 6, 58, 44);
		lblTitle.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-police-48.png")));
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setBackground(new Color(0, 128, 128));
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		sidePanel.add(lblTitle);
		
		JLabel manageTrafficLabel = new JLabel("  Manage Traffic Police");
		manageTrafficLabel.setHorizontalAlignment(SwingConstants.LEFT);
		manageTrafficLabel.setBackground(new Color(0, 153, 153));
		manageTrafficLabel.setForeground(Color.WHITE);
		manageTrafficLabel.setBounds(7, 169, 180, 44);
		manageTrafficLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-management-24.png")));
		manageTrafficLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		sidePanel.add(manageTrafficLabel);
		manageTrafficLabel.setOpaque(true);
		manageTrafficLabel.isOpaque();
		
		
				
		JLabel heading = new JLabel("Traffic Management System");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(Color.WHITE);
		heading.setBackground(Color.WHITE);
		heading.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		heading.setBounds(6, 62, 179, 39);
		sidePanel.add(heading);
		
		JLabel dashboardLabel = new JLabel("   Dashboard");
		dashboardLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dashboardLabel.setForeground(Color.WHITE);
		dashboardLabel.setBackground(new Color(0, 153, 153));
		dashboardLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-user-menu-male-25.png")));
		dashboardLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		dashboardLabel.setBounds(7, 113, 180, 44);
		sidePanel.add(dashboardLabel);
		dashboardLabel.setOpaque(true);
		dashboardLabel.isOpaque();
		
		
		JLabel manageRouteLabel = new JLabel("  Manage Route");
		manageRouteLabel.setBackground(new Color(0, 153, 153));
		manageRouteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		manageRouteLabel.setForeground(Color.WHITE);
		manageRouteLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-police-car-25.png")));
		manageRouteLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		manageRouteLabel.setBounds(6, 225, 180, 44);
		sidePanel.add(manageRouteLabel);
		manageRouteLabel.setOpaque(true);
		manageRouteLabel.isOpaque();
		
		JLabel manageDiversionLabel = new JLabel("  Manage Diversion");
		manageDiversionLabel.setBackground(new Color(0, 153, 153));
		manageDiversionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		manageDiversionLabel.setForeground(Color.WHITE);
		manageDiversionLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-traffic-jam-25.png")));
		manageDiversionLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		manageDiversionLabel.setBounds(6, 281, 180, 44);
		sidePanel.add(manageDiversionLabel);
		manageDiversionLabel.setOpaque(true);
		
		JLabel emergencyRequest = new JLabel("  Emergency Request\n");
		emergencyRequest.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-hospital-wagon-without-a-siren-25.png")));
		emergencyRequest.setOpaque(true);
		emergencyRequest.setHorizontalAlignment(SwingConstants.LEFT);
		emergencyRequest.setForeground(Color.WHITE);
		emergencyRequest.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		emergencyRequest.setBackground(new Color(0, 153, 153));
		emergencyRequest.setBounds(7, 338, 180, 44);
		sidePanel.add(emergencyRequest);
		
		JLabel usersInformationLabel = new JLabel("   Users Information");
		usersInformationLabel.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-user-group-25.png")));
		usersInformationLabel.setOpaque(true);
		usersInformationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usersInformationLabel.setForeground(Color.WHITE);
		usersInformationLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		usersInformationLabel.setBackground(new Color(0, 153, 153));
		usersInformationLabel.setBounds(7, 394, 180, 44);
		sidePanel.add(usersInformationLabel);
		
		JLabel adminLogout = new JLabel("   Logout");
		adminLogout.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-logout-rounded-down-25.png")));
		adminLogout.setOpaque(true);
		adminLogout.setHorizontalAlignment(SwingConstants.LEFT);
		adminLogout.setForeground(Color.WHITE);
		adminLogout.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		adminLogout.setBackground(new Color(0, 153, 153));
		adminLogout.setBounds(7, 450, 180, 44);
		sidePanel.add(adminLogout);
		manageDiversionLabel.isOpaque();
		
		
		Panel mainPanel = new Panel();
		mainPanel.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		mainPanel.setBackground(new Color(192, 192, 192));
		mainPanel.setBounds(189, 0, 911, 513);
		TrafficManagementSystem.getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		
		Panel trafficPolicePanel = new Panel();
		trafficPolicePanel.setBackground(new Color(0, 51, 102));
		mainPanel.add(trafficPolicePanel);
		trafficPolicePanel.setLayout(null);
		
		trafficTable = new JTable();
		trafficTable.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		trafficTable.setBorder(new CompoundBorder());
		trafficTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane = new JScrollPane(trafficTable);
		scrollPane.setBounds(0, 0, 697, 513);
		trafficPolicePanel.add(scrollPane);
		scrollPane.setViewportView(trafficTable);
		
		
		
		JLabel trfID = new JLabel("ID Number");
		trfID.setForeground(Color.WHITE);
		trfID.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		trfID.setBounds(709, 27, 81, 26);
		trafficPolicePanel.add(trfID);
		
		
		trafficID = new JTextField();
		trafficID.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		trafficID.setBounds(709, 65, 176, 26);
		trafficPolicePanel.add(trafficID);
		trafficID.setColumns(10);
		
		JLabel trfFirstname = new JLabel("Firstname");
		trfFirstname.setForeground(Color.WHITE);
		trfFirstname.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		trfFirstname.setBounds(709, 94, 81, 26);
		trafficPolicePanel.add(trfFirstname);
		
		trafficFirstname = new JTextField();
		trafficFirstname.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		trafficFirstname.setColumns(10);
		trafficFirstname.setBounds(709, 121, 176, 26);
		trafficPolicePanel.add(trafficFirstname);
		
		JLabel trfSurname = new JLabel("Surname");
		trfSurname.setForeground(Color.WHITE);
		trfSurname.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		trfSurname.setBounds(709, 146, 81, 26);
		trafficPolicePanel.add(trfSurname);
		
		trafficSurname = new JTextField();
		trafficSurname.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		trafficSurname.setColumns(10);
		trafficSurname.setBounds(709, 173, 176, 26);
		trafficPolicePanel.add(trafficSurname);
		
		JLabel trfUsername = new JLabel("Username");
		trfUsername.setForeground(Color.WHITE);
		trfUsername.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		trfUsername.setBounds(711, 211, 81, 26);
		trafficPolicePanel.add(trfUsername);
		
		trafficUsername = new JTextField();
		trafficUsername.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		trafficUsername.setColumns(10);
		trafficUsername.setBounds(709, 236, 176, 26);
		trafficPolicePanel.add(trafficUsername);
		
		trafficPassword = new JTextField();
		trafficPassword.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		trafficPassword.setColumns(10);
		trafficPassword.setBounds(709, 304, 176, 26);
		trafficPolicePanel.add(trafficPassword);
		
		JLabel trfPassword = new JLabel("Password");
		trfPassword.setForeground(Color.WHITE);
		trfPassword.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		trfPassword.setBounds(711, 274, 81, 26);
		trafficPolicePanel.add(trfPassword);
		
		JButton addTraffic = new JButton("Add");
		addTraffic.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		addTraffic.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-add-administrator-20.png")));
		addTraffic.setBounds(709, 359, 182, 29);
		trafficPolicePanel.add(addTraffic);
		
		JButton editTraffic = new JButton("Edit");
		editTraffic.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		editTraffic.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-edit-account-20.png")));
		editTraffic.setBounds(709, 400, 182, 29);
		trafficPolicePanel.add(editTraffic);
		
		JButton deleteTraffic = new JButton("Delete");
		deleteTraffic.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		deleteTraffic.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-denied-20.png")));
		deleteTraffic.setBounds(709, 441, 182, 29);
		trafficPolicePanel.add(deleteTraffic);
		

		
		Panel routePanel = new Panel();
		routePanel.setBackground(new Color(0, 51, 102));
		mainPanel.add(routePanel);
		routePanel.setLayout(null);
		
		routeTable = new JTable();
		routeTable.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		routeTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane_1 = new JScrollPane(routeTable);
		scrollPane_1.setBounds(0, 0, 697, 513);
		routePanel.add(scrollPane_1);
		scrollPane_1.setViewportView(routeTable);
		
		JLabel routeIDLabel = new JLabel("Route ID");
		routeIDLabel.setForeground(Color.WHITE);
		routeIDLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		routeIDLabel.setBounds(709, 19, 180, 30);
		routePanel.add(routeIDLabel);
		
		routeID = new JTextField();
		routeID.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		routeID.setBounds(709, 50, 180, 39);
		routePanel.add(routeID);
		routeID.setColumns(10);
		
		JLabel routeNameLabel = new JLabel("Route Name");
		routeNameLabel.setForeground(Color.WHITE);
		routeNameLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		routeNameLabel.setBounds(709, 101, 180, 30);
		routePanel.add(routeNameLabel);
		
		routeName = new JTextField();
		routeName.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		routeName.setColumns(10);
		routeName.setBounds(709, 136, 180, 39);
		routePanel.add(routeName);
		
		JLabel routeLengthLabel = new JLabel("Route Length");
		routeLengthLabel.setForeground(Color.WHITE);
		routeLengthLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		routeLengthLabel.setBounds(709, 289, 180, 30);
		routePanel.add(routeLengthLabel);
		
		routeLength = new JTextField();
		routeLength.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		routeLength.setColumns(10);
		routeLength.setBounds(709, 324, 180, 39);
		routePanel.add(routeLength);
		
		JLabel routeInformationLabel = new JLabel("Route Information");
		routeInformationLabel.setForeground(Color.WHITE);
		routeInformationLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		routeInformationLabel.setBounds(709, 187, 180, 30);
		routePanel.add(routeInformationLabel);
		
		routeInformation = new JTextField();
		routeInformation.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		routeInformation.setColumns(10);
		routeInformation.setBounds(709, 216, 180, 61);
		routePanel.add(routeInformation);
		
		JButton addRoute = new JButton("Add");
		addRoute.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		addRoute.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-plus-20.png")));
		addRoute.setBounds(709, 385, 182, 29);
		routePanel.add(addRoute);
		
		JButton editRoute = new JButton("Edit");
		editRoute.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		editRoute.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-edit-20.png")));
		editRoute.setBounds(709, 426, 182, 29);
		routePanel.add(editRoute);
		
		JButton deleteRoute = new JButton("Delete");
		deleteRoute.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		deleteRoute.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-minus-20.png")));
		deleteRoute.setBounds(709, 467, 182, 29);
		routePanel.add(deleteRoute);
				
		Panel diversionPanel = new Panel();
		diversionPanel.setBackground(new Color(0, 51, 102));
		mainPanel.add(diversionPanel);
		diversionPanel.setLayout(null);
		
		diversionTable = new JTable();
		diversionTable.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		diversionTable.setBorder(new CompoundBorder());
		diversionTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane_2 = new JScrollPane(diversionTable);
		scrollPane_2.setBounds(0, 0, 697, 513);
		diversionPanel.add(scrollPane_2);
		scrollPane_2.setViewportView(diversionTable);
		
		JLabel diversionIDLabel = new JLabel("Diversion ID");
		diversionIDLabel.setForeground(Color.WHITE);
		diversionIDLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		diversionIDLabel.setBounds(709, 34, 180, 19);
		diversionPanel.add(diversionIDLabel);
		
		diversionID = new JTextField();
		diversionID.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		diversionID.setColumns(10);
		diversionID.setBounds(709, 65, 180, 25);
		diversionPanel.add(diversionID);
		
		JLabel diversionNameLabel = new JLabel("Diversion Name");
		diversionNameLabel.setForeground(Color.WHITE);
		diversionNameLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		diversionNameLabel.setBounds(709, 170, 180, 19);
		diversionPanel.add(diversionNameLabel);
		
		diversionName = new JTextField();
		diversionName.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		diversionName.setColumns(10);
		diversionName.setBounds(709, 201, 180, 25);
		diversionPanel.add(diversionName);
		
		JLabel diversionDescriptionLabel = new JLabel("Diversion Description");
		diversionDescriptionLabel.setForeground(Color.WHITE);
		diversionDescriptionLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		diversionDescriptionLabel.setBounds(709, 306, 180, 19);
		diversionPanel.add(diversionDescriptionLabel);
		
		diversionDescription = new JTextField();
		diversionDescription.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		diversionDescription.setColumns(10);
		diversionDescription.setBounds(709, 337, 180, 35);
		diversionPanel.add(diversionDescription);
		
		JLabel diversionRouteLabel = new JLabel("Diversion Route");
		diversionRouteLabel.setForeground(Color.WHITE);
		diversionRouteLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		diversionRouteLabel.setBounds(709, 238, 180, 19);
		diversionPanel.add(diversionRouteLabel);
		
		diversionRoute = new JTextField();
		diversionRoute.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		diversionRoute.setColumns(10);
		diversionRoute.setBounds(709, 269, 180, 25);
		diversionPanel.add(diversionRoute);
		
		JButton addDiversion = new JButton("Add");
		addDiversion.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		addDiversion.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-plus-20.png")));
		addDiversion.setBounds(709, 384, 182, 29);
		diversionPanel.add(addDiversion);
		
		JButton editDiversion = new JButton("Edit");
		editDiversion.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		editDiversion.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-edit-20.png")));
		editDiversion.setBounds(709, 425, 182, 29);
		diversionPanel.add(editDiversion);
		
		JButton deleteDiversion = new JButton("Delete");
		deleteDiversion.setFont(new Font("Apple Chancery", Font.BOLD, 15));
		deleteDiversion.setIcon(new ImageIcon(Admin.class.getResource("/Images/icons8-minus-20.png")));
		deleteDiversion.setBounds(709, 466, 182, 29);
		diversionPanel.add(deleteDiversion);
		
		JLabel diversionDateLabel = new JLabel("Diversion Date");
		diversionDateLabel.setForeground(Color.WHITE);
		diversionDateLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		diversionDateLabel.setBounds(709, 102, 180, 19);
		diversionPanel.add(diversionDateLabel);
		
		diversionDate = new JTextField();
		diversionDate.setFont(new Font("Bodoni 72", Font.PLAIN, 13));
		diversionDate.setColumns(10);
		diversionDate.setBounds(709, 133, 180, 25);
		diversionPanel.add(diversionDate);
		
		
		Panel emergencyRequestPanel = new Panel();
		mainPanel.add(emergencyRequestPanel);
		emergencyRequestPanel.setLayout(null);
		
		emergencyTable = new JTable();
		emergencyTable.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		emergencyTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane_3 = new JScrollPane(emergencyTable);
		scrollPane_3.setBounds(0, 0, 911, 513);
		emergencyRequestPanel.add(scrollPane_3);
		scrollPane_3.setViewportView(emergencyTable);
		
		Panel userDataPanel = new Panel();
		mainPanel.add(userDataPanel);
		userDataPanel.setLayout(null);
		
		userDataTable = new JTable();
		userDataTable.setFont(new Font("Apple Chancery", Font.BOLD, 13));
		userDataTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane_4 = new JScrollPane(userDataTable);
		scrollPane_4.setBounds(0, 0, 911, 513);
		userDataPanel.add(scrollPane_4);
		scrollPane_4.setViewportView(userDataTable);
		
		dashboardLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				mainPanel.setVisible(true);
				trafficPolicePanel.setVisible(false);
				routePanel.setVisible(false);
				diversionPanel.setVisible(false);
				emergencyRequestPanel.setVisible(false);
				userDataPanel.setVisible(false);
				
				setLabelColor(dashboardLabel, manageDiversionLabel, manageRouteLabel, manageTrafficLabel, emergencyRequest, usersInformationLabel); 
				resetLabelColor(manageRouteLabel,manageDiversionLabel,manageTrafficLabel,emergencyRequest,usersInformationLabel);
			}
				private void resetLabelColor(JLabel manageRouteLabel, JLabel manageDiversionLabel,JLabel manageTrafficLabel, JLabel emergencyRequest,JLabel usersInformationLabel) {
				
				manageTrafficLabel.setBackground(new Color(0, 153,153));
				manageRouteLabel.setBackground(new Color(0, 153,153));
				manageDiversionLabel.setBackground(new Color(0, 153,153));
				emergencyRequest.setBackground(new Color(0, 153,153));
				usersInformationLabel.setBackground(new Color(0, 153,153));
			}
			

		});
		
		
		usersInformationLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.setVisible(true);
				trafficPolicePanel.setVisible(false);
				routePanel.setVisible(false);
				emergencyRequestPanel.setVisible(false);
				userDataPanel.setVisible(true);
				setLabelColor(manageTrafficLabel, manageDiversionLabel, manageRouteLabel, dashboardLabel, emergencyRequest,usersInformationLabel); 
				resetLabelColor(manageRouteLabel,manageDiversionLabel,dashboardLabel,emergencyRequest,manageTrafficLabel);
			}
				private void resetLabelColor(JLabel manageRouteLabel, JLabel manageDiversionLabel,JLabel dashboardLabel, JLabel emergencyRequest, JLabel manageTrafficLabel) {
				
				dashboardLabel.setBackground(new Color(0, 153,153));
				manageTrafficLabel.setBackground(new Color(0, 153,153));
				manageRouteLabel.setBackground(new Color(0, 153,153));
				manageDiversionLabel.setBackground(new Color(0, 153,153));
				emergencyRequest.setBackground(new Color(0, 153,153));
			}


		});

		
		manageTrafficLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.setVisible(true);
				trafficPolicePanel.setVisible(true);
				routePanel.setVisible(false);
				userDataPanel.setVisible(false);
				setLabelColor(manageTrafficLabel, manageDiversionLabel, manageRouteLabel, dashboardLabel, emergencyRequest, usersInformationLabel); 
				resetLabelColor(manageRouteLabel,manageDiversionLabel,dashboardLabel,emergencyRequest,usersInformationLabel);
			}
				private void resetLabelColor(JLabel manageRouteLabel, JLabel manageDiversionLabel,JLabel dashboardLabel, JLabel emergencyRequest, JLabel usersInformationLabel) {
				
				dashboardLabel.setBackground(new Color(0, 153,153));
				manageRouteLabel.setBackground(new Color(0, 153,153));
				manageDiversionLabel.setBackground(new Color(0, 153,153));
				emergencyRequest.setBackground(new Color(0, 153,153));
				usersInformationLabel.setBackground(new Color(0, 153,153));
			}


		});
		
		manageRouteLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.setVisible(true);
				trafficPolicePanel.setVisible(false);
				routePanel.setVisible(true);
				userDataPanel.setVisible(false);
				setLabelColor(manageRouteLabel,manageTrafficLabel , dashboardLabel, manageDiversionLabel,emergencyRequest, usersInformationLabel);
				resetLabelColor(dashboardLabel,manageDiversionLabel,manageTrafficLabel,emergencyRequest, usersInformationLabel);
			}

			private void resetLabelColor(JLabel dashboardLabel, JLabel manageDiversionLabel,JLabel manageTrafficLabel,JLabel emergencyRequest, JLabel usersInformationLabel) {
				
				manageTrafficLabel.setBackground(new Color(0, 153,153));
				manageDiversionLabel.setBackground(new Color(0, 153,153));
				dashboardLabel.setBackground(new Color(0, 153,153));
				emergencyRequest.setBackground(new Color(0, 153,153));
				usersInformationLabel.setBackground(new Color(0, 153,153));

			}
		});
		manageDiversionLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.setVisible(true);
				trafficPolicePanel.setVisible(false);
				routePanel.setVisible(false);
				diversionPanel.setVisible(true);
				userDataPanel.setVisible(false);
				setLabelColor(manageTrafficLabel, manageDiversionLabel, manageRouteLabel, dashboardLabel,emergencyRequest,usersInformationLabel); 				
				resetLabelColor(manageRouteLabel,dashboardLabel,manageTrafficLabel,emergencyRequest, usersInformationLabel);
			}
				private void resetLabelColor(JLabel manageRouteLabel, JLabel dashboardLabel,JLabel manageTrafficLabel, JLabel emergencyRequest, JLabel usersInformationLabel) {
				
				manageTrafficLabel.setBackground(new Color(0, 153,153));
				manageRouteLabel.setBackground(new Color(0, 153,153));
				dashboardLabel.setBackground(new Color(0, 153,153));
				emergencyRequest.setBackground(new Color(0, 153,153));
				usersInformationLabel.setBackground(new Color(0, 153,153));
			}
		});
		
		emergencyRequest.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainPanel.setVisible(true);
				trafficPolicePanel.setVisible(false);
				routePanel.setVisible(false);
				diversionPanel.setVisible(false);
				emergencyRequestPanel.setVisible(true);
				userDataPanel.setVisible(false);
				setLabelColor(manageTrafficLabel, manageDiversionLabel, manageRouteLabel, dashboardLabel,emergencyRequest,usersInformationLabel); 				
				resetLabelColor(manageRouteLabel,dashboardLabel,manageTrafficLabel,manageDiversionLabel,usersInformationLabel);
			}
				private void resetLabelColor(JLabel manageRouteLabel, JLabel dashboardLabel,JLabel manageTrafficLabel, JLabel manageDiversionLabel, JLabel usersInformationLabel) {
				
				manageTrafficLabel.setBackground(new Color(0, 153,153));
				manageRouteLabel.setBackground(new Color(0, 153,153));
				dashboardLabel.setBackground(new Color(0, 153,153));
				manageDiversionLabel.setBackground(new Color(0, 153,153));
				usersInformationLabel.setBackground(new Color(0, 153,153));
			}
		});
		
		adminLogout.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				TrafficManagementSystem.dispose();
				Login Log = new Login();
				

			}

		});
		
		addTraffic.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) 
		{
			addTraffic();
			populate(trafficID.getText(), trafficFirstname.getText(), trafficSurname.getText(), trafficUsername.getText(), trafficPassword.getText());
			
		
			trafficID.setText("");
			trafficFirstname.setText("");
			trafficSurname.setText("");
			trafficUsername.setText("");
			trafficPassword.setText("");
			
		}
	});

addRoute.addActionListener(new ActionListener() 
{
	public void actionPerformed(ActionEvent e) 
	{
		addRoute();
		populate1(routeID.getText(), routeName.getText(), routeInformation.getText(), routeLength.getText());
		
	
		routeID.setText("");
		routeName.setText("");
		routeInformation.setText("");
		routeLength.setText("");
		
	}
});
		
		editTraffic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				editTraffic((String)traffic.getValueAt(trafficTable.getSelectedRow(), 0), trafficID.getText(), trafficFirstname.getText(), trafficSurname.getText(), trafficUsername.getText(), trafficPassword.getText());
				
				traffic.setValueAt(trafficID.getText(), trafficTable.getSelectedRow(), 0);
				traffic.setValueAt(trafficFirstname.getText(), trafficTable.getSelectedRow(), 1);
				traffic.setValueAt(trafficSurname.getText(), trafficTable.getSelectedRow(), 2);
				traffic.setValueAt(trafficUsername.getText(), trafficTable.getSelectedRow(), 3);
				traffic.setValueAt(trafficPassword.getText(), trafficTable.getSelectedRow(), 4);
				
				trafficID.setText("");
				trafficFirstname.setText("");
				trafficSurname.setText("");
				trafficUsername.setText("");
				trafficPassword.setText("");

			}
		});
		
		editRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				editRoute((String)route.getValueAt(routeTable.getSelectedRow(), 0), routeID.getText(), routeName.getText(), routeInformation.getText(), routeLength.getText());
				
				route.setValueAt(routeID.getText(), routeTable.getSelectedRow(), 0);
				route.setValueAt(routeName.getText(), routeTable.getSelectedRow(), 1);
				route.setValueAt(routeInformation.getText(), routeTable.getSelectedRow(), 2);
				route.setValueAt(routeLength.getText(), routeTable.getSelectedRow(), 3);
			
				routeID.setText("");
				routeName.setText("");
				routeInformation.setText("");
				routeLength.setText("");


			}

		});
		
		deleteTraffic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTraffic((String)traffic.getValueAt(trafficTable.getSelectedRow(), 0));
				traffic.removeRow(trafficTable.getSelectedRow());
				
				trafficID.setText("");
				trafficFirstname.setText("");
				trafficSurname.setText("");
				trafficUsername.setText("");
				trafficPassword.setText("");

			}
		});
		
		deleteRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeRoute((String)route.getValueAt(routeTable.getSelectedRow(), 0));
				route.removeRow(routeTable.getSelectedRow());
				
				routeID.setText("");
				routeName.setText("");
				routeInformation.setText("");
				routeLength.setText("");

			}
		});
		
		addDiversion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addDiversion();
				populate2(diversionID.getText(),diversionDate.getText(), diversionName.getText(),diversionRoute.getText(), diversionDescription.getText());
				
			
				diversionID.setText("");
				diversionDate.setText("");
				diversionName.setText("");
				diversionRoute.setText("");
				diversionDescription.setText("");
				
			}
		});
		
		editDiversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				editDiversion((String)diversion.getValueAt(diversionTable.getSelectedRow(), 0), diversionID.getText(),diversionDate.getText(), diversionName.getText(), diversionRoute.getText(), diversionDescription.getText());
				diversion.setValueAt(diversionID.getText(), diversionTable.getSelectedRow(), 0);
				diversion.setValueAt(diversionDate.getText(), diversionTable.getSelectedRow(), 1);
				diversion.setValueAt(diversionName.getText(), diversionTable.getSelectedRow(), 2);
				diversion.setValueAt(diversionRoute.getText(), diversionTable.getSelectedRow(), 3);
				diversion.setValueAt(diversionDescription.getText(), diversionTable.getSelectedRow(), 4);
			
				diversionID.setText("");
				diversionDate.setText("");
				diversionName.setText("");
				diversionRoute.setText("");
				diversionDescription.setText("");


			}

		});
		
		deleteDiversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeDiversion((String)diversion.getValueAt(diversionTable.getSelectedRow(), 0));
				diversion.removeRow(diversionTable.getSelectedRow());
				
				diversionID.setText("");
				diversionDate.setText("");
				diversionName.setText("");
				diversionRoute.setText("");
				diversionDescription.setText("");

			}
		});
		
		
		
		trafficTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				trafficID.setText(trafficTable.getValueAt(trafficTable.getSelectedRow(), 0).toString());
				trafficFirstname.setText(trafficTable.getValueAt(trafficTable.getSelectedRow(), 1).toString());
				trafficSurname.setText(trafficTable.getValueAt(trafficTable.getSelectedRow(), 2).toString());
				trafficUsername.setText(trafficTable.getValueAt(trafficTable.getSelectedRow(), 3).toString());
				trafficPassword.setText(trafficTable.getValueAt(trafficTable.getSelectedRow(), 4).toString());
			}
		});
		
		routeTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				routeID.setText(routeTable.getValueAt(routeTable.getSelectedRow(), 0).toString());
				routeName.setText(routeTable.getValueAt(routeTable.getSelectedRow(), 1).toString());
				routeInformation.setText(routeTable.getValueAt(routeTable.getSelectedRow(), 2).toString());
				routeLength.setText(routeTable.getValueAt(routeTable.getSelectedRow(), 3).toString());

			}
		});
		
		diversionTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				diversionID.setText(diversionTable.getValueAt(diversionTable.getSelectedRow(), 0).toString());
				diversionDate.setText(diversionTable.getValueAt(diversionTable.getSelectedRow(), 1).toString());
				diversionName.setText(diversionTable.getValueAt(diversionTable.getSelectedRow(), 2).toString());
				diversionRoute.setText(diversionTable.getValueAt(diversionTable.getSelectedRow(), 3).toString());
				diversionDescription.setText(diversionTable.getValueAt(diversionTable.getSelectedRow(), 4).toString());
				

			}
		});
		



	}
	//End of Initialization
	
	private void setLabelColor(JLabel manageTrafficLabel, JLabel dashboardLabel, JLabel manageRouteLabel, JLabel manageDiversionLabel, JLabel emergencyLabel, JLabel userInformationLabel) {
		
		manageTrafficLabel.setBackground(new Color(24, 195, 226));
		manageRouteLabel.setBackground(new Color(24, 195, 226));
		manageDiversionLabel.setBackground(new Color(24, 195, 226));
		dashboardLabel.setBackground(new Color(24, 195, 226));
		emergencyLabel.setBackground(new Color(24, 195, 226));
		userInformationLabel.setBackground(new Color(24, 195, 226));
	}


	public void createTrafficColumns() {
		
		traffic = (DefaultTableModel) trafficTable.getModel();
		
		traffic.addColumn("ID");
		traffic.addColumn("Firstname");
		traffic.addColumn("Surname");
		traffic.addColumn("Username");
		traffic.addColumn("Password");
		
	}
	
	public void createRouteColumns() {
		
		route = (DefaultTableModel) routeTable.getModel();
		
		route.addColumn("Route ID");
		route.addColumn("Route name");
		route.addColumn("Route Information");
		route.addColumn("Route Length");
		
	}
	
	public void createDiversionColumns() {
		
		diversion = (DefaultTableModel) diversionTable.getModel();
		
		diversion.addColumn("Diversion ID");
		diversion.addColumn("Diversion Date");
		diversion.addColumn("Diversion name");
		diversion.addColumn("Diversion Route");
		diversion.addColumn("Diversion Description");

		
	}
	
	public void createEmergencyColumns() {
		
		emergency = (DefaultTableModel) emergencyTable.getModel();
		
		emergency.addColumn("Date");
		emergency.addColumn("Name");
		emergency.addColumn("Phone Number");
		emergency.addColumn("Travelling From");
		emergency.addColumn("Travelling To");
		emergency.addColumn("Vehicle Number");
		emergency.addColumn("Emergency Detail");

		
	}
	
	public void createUserDataColumns() {
		
		userData = (DefaultTableModel) userDataTable.getModel();
		
		userData.addColumn("Name");
		userData.addColumn("Address");
		userData.addColumn("Phone Number");
		userData.addColumn("Username");
		userData.addColumn("Password");

	}
	
	
	private void populate(String id, String firstname, String surname, String username, String password) {
		String[] rowData = {id, firstname, surname, username, password};
		traffic.addRow(rowData);
	}
	
	private void populate1(String routeid, String routename, String routeinformation, String routelength) {
		String[] rowData = {routeid, routename, routeinformation, routelength};
		route.addRow(rowData);
	}
	
	private void populate2(String diversionid, String diversiondate, String diversionname, String diversionroute,String diversiondescription) {
		String[] rowData = {diversionid, diversiondate, diversionname,  diversionroute, diversiondescription};
		diversion.addRow(rowData);
	}
	
	
	public void addTraffic() {
		
		ArrayList<Traffic> rd = new ArrayList<>();
		ObjectInputStream osr;
			try { 
				try {
					osr = new ObjectInputStream(new FileInputStream("Traffic.dat"));
					ArrayList<Traffic> obj;
					while ((obj=(ArrayList<Traffic>)osr.readObject())!=null) {
						for (int i = 0; i < obj.size(); i++) {
							rd.add(new Traffic(obj.get(i).getId(), obj.get(i).getFirstname(), obj.get(i).getSurname(), obj.get(i).getUsername(), obj.get(i).getPassword()));
						}
					}
					osr.close();
				} catch (EOFException e) {
					System.out.println("File Ends Here..");
				} catch (FileNotFoundException e) { 
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			rd.add(new Traffic(trafficID.getText(),trafficFirstname.getText(), trafficSurname.getText(), trafficUsername.getText(), trafficPassword.getText()));
			ObjectOutputStream os1;
			os1 = new ObjectOutputStream(new FileOutputStream("Traffic.dat"));
			os1.writeObject(rd);
			
		    System.out.println("Information Recorded Successfully");   
			os1.close();
				
		} catch (EOFException e) {
				System.out.println("The file ends here..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public void displayTraffic() {
		ArrayList<Traffic> trf = readTraffic();
    	for(int i = 0; i< trf.size(); i++) {
    		traffic.addRow(new String[] {trf.get(i).getId(), trf.get(i).getFirstname(),trf.get(i).getSurname(),trf.get(i).getUsername(), trf.get(i).getPassword()});
    	}
	}
	
	public ArrayList<Traffic> readTraffic() {
		
		ArrayList<Traffic> rd = new ArrayList<Traffic>(); 
		ObjectInputStream OI1;
	
		try {
			OI1 = new ObjectInputStream(new FileInputStream("Traffic.dat"));
			ArrayList<Traffic> trf = null;
			while((trf =  (ArrayList<Traffic>) OI1.readObject())!= null) {
				rd = trf;
			}
			OI1.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (EOFException e) {
			System.out.println("The Traffic data is loaded into the system..");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rd;
	}
	
	
	public void editTraffic(String editrow, String id, String firstname, String surname, String username, String password) {
		
		ArrayList<Traffic> rd = new ArrayList<>();
		ObjectInputStream osr;
			try { 
				try {
					osr = new ObjectInputStream(new FileInputStream("Traffic.dat"));
					ArrayList<Traffic> obj;
					while ((obj=(ArrayList<Traffic>)osr.readObject())!=null) {
						for (int i = 0; i < obj.size(); i++) {
							if (editrow.equals(obj.get(i).getId())) {
								rd.add(new Traffic( id, firstname,surname, username, password));
							} else {
								rd.add(new Traffic(obj.get(i).getId(), obj.get(i).getFirstname(), obj.get(i).getSurname(), obj.get(i).getUsername(), obj.get(i).getPassword()));
							}
						}
					}
					osr.close();
				} catch (EOFException e) {
					System.out.println("The file ends here...");
				} catch (FileNotFoundException e) { 
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			ObjectOutputStream os1;
			os1 = new ObjectOutputStream(new FileOutputStream("Traffic.dat"));
			os1.writeObject(rd);
			
		    System.out.println("The information is edited");   
			os1.close();
				
		} catch (EOFException e) {
				System.out.println("End of File...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
public void removeTraffic(String editrow) {
		
		ArrayList<Traffic> rd = new ArrayList<>();
		ObjectInputStream osr;
			try { 
				try {
					osr = new ObjectInputStream(new FileInputStream("Traffic.dat"));
					ArrayList<Traffic> obj;
					while ((obj=(ArrayList<Traffic>)osr.readObject())!=null) {
						for (int i = 0; i < obj.size(); i++) {
							if (!(editrow.equals(obj.get(i).getId()))) {
								rd.add(new Traffic(obj.get(i).getId(), obj.get(i).getFirstname(),obj.get(i).getSurname(), obj.get(i).getUsername(), obj.get(i).getPassword()));
							}
						}
					}
					osr.close();
				} catch (EOFException e) {
					System.out.println("The File ends here.");
				} catch (FileNotFoundException e) { 
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			ObjectOutputStream os1;
			os1 = new ObjectOutputStream(new FileOutputStream("Traffic.dat"));
			os1.writeObject(rd);
			
		    System.out.println("Information is deleted");   
			os1.close();
				
		} catch (EOFException e) {
				System.out.println("The file ends here..");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addRoute() {
		
		ArrayList<Route> rd = new ArrayList<>();
		ObjectInputStream osr;
			try { 
				try {
					osr = new ObjectInputStream(new FileInputStream("Route.dat"));
					ArrayList<Route> obj;
					while ((obj=(ArrayList<Route>)osr.readObject())!=null) {
						for (int i = 0; i < obj.size(); i++) {
							rd.add(new Route(obj.get(i).getRouteid(), obj.get(i).getRoutename(), obj.get(i).getRouteinformation(), obj.get(i).getRoutelength()));
						}
					}
					osr.close();
				} catch (EOFException e) {
					System.out.println("The File Ends Here..");
				} catch (FileNotFoundException e) { 
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			rd.add(new Route(routeID.getText(),routeName.getText(), routeInformation.getText(), routeLength.getText()));
			ObjectOutputStream os1;
			os1 = new ObjectOutputStream(new FileOutputStream("Route.dat"));
			os1.writeObject(rd);
			
		    System.out.println("Route Information Recorded Successfully");   
			os1.close();
				
		} catch (EOFException e) {
				System.out.println("The file ends here..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		public void displayRoute() {
			ArrayList<Route> rout = readRoute();
			for(int i = 0; i< rout.size(); i++) {
				route.addRow(new String[] {rout.get(i).getRouteid(), rout.get(i).getRoutename(),rout.get(i).getRouteinformation(),rout.get(i).getRoutelength()});
			}
		}
		
		public ArrayList<Route> readRoute() {
			
			ArrayList<Route> rd = new ArrayList<Route>(); 
			ObjectInputStream OI1;
		
			try {
				OI1 = new ObjectInputStream(new FileInputStream("Route.dat"));
				ArrayList<Route> rout = null;
				while((rout =  (ArrayList<Route>) OI1.readObject())!= null) {
					rd = rout;
				}
				OI1.close();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			catch (EOFException e) {
				System.out.println("The Route data is loaded into the system..");
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return rd;
		}

		public void editRoute(String editrow, String routeid, String routename, String routeinformation, String routelength) {
			
			ArrayList<Route> rd = new ArrayList<>();
			ObjectInputStream osr;
				try { 
					try {
						osr = new ObjectInputStream(new FileInputStream("Route.dat"));
						ArrayList<Route> obj;
						while ((obj=(ArrayList<Route>)osr.readObject())!=null) {
							for (int i = 0; i < obj.size(); i++) {
								if (editrow.equals(obj.get(i).getRouteid())) {
									rd.add(new Route( routeid, routename,routeinformation, routelength));
								} else {
									rd.add(new Route(obj.get(i).getRouteid(), obj.get(i).getRoutename(), obj.get(i).getRouteinformation(), obj.get(i).getRoutelength()));
								}
							}
						}
						osr.close();
					} catch (EOFException e) {
						System.out.println("The file ends here...");
					} catch (FileNotFoundException e) { 
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
				ObjectOutputStream os1;
				os1 = new ObjectOutputStream(new FileOutputStream("Route.dat"));
				os1.writeObject(rd);
				
			    System.out.println("The information is edited");   
				os1.close();
					
			} catch (EOFException e) {
					System.out.println("End of File...");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void removeRoute(String editrow) {
			
			ArrayList<Route> rd = new ArrayList<>();
			ObjectInputStream osr;
				try { 
					try {
						osr = new ObjectInputStream(new FileInputStream("Route.dat"));
						ArrayList<Route> obj;
						while ((obj=(ArrayList<Route>)osr.readObject())!=null) {
							for (int i = 0; i < obj.size(); i++) {
								if (!(editrow.equals(obj.get(i).getRouteid()))) {
									rd.add(new Route(obj.get(i).getRouteid(), obj.get(i).getRoutename(),obj.get(i).getRouteinformation(), obj.get(i).getRoutelength()));
								}
							}
						}
						osr.close();
					} catch (EOFException e) {
						System.out.println("The File ends here.");
					} catch (FileNotFoundException e) { 
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
				ObjectOutputStream os1;
				os1 = new ObjectOutputStream(new FileOutputStream("Route.dat"));
				os1.writeObject(rd);
				
			    System.out.println("Information is deleted");   
				os1.close();
					
			} catch (EOFException e) {
					System.out.println("The file ends here..");
			} catch (FileNotFoundException e) {
				System.out.println("File not Found...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void addDiversion() {
			
			ArrayList<Diversion> rd = new ArrayList<>();
			ObjectInputStream osr;
				try { 
					try {
						osr = new ObjectInputStream(new FileInputStream("Diversion.dat"));
						ArrayList<Diversion> obj;
						while ((obj=(ArrayList<Diversion>)osr.readObject())!=null) {
							for (int i = 0; i < obj.size(); i++) {
								rd.add(new Diversion(obj.get(i).getDiversionid(),obj.get(i).getDiversiondate(), obj.get(i).getDiversionname(), obj.get(i).getDiversionroute(),obj.get(i).getDiversiondescription()));
							}
						}
						osr.close();
					} catch (EOFException e) {
						System.out.println("The File Ends Here..");
					} catch (FileNotFoundException e) { 
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
				rd.add(new Diversion(diversionID.getText(),diversionDate.getText(),diversionName.getText(), diversionRoute.getText(), diversionDescription.getText()));
				ObjectOutputStream os1;
				os1 = new ObjectOutputStream(new FileOutputStream("Diversion.dat"));
				os1.writeObject(rd);
				
			    System.out.println("Diversion Information Recorded Successfully");   
				os1.close();
					
			} catch (EOFException e) {
					System.out.println("The file ends here..");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void displayDiversion() {
			ArrayList<Diversion> dive = readDiversion();
			for(int i = 0; i< dive.size(); i++) {
				diversion.addRow(new String[] {dive.get(i).getDiversionid(),dive.get(i).getDiversiondate(), dive.get(i).getDiversionname(),dive.get(i).getDiversionroute(),dive.get(i).getDiversiondescription()});
			}
		}

		public ArrayList<Diversion> readDiversion() {
			
			ArrayList<Diversion> rd = new ArrayList<Diversion>(); 
			ObjectInputStream OI1;

			try {
				OI1 = new ObjectInputStream(new FileInputStream("Diversion.dat"));
				ArrayList<Diversion> dive = null;
				while((dive =  (ArrayList<Diversion>) OI1.readObject())!= null) {
					rd = dive;
				}
				OI1.close();
			}
			catch (ClassNotFoundException e) {
				System.out.println("Class not found exception..");
			} 
			catch (EOFException e) {
				System.out.println("The Diversion data is loaded into the system..");
			}catch (FileNotFoundException e) {
				System.out.println("File not found...");
			} catch (IOException e) {
				System.out.println("Input and output exception...");
			}
			return rd;
		}
		
		public void editDiversion(String editrow, String diversionid,String diversiondate, String diversionname, String diversionroute, String diversiondescription) {
			
			ArrayList<Diversion> rd = new ArrayList<>();
			ObjectInputStream osr;
				try { 
					try {
						osr = new ObjectInputStream(new FileInputStream("Diversion.dat"));
						ArrayList<Diversion> obj;
						while ((obj=(ArrayList<Diversion>)osr.readObject())!=null) {
							for (int i = 0; i < obj.size(); i++) {
								if (editrow.equals(obj.get(i).getDiversionid())) {
									rd.add(new Diversion( diversionid,diversiondate, diversionname,diversionroute, diversiondescription));
								} else {
									rd.add(new Diversion(obj.get(i).getDiversionid(),obj.get(i).getDiversiondate(), obj.get(i).getDiversionname(), obj.get(i).getDiversionroute(), obj.get(i).getDiversiondescription()));
								}
							}
						}
						osr.close();
					} catch (EOFException e) {
						System.out.println("The file ends here...");
					} catch (FileNotFoundException e) { 
						System.out.println("File not found...");
					} catch (IOException e) {
						System.out.println("Input and output exception..");
					} catch (ClassNotFoundException e) {
						System.out.println("Class not found exception..");
					}
					
				ObjectOutputStream os1;
				os1 = new ObjectOutputStream(new FileOutputStream("Diversion.dat"));
				os1.writeObject(rd);
				
			    System.out.println("The information is edited");   
				os1.close();
					
			} catch (EOFException e) {
					System.out.println("End of File...");
			} catch (FileNotFoundException e) {
				System.out.println("File not found...");
			} catch (IOException e) {
				System.out.println("Input and output exception..");
			}
		}
		public void removeDiversion(String editrow) {
			
			ArrayList<Diversion> rd = new ArrayList<>();
			ObjectInputStream osr;
				try { 
					try {
						osr = new ObjectInputStream(new FileInputStream("Diversion.dat"));
						ArrayList<Diversion> obj;
						while ((obj=(ArrayList<Diversion>)osr.readObject())!=null) {
							for (int i = 0; i < obj.size(); i++) {
								if (!(editrow.equals(obj.get(i).getDiversionid()))) {
									rd.add(new Diversion(obj.get(i).getDiversionid(), obj.get(i).getDiversiondate(),obj.get(i).getDiversionname(), obj.get(i).getDiversionroute(),obj.get(i).getDiversiondescription()));
								}
							}
						}
						osr.close();
					} catch (EOFException e) {
						System.out.println("The File ends here.");
					} catch (FileNotFoundException e) { 
					System.out.println("File not found....");
					} catch (IOException e) {
						System.out.println("Input and output expection...");
					} catch (ClassNotFoundException e) {
						System.out.println("Class not found.....");
					}
					
				ObjectOutputStream os1;
				os1 = new ObjectOutputStream(new FileOutputStream("Diversion.dat"));
				os1.writeObject(rd);
				
			    System.out.println("Information is deleted");   
				os1.close();
					
			} catch (EOFException e) {
					System.out.println("The file ends here..");
			} catch (FileNotFoundException e) {
				System.out.println("File not Found...");
			} catch (IOException e) {
				System.out.println("Input and output expection...");
			}
		}
		
		public void displayEmergency() {
			ArrayList<Emergency> emer = readEmergency();
			for(int i = 0; i< emer.size(); i++) {
				emergency.addRow(new String[] {emer.get(i).getEmergencydate(),emer.get(i).getEmergencyname(),emer.get(i).getEmergencyphone(), emer.get(i).getTravellingfrom(),emer.get(i).getTravellingto(),emer.get(i).getVehiclenumber(),emer.get(i).getEmergencytype()});
			}
		}

		public ArrayList<Emergency> readEmergency() {
			
			ArrayList<Emergency> rd = new ArrayList<Emergency>(); 
			ObjectInputStream OI1;

			try {
				OI1 = new ObjectInputStream(new FileInputStream("Emergency.dat"));
				ArrayList<Emergency> emer = null;
				while((emer =  (ArrayList<Emergency>) OI1.readObject())!= null) {
					rd = emer;
				}
				OI1.close();
			}
			catch (ClassNotFoundException e) {
				System.out.println("Class not found exception..");
			} 
			catch (EOFException e) {
				System.out.println("The Emergency data is loaded into the system..");
			}catch (FileNotFoundException e) {
				System.out.println("File not found...");
			} catch (IOException e) {
				System.out.println("Input and output exception...");
			}
			return rd;
		}
		
		public void displayUserData() {
			ArrayList<UserData> user = readUserData();
			for(int i = 0; i< user.size(); i++) {
				userData.addRow(new String[] {user.get(i).getName(),user.get(i).getAddress(),user.get(i).getPhonenumber(), user.get(i).getUsername(),user.get(i).getPassword()});
			}
		}

		public ArrayList<UserData> readUserData() {
			
			ArrayList<UserData> rd = new ArrayList<UserData>(); 
			ObjectInputStream OI1;

			try {
				OI1 = new ObjectInputStream(new FileInputStream("Userdata.dat"));
				ArrayList<UserData> user = null;
				while((user =  (ArrayList<UserData>) OI1.readObject())!= null) {
					rd = user;
				}
				OI1.close();
			}
			catch (ClassNotFoundException e) {
				System.out.println("Class not found exception..");
			} 
			catch (EOFException e) {
				System.out.println("The User data is loaded into the system..");
			}catch (FileNotFoundException e) {
				System.out.println("File not found...");
			} catch (IOException e) {
				System.out.println("Input and output exception...");
			}
			return rd;
		}
}
