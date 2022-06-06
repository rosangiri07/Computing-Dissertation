
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import Emergency.Emergency;
import Login.UserData;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window.Type;
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
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frameLogin;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField username;
	private JTextField password;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frameLogin.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

 Login() {
		initialize();
	}
 void initialize() {
	 
		frameLogin = new JFrame();
		frameLogin.getContentPane().setBackground(Color.WHITE);
		frameLogin.setBackground(Color.WHITE);
		frameLogin.setBounds(100, 100, 1000, 516);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.setResizable(false);
		
		Panel rightPanel = new Panel();
		rightPanel.setBackground(new Color(0, 51, 102));
		rightPanel.setBounds(0, 0, 478, 494);
		frameLogin.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setBounds(0, 35, 478, 213);
		rightPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/Roshan/Downloads/unnamed.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 478, 213);
		panel.add(lblNewLabel);
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(0, 51, 153));
		panel_1.setBounds(0, 268, 478, 46);
		rightPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTrafficManagementSystem = new JLabel("Traffic Management System");
		lblTrafficManagementSystem.setBounds(104, 0, 276, 46);
		panel_1.add(lblTrafficManagementSystem);
		lblTrafficManagementSystem.setBackground(Color.BLACK);
		lblTrafficManagementSystem.setFont(new Font("Bodoni 72", Font.BOLD, 20));
		lblTrafficManagementSystem.setForeground(Color.WHITE);
		lblTrafficManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-police-48.png")));
		lblNewLabel_1.setBounds(53, 0, 55, 46);
		panel_1.add(lblNewLabel_1);
		
		Panel leftPanel = new Panel();
		leftPanel.setBounds(478, 0, 522, 494);
		frameLogin.getContentPane().add(leftPanel);
		leftPanel.setLayout(new CardLayout(0, 0));
		
		Panel loginPanel = new Panel();
		leftPanel.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login Into Traffic Management System");
		lblLogin.setBounds(119, 100, 293, 19);
		loginPanel.add(lblLogin);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 204, 255));
		panel_2.setBounds(43, 170, 198, 56);
		loginPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-username-25.png")));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(52, 0, 96, 56);
		panel_2.add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameField.setBounds(258, 170, 226, 56);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		Panel panel_3 = new Panel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 204, 255));
		panel_3.setBounds(43, 250, 198, 56);
		loginPanel.add(panel_3);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-password-25.png")));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(52, 0, 96, 56);
		panel_3.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 250, 226, 56);
		loginPanel.add(passwordField);
		
		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(0, 204, 255));
		panel_4.setBounds(43, 326, 441, 35);
		loginPanel.add(panel_4);
		
		JLabel login = new JLabel("Login");
		login.addMouseListener(new MouseAdapter() {
			boolean valid = false;
			public void mouseClicked(MouseEvent e) {
				
				if(usernameField.getText().equals("admin") && passwordField.getText().equals("admin") ) {
					
					Login window = new Login();
					window.frameLogin.dispose();
					Admin d = new Admin();
					valid = true;
					
					
			}
				else {
					
					ObjectInputStream osr;
					String usr = "";
					
						try {
							System.out.println(usernameField.getText() + " " + passwordField.getText());
							osr = new ObjectInputStream(new FileInputStream("Userdata.dat"));
							ArrayList<UserData> obj;
							while ((obj=(ArrayList<UserData>)osr.readObject())!=null) {
								for (int i = 0; i < obj.size(); i++) {
									System.out.println(obj.get(i).getUsername() + " " + obj.get(i).getPassword());
									if (usernameField.getText().equals(obj.get(i).getUsername()) && passwordField.getText().equals(obj.get(i).getPassword())) {
										valid = true;

									} 
								}
							}
							osr.close();
						} catch (EOFException e1) {
							System.out.println("End of File...");
						} catch (FileNotFoundException e2) { 
							System.out.println("File not Found...");
						} catch (IOException e3) {
							System.out.println("Input and Output Exception");
						} catch (ClassNotFoundException e4) {
							System.out.println("Class not found....");
						}
						if (valid) {
							User s = new User(usr);
						}
					
				}
				
				if (!valid) {
					JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
				}

			}
				
		});

		login.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-login-rounded-up-25-2.png")));
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		login.setBounds(160, 0, 96, 35);
		panel_4.add(login);
		
		Panel panel_6 = new Panel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(51, 153, 153));
		panel_6.setBounds(43, 367, 441, 35);
		loginPanel.add(panel_6);
		
		JLabel signUp = new JLabel("Sign Up");
		signUp.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-sign-up-25.png")));
		signUp.setHorizontalAlignment(SwingConstants.CENTER);
		signUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signUp.setBounds(160, 0, 96, 35);
		panel_6.add(signUp);
		
		Panel signupPanel = new Panel();
		leftPanel.add(signupPanel);
		signupPanel.setLayout(null);
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(0, 204, 255));
		panel_5.setBounds(43, 44, 198, 50);
		signupPanel.add(panel_5);
		
		JLabel nameLabel = new JLabel("Name\n");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(52, 0, 96, 50);
		panel_5.add(nameLabel);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(258, 44, 226, 50);
		signupPanel.add(name);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(0, 204, 255));
		panel_7.setBounds(43, 112, 198, 50);
		signupPanel.add(panel_7);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressLabel.setBounds(52, 0, 96, 50);
		panel_7.add(addressLabel);
		
		Panel panel_8 = new Panel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(51, 153, 153));
		panel_8.setBounds(43, 385, 441, 34);
		signupPanel.add(panel_8);
		
		JLabel signup = new JLabel("Sign Up");
		signup.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-sign-up-25.png")));
		signup.setHorizontalAlignment(SwingConstants.CENTER);
		signup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signup.setBounds(160, 0, 96, 34);
		panel_8.add(signup);
	
		
		JLabel lblSignUpInto = new JLabel("Sign Up Into Traffic Management System");
		lblSignUpInto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpInto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSignUpInto.setBounds(117, 6, 293, 19);
		signupPanel.add(lblSignUpInto);
		
		Panel panel_9 = new Panel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(0, 204, 255));
		panel_9.setBounds(43, 174, 198, 50);
		signupPanel.add(panel_9);
		
		JLabel phoneLabel = new JLabel("Phone Number");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneLabel.setBounds(40, 0, 126, 50);
		panel_9.add(phoneLabel);
		
		Panel panel_10 = new Panel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(0, 204, 255));
		panel_10.setBounds(43, 244, 198, 50);
		signupPanel.add(panel_10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameLabel.setBounds(40, 0, 126, 50);
		panel_10.add(usernameLabel);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setColumns(10);
		address.setBounds(258, 112, 226, 50);
		signupPanel.add(address);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phone.setColumns(10);
		phone.setBounds(258, 174, 226, 50);
		signupPanel.add(phone);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setColumns(10);
		username.setBounds(258, 241, 226, 50);
		signupPanel.add(username);
		
		Panel panel_11 = new Panel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(0, 204, 255));
		panel_11.setBounds(43, 312, 198, 50);
		signupPanel.add(panel_11);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(40, 0, 126, 50);
		panel_11.add(passwordLabel);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setColumns(10);
		password.setBounds(258, 309, 226, 50);
		signupPanel.add(password);
		
		Panel panel_12 = new Panel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(0, 204, 255));
		panel_12.setBounds(43, 425, 441, 34);
		signupPanel.add(panel_12);
		
		JLabel goBackLabel = new JLabel("Login");
		goBackLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/icons8-login-rounded-up-25-2.png")));
		goBackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goBackLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		goBackLabel.setBounds(160, 0, 96, 34);
		panel_12.add(goBackLabel);
		
		signUp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				leftPanel.setVisible(true);
				loginPanel.setVisible(false);
				signupPanel.setVisible(true);
	
			}

		});
		goBackLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				leftPanel.setVisible(true);
				loginPanel.setVisible(true);
				signupPanel.setVisible(false);
	
			}

		});

		
		signup.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				addUserData();
				
				name.setText("");
				address.setText("");
				phone.setText("");
				username.setText("");
				password.setText("");
			}

			

		});
	}
	
	public void addUserData() {
		
		ArrayList<UserData> rd = new ArrayList<>();
		ObjectInputStream osr;
			try { 
				try {
					osr = new ObjectInputStream(new FileInputStream("Userdata.dat"));
					ArrayList<UserData> obj;
					while ((obj=(ArrayList<UserData>)osr.readObject())!=null) {
						for (int i = 0; i < obj.size(); i++) {
							rd.add(new UserData(obj.get(i).getName(),obj.get(i).getAddress(),obj.get(i).getPhonenumber(), obj.get(i).getUsername(), obj.get(i).getPassword()));
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
				
			rd.add(new UserData(name.getText(),address.getText(),phone.getText(),username.getText(), password.getText()));
			ObjectOutputStream os1;
			os1 = new ObjectOutputStream(new FileOutputStream("Userdata.dat"));
			os1.writeObject(rd);
			
		    System.out.println("User Information Recorded Successfully");   
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
