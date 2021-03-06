package GUI.MainMenuGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import GUI.ForgotPasswordGUI;
import GUI.NewUserGUI;
import framework.Group;
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
	
	//For adding friends
	private JScrollPane addFriendScroll;
	private JPanel friendPanel;
	private ArrayList<JCheckBox> btn = new ArrayList<JCheckBox>();
	private ArrayList<User> friendsList;
	private ArrayList<User> tempUsers = new ArrayList<User>();
	private JButton okButton2 = new JButton("Okay");
	
	//For adding a group
	private JScrollPane addGroupScroll;
	private JPanel groupPanel;
	private ArrayList<JRadioButton> radiobtn = new ArrayList<JRadioButton>();
	private ButtonGroup radioGroup = new ButtonGroup();
	private ArrayList<Group> groupList;
	private Group tempGroup = null;
	private JButton okButton3 = new JButton("Okay");
	
	public taskMenuGUI(Turns turn) {
		this.turn = turn;
	}
	
	public void newTaskGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		
		vBox = Box.createVerticalBox();
		
		addUsername.setForeground(Color.BLUE);
		addFriends.setForeground(Color.BLUE);
		addGroups.setForeground(Color.BLUE);
		
		//Adds button action listeners
		addUsername.addMouseListener(new linkListener());
		addFriends.addMouseListener(new linkListener());
		addGroups.addMouseListener(new linkListener());
		okButton.addActionListener(new buttonListener());
		cancelButton.addActionListener(new buttonListener());
		
		//Changes java icon
		BufferedImage myPicture = null;
		
		try {
			myPicture = ImageIO.read(new File("./GUIItems/appLogo.PNG"));
		}
		 catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		//Picture
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(50, 50, Image.SCALE_FAST)));
		
		//Login GUI Formatting
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 0, 5);
		panel.add(picLabel, c);
				
		c.insets = new Insets(10, 5, 0, 5);
		c.gridwidth = 1;
		c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 1;
		panel.add(taskName, c);
		
		c.weighty = 5;
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 1;
		panel.add(taskNameField, c);
		
		c = new GridBagConstraints();
		c.insets = new Insets(5, 2, 1, 2);
		c.gridwidth = 0;
		c.gridx = 0;
	    c.gridy = 2;
	    panel.add(messageAddUser, c);
		
		
		userNameField.add(new JTextField(20));
		vBox.add(userNameField.get(userNameField.size()-1));
		
		c = new GridBagConstraints();
		c.gridwidth = 0;
		c.weighty = 0;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 3;
	    panel.add(vBox, c);
	    
	    c = new GridBagConstraints();
	    c.gridwidth = 0;
	    c.gridx = 0;
	    c.gridy = 4;
	    c.insets = new Insets(5, 5, 20, 5);
	    panel.add(addUsername, c);
	    
	    c.insets = new Insets(0, 5, 0, 5);
	    c.gridwidth = 0;
	    c.gridx = 0;
	    c.gridy = 5;
	    panel.add(addFriends, c);
	    
	    c.gridwidth = 0;
	    c.gridx = 0;
	    c.gridy = 6;
	    panel.add(addGroups, c);
	    
	    
	    c.gridwidth = 1;
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 7;
	    panel.add(okButton, c);
		
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 7;
		panel.add(cancelButton, c);
		
		dialog.setContentPane(panel);
		//Used to center on page
		dialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - 150,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - 200);
		dialog.setTitle("Create a new Task");
		dialog.setSize(350, 500);
		dialog.setVisible(true);
		
		
	}
	
	private void addFriendsGUI() {
		friendsList = turn.getCurrentUser().getFriends();
		GridBagConstraints c = new GridBagConstraints();
		
		panel.setVisible(false);
		panel.remove(messageAddUser);
		panel.remove(addUsername);
		panel.remove(vBox);
		panel.remove(addGroups);
		panel.remove(addFriends);
		panel.remove(okButton);
		
		okButton2.addActionListener(new buttonListener());
		
		friendPanel = new JPanel();
		friendPanel.setLayout(new BoxLayout(friendPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < friendsList.size(); i++)
		{
			btn.add(new JCheckBox(friendsList.get(i).getUsername()));
			btn.get(i).addItemListener(new checkBoxListener());
			friendPanel.add(btn.get(i));
		}
		
		addFriendScroll = new JScrollPane(friendPanel);
		addFriendScroll.setPreferredSize(new Dimension(200, 100));
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(addFriendScroll, c);
		
		c.gridwidth = 1;
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 7;
	    panel.add(okButton2, c);
	    
		panel.setVisible(true);
	}
	
	public void addGroupGUI() {
		groupList = turn.getCurrentUser().getGroups();
		GridBagConstraints c = new GridBagConstraints();
		
		panel.setVisible(false);
		panel.remove(messageAddUser);
		panel.remove(addUsername);
		panel.remove(vBox);
		panel.remove(addGroups);
		panel.remove(addFriends);
		panel.remove(okButton);
		
		okButton3.addActionListener(new buttonListener());
		
		groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < groupList.size(); i++)
		{
			radiobtn.add(new JRadioButton(groupList.get(i).getName()));
			radiobtn.get(i).addItemListener(new radioListener());
			radioGroup.add(radiobtn.get(i));
			groupPanel.add(radiobtn.get(i));
		}
		
		addGroupScroll = new JScrollPane(groupPanel);
		addGroupScroll.setPreferredSize(new Dimension(200, 100));
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(addGroupScroll, c);
		
		c.gridwidth = 1;
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 7;
	    panel.add(okButton3, c);
	    
		panel.setVisible(true);
	}
	
	private class checkBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox source = (JCheckBox)(e.getSource());
			int index = btn.indexOf(e.getSource());
			if(source.equals(btn.get(index)))
			{
				System.out.println("Called " + index);
				tempUsers.add(turn.getCurrentUser().getFriends().get(index));
			}
		}
	}
	
	private class radioListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton source = (JRadioButton)(e.getSource());
			int index = radiobtn.indexOf(e.getSource());
			if(source.equals(radiobtn.get(index)))
			{
				tempGroup = groupList.get(index);
			}
		}
	}
	
	private class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okButton))
			{
				if(taskNameField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter a Task Name", "Enter a name", 0);
					return;
				}
				
				String tempString = new String();
				String tempUserString;
				Task task = new Task(taskNameField.getText(), turn.getCurrentUser());
				
				for(int i = 0; i < userNameField.size(); i++)
				{
					tempUserString = null;
					tempUserString = userNameField.get(i).getText();
					User tempUser = turn.loginUser(tempUserString);
					if(tempUser != null) {
						task.addUser(tempUser);
					}
					else if(tempUser == null && !tempUserString.isEmpty()) {
						tempString = tempString + "\n" + userNameField.get(i).getText();
					}
				}
				if(!tempString.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "The following users were not found and were ignored" + tempString, "Users not found", 0);
				}
				dialog.setVisible(false);
				
			}
			if(source.equals(okButton2)) 
			{
				if(taskNameField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter a Task Name", "Enter a name", 0);
					return;
				}
				
				Task task = new Task(taskNameField.getText(), turn.getCurrentUser());
				for(int i = 0; i < tempUsers.size(); i++)
				{
					task.addUser(tempUsers.get(i));
				}
				dialog.setVisible(false);
			}
			
			if(source.equals(okButton3))
			{
				if(taskNameField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter a Task Name", "Enter a name", 0);
					return;
				}
				Task task = new Task(taskNameField.getText(), turn.getCurrentUser());
				for(int i = 0; i < tempGroup.getMembers().size(); i++)
				{
					task.addUser(tempGroup.getMembers().get(i));
				}
				dialog.setVisible(false);
			}
			
			
			
			if(source.equals(cancelButton))
			{
				dialog.setVisible(false);
				dialog.dispose();
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
				addFriendsGUI();
				
			}
			if(source.equals(addGroups)) {
				addGroupGUI();
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
