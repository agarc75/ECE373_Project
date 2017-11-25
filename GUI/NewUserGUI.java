package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import framework.Turns;
import framework.User;

public class NewUserGUI{
	private Turns turn;
	private final int WIDTH = 300;
	private final int HEIGHT = 250;
	
	//fields and buttons
	private JTextField nameField = new JTextField(10);
	private JTextField userNameField = new JTextField(10);
	private JTextField emailField = new JTextField(10);
	private JPasswordField passwordField = new JPasswordField(10);
	private JPasswordField confirmField = new JPasswordField(10);
	private JButton okButton = new JButton("Create");
	private JButton cancelButton = new JButton("Cancel");
	
	//Dialog
	final JDialog dialog = new JDialog();
	
	public NewUserGUI(Turns turn) 
	{
		this.turn = turn;
		BuildNewUserGUI();
		
		
	}
	
	private void BuildNewUserGUI() 
	{
		JLabel welcomeMessage = new JLabel("Create an Account");
		JLabel nameLabel = new JLabel("Name: ");
		JLabel userNameLabel = new JLabel("Username: ");
		JLabel emailLabel = new JLabel("Email: ");
		JLabel passwordLabel = new JLabel("Password");
		JLabel confirmLabel = new JLabel("Confirm Password: ");
		
		
		//Adds button action listeners
		okButton.addActionListener(new buttonListener());
		cancelButton.addActionListener(new buttonListener());
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 0;
	    c.insets = new Insets(0, 0, 10, 0);
		panel.add(welcomeMessage, c);
		
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 1;
	    c.insets = new Insets(1, 10, 1, 10);
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
		
		c.insets = new Insets(20, 20, 0, 20);
		c.gridx = 0;
	    c.gridy = 6;
		panel.add(okButton, c);
		
		c.gridx = 1;
	    c.gridy = 6;
		panel.add(cancelButton, c);
		
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		
		dialog.setContentPane(panel);
		//Used to center on page
		dialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - WIDTH/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - HEIGHT/2);
		dialog.setTitle("Welcome to Turns");
		dialog.setSize(WIDTH, HEIGHT);
		dialog.setVisible(true);
		
		
	}
	
	private class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okButton)) 
			{	
				if(nameField.getText().isEmpty() || userNameField.getText().isEmpty() 
						|| emailField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please fill in all blanks", "Warning",2);
				}	
				else if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmField.getPassword())))
				{
					User newUser = new User(nameField.getText(), userNameField.getText(), emailField.getText(), String.valueOf(passwordField.getPassword()));
					turn.addUser(userNameField.getText(), newUser);
					dialog.setVisible(false);
					dialog.dispose();
					JOptionPane.showMessageDialog(null, "Thank you for signing up!\n Please login", "Welcome new user!",-1);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", 0);
				}
			}
			if(source.equals(cancelButton)) {
				dialog.setVisible(false);
				dialog.dispose();
			}
			
		}
		
	}
	
}

