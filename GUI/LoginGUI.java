package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.prism.Graphics;

import framework.Turns;
import framework.User;
import javafx.event.ActionEvent;

public class LoginGUI extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Turns turn;
	private User tempUser = null;
	
	//** GUI Components
	//Text Fields
	private JTextField userNameField = new JTextField(10);
	private JPasswordField passwordField = new JPasswordField(10);
	
	//Ending Labels
	private JButton loginButton = new JButton("login");
	private JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
	private JLabel newUserLabel = new JLabel("New User");
	
		
	public LoginGUI (Turns turn) 
	{
		super("Welcome to Turns");
		this.turn = turn;
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		
		forgotPasswordLabel.setForeground(Color.LIGHT_GRAY);
		newUserLabel.setForeground(Color.LIGHT_GRAY);
		
		
		buildGUI();
		
		setVisible(true);
	}
	
	public void buildGUI()
	{	
		//Changes Java Icon to Turns logo
		try {
		    setIconImage(ImageIO.read(new File("./GUIItems/appLogo.PNG")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		
		JPanel turnsLogin = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		
		turnsLogin.setBackground(Color.black);
		turnsLogin.setForeground(Color.WHITE);
		
		
		
		
		//Text Fields
		JLabel userNameLabel = new JLabel("Username: ");
		userNameLabel.setForeground(Color.LIGHT_GRAY);
		
		userNameField.setBackground(Color.LIGHT_GRAY);
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setForeground(Color.LIGHT_GRAY);
		
		passwordField.setBackground(Color.LIGHT_GRAY);
		
		
		//Buttons
		loginButton.setForeground(Color.WHITE);
		Color loginButtonColor = new Color(102, 178, 255);
		loginButton.setBackground(loginButtonColor);
		
		//Action Listeners
		loginButton.addActionListener(new buttonlistener());
		newUserLabel.addMouseListener(new linkListener());
		forgotPasswordLabel.addMouseListener(new linkListener());
		
		BufferedImage myPicture = null;
		
		try {
			myPicture = ImageIO.read(new File("./GUIItems/appLogo.PNG"));
		}
		 catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(50, 50, Image.SCALE_FAST)));
		
		
		d.gridwidth = 3;
		d.gridx = 0;
		d.weighty = 40;
		turnsLogin.add(picLabel, d);
		
		
		
		
		c.gridwidth = 1;
		c.ipady = 2;
		c.weighty = 2;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 2;
		turnsLogin.add(userNameLabel, c);
		
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 2;
		turnsLogin.add(userNameField, c);
		
		c.weightx = 0.5;
		c.weighty = 2;
		c.gridx = 0;
	    c.gridy = 3;
		turnsLogin.add(passwordLabel, c);
		
		c.weighty = 5;
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 3;
		turnsLogin.add(passwordField, c);
	
		c.fill = GridBagConstraints.LINE_END;
		c.weighty = 10;
		c.weightx = 3;
		c.ipady = 3;
		c.ipadx = 15;
		c.gridx = 1;
	    c.gridy = 5;
		turnsLogin.add(loginButton, c);
		
		c.weighty = 70;
		c.weightx = 0.5;
		c.gridx = 0;
	    c.gridy = 7;
		turnsLogin.add(forgotPasswordLabel, c);
		
		c.weightx = 0.5;
		c.gridx = 1;
	    c.gridy = 7;
		turnsLogin.add(newUserLabel, c);
		
		
		add(turnsLogin);
	}
	
	private class buttonlistener implements ActionListener
	{
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(loginButton)) 
			{
				tempUser = turn.loginUser(userNameField.getText());
				if(tempUser != null) 
				{
					if(tempUser.validatePassword(String.valueOf(passwordField.getPassword())))
					{
						turn.setCurrentUSer(tempUser);
						setVisible(false);
						dispose();
						
						//Goes into main Screen
						new MainScreenGUI(turn);
					}	
					else
					{
						JOptionPane.showMessageDialog(null, "The password entered does not match our records!", "Incorrect Password", 0);
						//System.out.println(passwordField.getPassword());
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The Username entered does not exist.\nPlease feel free to create an account", "User Not Found", 1);
				}
			}
			
		}
		
	}
	
	private class linkListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			JLabel source = (JLabel)(e.getSource());
			if(source.equals(forgotPasswordLabel))
				new ForgotPasswordGUI(turn);
			if(source.equals(newUserLabel))
				new NewUserGUI(turn);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
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