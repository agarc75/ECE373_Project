import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

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
		
		//Action Listeners
		newUserLabel.addMouseListener(new linkListener());
		forgotPasswordLabel.addMouseListener(new linkListener());
		
		
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
	
	private class linkListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel source = (JLabel)(e.getSource());
			if(source.equals(forgotPasswordLabel))
				System.out.println("Forgot Password?");
			if(source.equals(newUserLabel))
				System.out.println("Welcome!");
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
	
	
}