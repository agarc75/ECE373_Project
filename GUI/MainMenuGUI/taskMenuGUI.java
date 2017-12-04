package GUI.MainMenuGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import GUI.ForgotPasswordGUI;
import GUI.NewUserGUI;
import framework.Task;
import framework.Turns;
import framework.User;

public class taskMenuGUI {
	private Turns turn = null;
	
	private JDialog dialog = new JDialog();
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	
	private JLabel taskName = new JLabel("Enter the Task Name: ");
	private JTextField taskNameField = new JTextField(10);
	private JLabel addUsername = new JLabel("+Add Another Username (Limit 10)");
	private ArrayList<JTextField> userNameField = new ArrayList<JTextField>();
	
	//Buttons
	private JButton okButton = new JButton("Okay");
	private JButton cancelButton = new JButton("Cancel");
	
	private JLabel addFriends = new JLabel("OR Click here to add from friends list");
	private JLabel addGroups = new JLabel("OR Click here to add a group");
	
	private JLabel messageAddUser = new JLabel("Type in the usernames that you want to add");
	private Box vBox;
	private int adduserCounter = 0;
	
	public taskMenuGUI(Turns turn) {
		this.turn = turn;
	}
	
	public void newTaskGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		
		vBox = Box.createVerticalBox();
		
		//Adds button action listeners
		addUsername.addMouseListener(new linkListener());
		okButton.addActionListener(new buttonListener());
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)(e.getSource());
				if(source.equals(cancelButton)) {
					dialog.setVisible(false);
					dialog.dispose();
				}
			}
		});
		c.insets = new Insets(30, 5, 2, 5);
		c.gridwidth = 1;
		c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 0;
		panel.add(taskName, c);
		
		c.weighty = 5;
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 0;
		panel.add(taskNameField, c);
		
		c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 1, 5);
		c.gridwidth = 0;
		c.gridx = 0;
	    c.gridy = 1;
	    panel.add(messageAddUser, c);
		
		
		userNameField.add(new JTextField(20));
		vBox.add(userNameField.get(userNameField.size()-1));
		
		c = new GridBagConstraints();
		c.gridwidth = 0;
		c.weighty = 0;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 2;
	    panel.add(vBox, c);
	    
	    c = new GridBagConstraints();
	    c.gridwidth = 0;
	    c.gridx = 0;
	    c.gridy = 3;
	    c.insets = new Insets(5, 5, 20, 5);
	    panel.add(addUsername, c);
	    
	    c.insets = new Insets(0, 5, 0, 5);
	    c.gridwidth = 0;
	    c.gridx = 0;
	    c.gridy = 4;
	    panel.add(addFriends, c);
	    
	    c.gridwidth = 0;
	    c.gridx = 0;
	    c.gridy = 5;
	    panel.add(addGroups, c);
	    
	    
	    c.gridwidth = 1;
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 6;
	    panel.add(okButton, c);
		
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 6;
		panel.add(cancelButton, c);
		
		dialog.setContentPane(panel);
		//Used to center on page
		dialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - 150,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - 200);
		dialog.setTitle("Create a new Task");
		dialog.setSize(350, 500);
		dialog.setVisible(true);
		
		
	}
	
	private class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okButton))
			{
				String tempString = new String();
				Task task = new Task(taskNameField.getText(), turn.getCurrentUser());
				System.out.println("Added new task");
				for(int i = 0; i < userNameField.size(); i++)
				{
					User tempUser = turn.loginUser(userNameField.get(i).getText());
					if(tempUser != null) {
						task.addUser(tempUser);
					}
					else if(tempUser == null && userNameField.get(i).getText() != null) {
						tempString = tempString + "\n" + userNameField.get(i).getText();
					}
					
					if(!tempString.isEmpty()) {
						JOptionPane.showMessageDialog(null, "The following users were not found and were ignored" + tempString, "Users not found", 0);
					}
					dialog.setVisible(false);
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
			if(source.equals(addUsername) && adduserCounter < 10) {
				panel.setVisible(false);
				userNameField.add(new JTextField(20));
				vBox.add(userNameField.get(userNameField.size()-1));
				adduserCounter++;
				panel.setVisible(true);
			}
			else if(adduserCounter > 10) {
				JOptionPane.showMessageDialog(null, "You have reached the limit of users you can add to a task", "Limit reached", 0);
			}
			if(source.equals(addFriends)) {
				
			}
			
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