package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import framework.Turns;
import javafx.event.ActionEvent;

public class LoginGUI extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Turns turn;
	
	//** GUI Components
	//Ending Labels
	private JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
	private JLabel newUserLabel = new JLabel("New User");
	
	
	public LoginGUI (Turns turn) 
	{
		super("Welcome to Turns");
		this.turn = turn;
		
		setSize(300, 200);
		setLocationRelativeTo(null);
		
		buildGUI();
		
		setVisible(true);
	}
	
	public void buildGUI()
	{	
		//Changes Java Icon to Turns logo
		try {
		    setIconImage(ImageIO.read(new File("ECE373_Project/GUIItems/appLogo.PNG")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		
		JPanel turnsLogin = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		//Text Fields
		JLabel userNameLabel = new JLabel("Username: ");
		JTextField userNameField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password: ");
		JTextField passwordField = new JTextField(10);
		
		//Buttons
		JButton loginButton = new JButton("login");
		
		//Action Listeners
		newUserLabel.addMouseListener(new linkListener());
		forgotPasswordLabel.addMouseListener(new linkListener());
		
		
		c.ipady = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0.3;
		
		turnsLogin.add(new JPanel(), c);
		
		c.weighty = 1;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 1;
		turnsLogin.add(userNameLabel, c);
		
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 1;
		turnsLogin.add(userNameField, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
	    c.gridy = 2;
		turnsLogin.add(passwordLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
	    c.gridy = 2;
		turnsLogin.add(passwordField, c);
	
		c.fill = GridBagConstraints.LINE_END;
		c.weightx = 3;
		c.ipady = 3;
		c.ipadx = 15;
		c.gridx = 1;
	    c.gridy = 3;
		turnsLogin.add(loginButton, c);
		
		c.weighty = 10;
		
		c.weightx = 0.5;
		c.gridx = 0;
	    c.gridy = 6;
		turnsLogin.add(forgotPasswordLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
	    c.gridy = 6;
		turnsLogin.add(newUserLabel, c);
		
		
		add(turnsLogin);
	}
	
	private class linkListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel source = (JLabel)(e.getSource());
			if(source.equals(forgotPasswordLabel))
				System.out.println("Forgot Password?");
			if(source.equals(newUserLabel))
				NewUserGUI();
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			//TODO
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private void NewUserGUI() 
	{
		JLabel welcomeMessage = new JLabel("Create an Account");
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameField = new JTextField(10);
		JLabel userNameLabel = new JLabel("Username: ");
		JTextField userNameField = new JTextField(10);
		JLabel emailLabel = new JLabel("Email: ");
		JTextField emailField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password");
		JPasswordField passwordField = new JPasswordField(10);
		JLabel confirmLabel = new JLabel("Confirm Password: ");
		JPasswordField confirmField = new JPasswordField(10);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 0;
		panel.add(welcomeMessage, c);
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 1;
		panel.add(nameLabel, c);
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 1;
		panel.add(nameField, c);
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 2;
		panel.add(userNameLabel, c);
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 2;
		panel.add(userNameField, c);
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 3;
		panel.add(emailLabel, c);
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 3;
		panel.add(emailField, c);
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 4;
		panel.add(passwordLabel, c);
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 4;
		panel.add(passwordField, c);
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 5;
		panel.add(confirmLabel, c);
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 5;
		panel.add(confirmField, c);
		
		JOptionPane.showMessageDialog(null, panel, "Welcome to Turns!", -1);
		
	}
	
	
	
	
	
	
	
	
}