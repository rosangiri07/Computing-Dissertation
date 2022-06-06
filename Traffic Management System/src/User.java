import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import Diversion.Diversion;
import Emergency.Emergency;
import Route.Route;

import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class User {

	private static JFrame frame;
	
	static DefaultTableModel udiversion = new DefaultTableModel();
	static JTable uDiversionTable = new JTable();
	
	static DefaultTableModel uRoute = new DefaultTableModel();
	static JTable uRouteTable = new JTable();
	
	private static JTable userDiversionTable;
	private static JTable userRouteTable;
	private JTextField emergencyName;
	private JTextField emergencyPhone;
	private JTextField travellingFrom;
	private JTextField travellingTo;
	private JTextField vehicleNumber;
	private JTextField emergencyType;
	private JTextField emergencyDate;
	
	private String user ="";
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public User(String usr) {

		initialize();
		this.user= usr;
		
		createUserDiversionColumns();
		createUserRouteColumns();
		displayDiversion();
		displayRoute();
		
		frame.setVisible(true);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1000, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		Panel userSidePanel = new Panel();
		userSidePanel.setBackground(new Color(0, 51, 102));
		userSidePanel.setBounds(0, 0, 230, 498);
		frame.getContentPane().add(userSidePanel);
		userSidePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Traffic Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		lblNewLabel.setBounds(6, 97, 218, 40);
		userSidePanel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(User.class.getResource("/Images/icons8-user-80.png")));
		label.setForeground(Color.WHITE);
		label.setFont(UIManager.getFont("Label.font"));
		label.setBackground(new Color(0, 51, 102));
		label.setBounds(70, 24, 80, 54);
		userSidePanel.add(label);
		
		JLabel emergencyLabel = new JLabel("Emergency Request");
		emergencyLabel.setIcon(new ImageIcon(User.class.getResource("/Images/icons8-hospital-wagon-without-a-siren-25.png")));
		emergencyLabel.setForeground(Color.WHITE);
		emergencyLabel.setFont(new Font("Bodoni 72", Font.BOLD, 15));
		emergencyLabel.setBackground(new Color(0, 51, 102));
		emergencyLabel.setBounds(6, 166, 218, 40);
		userSidePanel.add(emergencyLabel);
		emergencyLabel.setOpaque(true);
		emergencyLabel.isOpaque();

		
		JLabel viewDiversionLabel = new JLabel("View Diversions");
		viewDiversionLabel.setIcon(new ImageIcon(User.class.getResource("/Images/icons8-traffic-jam-25.png")));
		viewDiversionLabel.setForeground(Color.WHITE);
		viewDiversionLabel.setFont(new Font("Bodoni 72", Font.PLAIN, 15));
		viewDiversionLabel.setBackground(new Color(0, 51, 102));
		viewDiversionLabel.setBounds(6, 230, 218, 40);
		userSidePanel.add(viewDiversionLabel);
		viewDiversionLabel.setOpaque(true);
		viewDiversionLabel.isOpaque();

		
		JLabel viewRoutesLabel = new JLabel("View Routes");
		viewRoutesLabel.setIcon(new ImageIcon(User.class.getResource("/Images/icons8-police-car-25.png")));
		viewRoutesLabel.setForeground(Color.WHITE);
		viewRoutesLabel.setFont(new Font("Bodoni 72", Font.PLAIN, 15));
		viewRoutesLabel.setBackground(new Color(0, 51, 102));
		viewRoutesLabel.setBounds(6, 293, 218, 40);
		userSidePanel.add(viewRoutesLabel);
		viewRoutesLabel.setOpaque(true);
		viewRoutesLabel.isOpaque();
		
		JLabel userLogoutLabel = new JLabel("Logout");
		userLogoutLabel.setIcon(new ImageIcon(User.class.getResource("/Images/icons8-logout-rounded-down-30.png")));
		userLogoutLabel.setForeground(Color.WHITE);
		userLogoutLabel.setFont(new Font("Bodoni 72", Font.PLAIN, 15));
		userLogoutLabel.setBackground(new Color(0, 51, 102));
		userLogoutLabel.setBounds(6, 355, 218, 40);
		userSidePanel.add(userLogoutLabel);
		userLogoutLabel.setOpaque(true);
		userLogoutLabel.isOpaque();
		
		Panel userRightPanel = new Panel();
		userRightPanel.setBounds(230, 0, 770, 498);
		frame.getContentPane().add(userRightPanel);
		userRightPanel.setLayout(new CardLayout(0, 0));
		
		Panel emergencyPanel = new Panel();
		emergencyPanel.setBackground(Color.GRAY);
		userRightPanel.add(emergencyPanel);
		emergencyPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(153, 25, 458, 444);
		emergencyPanel.add(panel);
		panel.setLayout(null);
		
		JLabel emergencyNameLabel = new JLabel("Name");
		emergencyNameLabel.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyNameLabel.setForeground(Color.WHITE);
		emergencyNameLabel.setBackground(Color.WHITE);
		emergencyNameLabel.setBounds(38, 90, 72, 31);
		panel.add(emergencyNameLabel);
		
		JLabel lblEmergencyRequestInformation = new JLabel("Emergency Request Form");
		lblEmergencyRequestInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergencyRequestInformation.setForeground(Color.WHITE);
		lblEmergencyRequestInformation.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		lblEmergencyRequestInformation.setBackground(Color.WHITE);
		lblEmergencyRequestInformation.setBounds(87, 6, 288, 31);
		panel.add(lblEmergencyRequestInformation);
		
		emergencyName = new JTextField();
		emergencyName.setBounds(233, 92, 173, 30);
		panel.add(emergencyName);
		emergencyName.setColumns(10);
		
		emergencyPhone = new JTextField();
		emergencyPhone.setColumns(10);
		emergencyPhone.setBounds(233, 135, 173, 30);
		panel.add(emergencyPhone);
		
		JLabel emergencyPhoneLabel = new JLabel("Phone");
		emergencyPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyPhoneLabel.setForeground(Color.WHITE);
		emergencyPhoneLabel.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyPhoneLabel.setBackground(Color.WHITE);
		emergencyPhoneLabel.setBounds(38, 133, 72, 31);
		panel.add(emergencyPhoneLabel);
		
		travellingFrom = new JTextField();
		travellingFrom.setColumns(10);
		travellingFrom.setBounds(233, 179, 173, 30);
		panel.add(travellingFrom);
		
		JLabel emergencyFromLabel = new JLabel("Travelling From");
		emergencyFromLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyFromLabel.setForeground(Color.WHITE);
		emergencyFromLabel.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyFromLabel.setBackground(Color.WHITE);
		emergencyFromLabel.setBounds(48, 177, 133, 31);
		panel.add(emergencyFromLabel);
		
		JLabel emergencyTo = new JLabel("Travelling To");
		emergencyTo.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyTo.setForeground(Color.WHITE);
		emergencyTo.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyTo.setBackground(Color.WHITE);
		emergencyTo.setBounds(48, 221, 110, 31);
		panel.add(emergencyTo);
		
		travellingTo = new JTextField();
		travellingTo.setColumns(10);
		travellingTo.setBounds(233, 223, 173, 30);
		panel.add(travellingTo);
		
		JLabel emergencyVehicleLabel = new JLabel("Vehicle Number");
		emergencyVehicleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyVehicleLabel.setForeground(Color.WHITE);
		emergencyVehicleLabel.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyVehicleLabel.setBackground(Color.WHITE);
		emergencyVehicleLabel.setBounds(48, 270, 133, 31);
		panel.add(emergencyVehicleLabel);
		
		vehicleNumber = new JTextField();
		vehicleNumber.setColumns(10);
		vehicleNumber.setBounds(233, 272, 173, 30);
		panel.add(vehicleNumber);
		
		JLabel emergencyTypeLabel = new JLabel("Emergency");
		emergencyTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyTypeLabel.setForeground(Color.WHITE);
		emergencyTypeLabel.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyTypeLabel.setBackground(Color.WHITE);
		emergencyTypeLabel.setBounds(48, 314, 98, 31);
		panel.add(emergencyTypeLabel);
		
		emergencyType = new JTextField();
		emergencyType.setColumns(10);
		emergencyType.setBounds(233, 316, 173, 57);
		panel.add(emergencyType);
		
		Panel sendInfoPanel = new Panel();
		sendInfoPanel.setBackground(new Color(0, 0, 102));
		sendInfoPanel.setBounds(48, 392, 358, 31);
		panel.add(sendInfoPanel);
		sendInfoPanel.setLayout(null);
		
		JLabel sendInformation = new JLabel("Send Request");
		sendInformation.setBounds(120, 0, 121, 30);
		sendInformation.setHorizontalAlignment(SwingConstants.CENTER);
		sendInformation.setForeground(Color.WHITE);
		sendInformation.setFont(new Font("Apple Chancery", Font.BOLD, 20));
		sendInformation.setBackground(Color.WHITE);
		sendInfoPanel.add(sendInformation);
		
		emergencyDate = new JTextField();
		emergencyDate.setColumns(10);
		emergencyDate.setBounds(233, 51, 173, 30);
		panel.add(emergencyDate);
		
		JLabel emergencyDateLabel = new JLabel("Date");
		emergencyDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emergencyDateLabel.setForeground(Color.WHITE);
		emergencyDateLabel.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		emergencyDateLabel.setBackground(Color.WHITE);
		emergencyDateLabel.setBounds(38, 49, 57, 31);
		panel.add(emergencyDateLabel);
		

		
		Panel viewDiversionPanel = new Panel();
		viewDiversionPanel.setBackground(Color.LIGHT_GRAY);
		userRightPanel.add(viewDiversionPanel);
		viewDiversionPanel.setLayout(null);
	
		userDiversionTable = new JTable();
		userDiversionTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane = new JScrollPane(userDiversionTable);
		scrollPane.setBounds(0, 0, 770, 498);
		viewDiversionPanel.add(scrollPane);
		scrollPane.setViewportView(userDiversionTable);
	
		Panel viewRoutePanel = new Panel();
		viewRoutePanel.setBackground(Color.LIGHT_GRAY);
		userRightPanel.add(viewRoutePanel);
		viewRoutePanel.setLayout(null);
		
		userRouteTable = new JTable();
		userRouteTable.setBackground(new Color(192, 192, 192));
		JScrollPane scrollPane_1 = new JScrollPane(userRouteTable);
		scrollPane_1.setBounds(0, 0, 770, 498);
		viewRoutePanel.add(scrollPane_1);
		scrollPane_1.setViewportView(userRouteTable);
		

		
		emergencyLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				userRightPanel.setVisible(true);
				emergencyPanel.setVisible(true);
				viewRoutePanel.setVisible(false);
				viewDiversionPanel.setVisible(false);
				setUserLabelColor(emergencyLabel, viewDiversionLabel, viewRoutesLabel, userLogoutLabel); 
				resetUserLabelColor(viewRoutesLabel,viewDiversionLabel,userLogoutLabel);
			}
				private void resetUserLabelColor(JLabel viewRoutesLabel, JLabel viewDiversionLabel,JLabel userLogoutLabel) {
				
				viewRoutesLabel.setBackground(new Color(0, 51,102));
				viewDiversionLabel.setBackground(new Color(0, 51,102));
				userLogoutLabel.setBackground(new Color(0, 51,102));
			}
			

		});
		
		viewDiversionLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				userRightPanel.setVisible(true);
				emergencyPanel.setVisible(false);
				viewRoutePanel.setVisible(false);
				viewDiversionPanel.setVisible(true);
				setUserLabelColor(emergencyLabel, viewDiversionLabel, viewRoutesLabel, userLogoutLabel); 
				resetUserLabelColor(viewRoutesLabel,emergencyLabel,userLogoutLabel);
			}
				private void resetUserLabelColor(JLabel viewRoutesLabel, JLabel emergencyLabel,JLabel userLogoutLabel) {
				
				viewRoutesLabel.setBackground(new Color(0, 51,102));
				emergencyLabel.setBackground(new Color(0, 51,102));
				userLogoutLabel.setBackground(new Color(0, 51,102));
			}
		});
		
		viewRoutesLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				userRightPanel.setVisible(true);
				emergencyPanel.setVisible(false);
				viewRoutePanel.setVisible(true);
				viewDiversionPanel.setVisible(false);
				
				setUserLabelColor(emergencyLabel, viewDiversionLabel, viewRoutesLabel, userLogoutLabel); 
				resetUserLabelColor(viewDiversionLabel,emergencyLabel,userLogoutLabel);
			}
				private void resetUserLabelColor(JLabel viewDiversionLabel, JLabel emergencyLabel,JLabel userLogoutLabel) {
				
				viewDiversionLabel.setBackground(new Color(0, 51,102));
				emergencyLabel.setBackground(new Color(0, 51,102));
				userLogoutLabel.setBackground(new Color(0, 51,102));
			}

			

		});
		
		userLogoutLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				Login Log = new Login();
				
			}

			

		});
		sendInformation.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				addEmergencyRequest();
				
				emergencyDate.setText("");
				emergencyName.setText("");
				emergencyPhone.setText("");
				travellingFrom.setText("");
				travellingTo.setText("");
				vehicleNumber.setText("");
				emergencyType.setText("");

			}

			

		});

		
		userLogoutLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
						
				setUserLabelColor(emergencyLabel, viewDiversionLabel, viewRoutesLabel, userLogoutLabel); 
				resetUserLabelColor(viewDiversionLabel,emergencyLabel,viewRoutesLabel);
			}
				private void resetUserLabelColor(JLabel viewDiversionLabel, JLabel emergencyLabel,JLabel viewRoutesLabel) {
				
				viewDiversionLabel.setBackground(new Color(0, 51,102));
				emergencyLabel.setBackground(new Color(0, 51,102));
				viewRoutesLabel.setBackground(new Color(0, 51,102));
			}

			

		});
	}
	//End of Initialization
	
	private void setUserLabelColor(JLabel emergencyLabel, JLabel viewDiversionLabel, JLabel viewRoutesLabel, JLabel logoutLabel) {
		
		emergencyLabel.setBackground(new Color(24, 195, 226));
		viewDiversionLabel.setBackground(new Color(24, 195, 226));
		viewRoutesLabel.setBackground(new Color(24, 195, 226));
		logoutLabel.setBackground(new Color(24, 195, 226));
		
	}
	
	public void createUserDiversionColumns() {
		
		udiversion = (DefaultTableModel) userDiversionTable.getModel();
		
		udiversion.addColumn("Diversion ID");
		udiversion.addColumn("Diversion Date");
		udiversion.addColumn("Diversion name");
		udiversion.addColumn("Diversion Route");
		udiversion.addColumn("Diversion Description");
		
	}
	
	public void createUserRouteColumns() {
		
		uRoute = (DefaultTableModel) userRouteTable.getModel();
		
		uRoute.addColumn("Route ID");
		uRoute.addColumn("Route name");
		uRoute.addColumn("Route Information");
		uRoute.addColumn("Route Length");
		
	}
	
	public void displayDiversion() {
		ArrayList<Diversion> dive = readDiversion();
		
		for(int i = 0; i< dive.size(); i++) {
			udiversion.addRow(new String[] {dive.get(i).getDiversionid(),dive.get(i).getDiversiondate(), dive.get(i).getDiversionname(),dive.get(i).getDiversionroute(),dive.get(i).getDiversiondescription()});
		
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
	public void displayRoute() {
		ArrayList<Route> rout = readRoute();
		for(int i = 0; i< rout.size(); i++) {
			uRoute.addRow(new String[] {rout.get(i).getRouteid(), rout.get(i).getRoutename(),rout.get(i).getRouteinformation(),rout.get(i).getRoutelength()});
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
	public void addEmergencyRequest() {
		
		ArrayList<Emergency> rd = new ArrayList<>();
		ObjectInputStream osr;
			try { 
				try {
					osr = new ObjectInputStream(new FileInputStream("Emergency.dat"));
					ArrayList<Emergency> obj;
					while ((obj=(ArrayList<Emergency>)osr.readObject())!=null) {
						for (int i = 0; i < obj.size(); i++) {
							rd.add(new Emergency(obj.get(i).getEmergencydate(),obj.get(i).getEmergencyname(),obj.get(i).getEmergencyphone(), obj.get(i).getTravellingfrom(), obj.get(i).getTravellingto(),obj.get(i).getVehiclenumber(),obj.get(i).getEmergencytype()));
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
				
			rd.add(new Emergency(emergencyDate.getText(),emergencyName.getText(),emergencyPhone.getText(),travellingFrom.getText(), travellingTo.getText(), vehicleNumber.getText(), emergencyType.getText()));
			ObjectOutputStream os1;
			os1 = new ObjectOutputStream(new FileOutputStream("Emergency.dat"));
			os1.writeObject(rd);
			
		    System.out.println("Emergency Information Recorded Successfully");   
			os1.close();
				
		} catch (EOFException e) {
				System.out.println("The file ends here..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
