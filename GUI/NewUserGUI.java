package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import framework.Turns;

public class NewUserGUI{
	private Turns turn;
	
	public NewUserGUI(Turns turn) 
	{
		
		BuildNewUserGUI();
		
		
	}
	
	private void BuildNewUserGUI() 
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

