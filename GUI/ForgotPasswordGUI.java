package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import framework.Turns;
import framework.User;


public class ForgotPasswordGUI {
	private Turns turn;
	private final int WIDTH = 300;
	private final int HEIGHT = 200;
	
	//fields and buttons
	private JTextField userNameField = new JTextField(10);
	private JTextField emailField = new JTextField(10);
	private JButton okButton = new JButton("Okay");
	private JButton cancelButton = new JButton("Cancel");
	
	//Close button for password show dialog
	private JButton closeButton = new JButton("Close");
	
	//Dialog
	final JDialog dialog = new JDialog();
	
	//temp User
	User tempUser = new User();
	
	
	public ForgotPasswordGUI(Turns turn)
	{
		this.turn = turn;
		BuildForgotPaswordGUI();
	}
	
	private void BuildForgotPaswordGUI()
	{
		JLabel userNameLabel = new JLabel("Enter your Username: ");
		JLabel emailLabel = new JLabel("Enter your Email: ");
		JLabel usageLabel_1 = new JLabel("Your password will appear once you enter");
		JLabel usageLabel_2 = new JLabel(" a username with its corresponding email");
		
		//Adds button action listeners
		okButton.addActionListener(new buttonListener());
		cancelButton.addActionListener(new buttonListener());
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints d = new GridBagConstraints();
		panel.setBackground(Color.LIGHT_GRAY);
			
		
		c.fill = GridBagConstraints.HORIZONTAL;
				
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(30, 0, 0, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 0;
		panel.add(usageLabel_1, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 20, 5);
		panel.add(usageLabel_2, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(userNameLabel, c);
		
		
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0.0;
		c.ipadx = 50;
		panel.add(userNameField, c);
		
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(emailLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0.0;
		panel.add(emailField, c);
		
		c = new GridBagConstraints();
		c.insets = new Insets(20, 20, 20, 20);
		c.gridx = 0;
	    c.gridy = 4;
		panel.add(okButton, c);
		
		c.gridx = 1;
	    c.gridy = 4;
		panel.add(cancelButton, c);
		
		
		dialog.setContentPane(panel);
		//Used to center on page
		dialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - WIDTH/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - HEIGHT/2);
		dialog.setTitle("Welcome to Turns");
		dialog.setSize(WIDTH, HEIGHT);
		dialog.setVisible(true);
		
	}
	
	private void ShowPasswordGUI() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		//used to time out frame after 5 second for security
		Timer timeOut = new Timer(7000, new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		timeOut.setRepeats(false);
		timeOut.start();
		
		
		
		panel.setBackground(Color.black);
		panel.setForeground(Color.WHITE);
		
		JLabel passwordMessage = new JLabel("Your password is: ");
		passwordMessage.setForeground(Color.LIGHT_GRAY);
		
		//SHows the users password
		JLabel password = new JLabel(tempUser.getPassword());
		Font passwordFont = new Font("Ariel", Font.BOLD, 20);
		password.setFont(passwordFont);
		
		JLabel timeLeftLabel = new JLabel("Window will disappear in 7 seconds");
		timeLeftLabel.setForeground(Color.LIGHT_GRAY);
		
		//changing color of button
		closeButton.setForeground(Color.WHITE);
		Color themeButtonColor = new Color(102, 178, 255);
		closeButton.setBackground(themeButtonColor);
		
		//button listener
		closeButton.addActionListener(new buttonListener());
		
		
		
		c.gridwidth = 0;
		c.gridy = 0;
		panel.add(passwordMessage, c);
		c.gridy = 1;
		panel.add(password, c);
		c.gridy = 2;
		panel.add(timeLeftLabel, c);
		
		c.gridy = 3;
		c.insets = new Insets(30, 20, 10, 10);
		panel.add(closeButton, c);
		
		dialog.setVisible(false);
		dialog.repaint();
		dialog.setContentPane(panel);
		dialog.setVisible(true);
		
		
		
	}
	
	private class buttonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okButton)) 
			{	
				if(emailField.getText().isEmpty() || userNameField.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please fill in all blanks", "Warning",2);
				else
				{
					tempUser = turn.loginUser(userNameField.getText());
					if(tempUser != null) 
					{
						if(emailField.getText().equals(tempUser.getEmail()))
						{
							ShowPasswordGUI();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "The email entered does not match username", "Incorrect Email", 0);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "The username entered does not appear in our records!", "Incorrect Username", 0);
					}
				}
			}
			if(source.equals(cancelButton)) {
				dialog.setVisible(false);
				dialog.dispose();
			}
			if(source.equals(closeButton)) {
				dialog.setVisible(false);
				dialog.dispose();
			}
			
		}
		
	}

}
