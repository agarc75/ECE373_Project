package GUI.MainMenuGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import framework.Turns;
import framework.User;

public class newGroupGUI {
	private Turns turn = null;
	
	private JDialog dialog = new JDialog();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel friendPanel = new JPanel();
	private JScrollPane groupScrollPane;
	private GridBagConstraints c = new GridBagConstraints();
	
	private ArrayList<User> friendList = new ArrayList<User>();
	private ArrayList<User> tempAddList = new ArrayList<User>();
	
	//Buttons
	private JButton okButton = new JButton("Okay");
	private JButton cancelButton = new JButton("Cancel");
	
	//Labels
	private JLabel groupLabel = new JLabel("Select the friends ou want to add to this group");
	private JLabel enterNameLabel = new JLabel("Enter a name for this group");
	
	//Fields
	private JTextField enterNameField = new JTextField(12);
	
	//Selecting friends
	private ArrayList<JCheckBox> btn = new ArrayList<JCheckBox>();
	
	public newGroupGUI(Turns turn) {
		this.turn = turn;
		this.friendList = turn.getCurrentUser().getFriends();
		buildNewGroupGUI();
	}
	
	public void buildNewGroupGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		
		friendPanel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		friendPanel.setLayout(new BoxLayout(friendPanel, BoxLayout.Y_AXIS));
		
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
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(75, 75, Image.SCALE_FAST)));
		
		for(int i = 0; i < friendList.size(); i++)
		{
			btn.add(new JCheckBox(friendList.get(i).getName()));
			btn.get(i).addItemListener(new checkBoxListener());
			friendPanel.add(btn.get(i));
		}
		
		groupScrollPane = new JScrollPane(friendPanel);
		groupScrollPane.setPreferredSize(new Dimension(200, 100));
		
		
		//Login GUI Formatting
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 0, 5);
		panel.add(picLabel, c);
		
		
		c.gridwidth = 1;
		c.weightx = 5;
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 5;
		panel.add(enterNameLabel, c);
		
		c.gridx = 1;
		panel.add(enterNameField, c);
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(groupLabel, c);
		
		c = new GridBagConstraints();
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(groupScrollPane, c);
		
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
		dialog.setTitle("Create a new Group");
		dialog.setSize(350, 400);
		dialog.setVisible(true);
	}
	
	private class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okButton))
			{
				
			}
			if(source.equals(cancelButton))
			{
				dialog.setVisible(false);
				dialog.dispose();
			}
			
		}	
	}
	
	private class checkBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox source = (JCheckBox)(e.getSource());
			int index = btn.indexOf(e.getSource());
			if(source.equals(btn.get(index)))
			{
				if(btn.get(index).isSelected())
				{
					System.out.println("Selected" + index);
					tempAddList.add(friendList.get(index));
				}
				else if(btn.get(index).isSelected() == false)
				{
					System.out.println("Deselected "+ index);
					tempAddList.remove(friendList.get(index));
				}
				
			}
		}
	}
	
}
