import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginGUI extends JFrame
{	
	private Turns turn;
	
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
		JPanel turnsLogin = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
				
				
		//Text Fields
		JLabel userNameLabel = new JLabel("Username: ");
		JTextField userNameField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password: ");
		JTextField passwordField = new JTextField(10);
		
		//Buttons
		JButton loginButton = new JButton("login");
		
		
		//Ending Labels
		JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
		JLabel newUserLabel = new JLabel("New User");
		
		c.ipady = 5;
		
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 0;
		turnsLogin.add(userNameLabel, c);
		
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 0;
		turnsLogin.add(userNameField, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
	    c.gridy = 1;
		turnsLogin.add(passwordLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
	    c.gridy = 1;
		turnsLogin.add(passwordField, c);
		
		c.weightx = 0.5;
		c.gridx = 0;
	    c.gridy = 2;
		turnsLogin.add(loginButton, c);
		
		c.weighty = 1;
		
		c.weightx = 0.5;
		c.gridx = 0;
	    c.gridy = 5;
		turnsLogin.add(forgotPasswordLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
	    c.gridy = 5;
		turnsLogin.add(newUserLabel, c);
		
		
		add(turnsLogin);
	}
	
	
	
}