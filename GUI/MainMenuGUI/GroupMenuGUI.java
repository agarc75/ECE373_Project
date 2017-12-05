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

import framework.Group;
import framework.Task;
import framework.Turns;


public class GroupMenuGUI {
	//framework
	private Turns turn = null;
	private ArrayList<Group> groupList = null;
	private ArrayList<Group> delGroupList = new ArrayList<Group>();
	
	//Labels
	private JLabel infoLabel = new JLabel("Groups List:");
	private JLabel selGroupLabel = new JLabel("Select the group(s) you want to remove:");

	//Buttons
	private JButton closeButton = new JButton("Close");
	private JButton okButton = new JButton("Okay");
	private JButton cancelButton = new JButton("Cancel");
	private ArrayList<JCheckBox> btn = new ArrayList<JCheckBox>();
	
	//Panels
	private JDialog dialog = new JDialog();
	private JScrollPane scrollPane;
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel groupPanel = new JPanel();
	private GridBagConstraints c = new GridBagConstraints();
	
	
	
	public GroupMenuGUI(Turns turn)
	{
		this.turn = turn;
		this.groupList = turn.getCurrentUser().getGroups();
	}
	
	public void buildViewGroupGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
		
		ArrayList<String> tempString = new ArrayList<String>();
		
		//Action Listeners
		closeButton.addActionListener(new buttonListener());
		
		for(int i = 0; i < groupList.size(); i++)
		{	
			tempString.add(groupList.get(i).getName());
			groupPanel.add(new JLabel(tempString.get(i)));
		}
		
		groupPanel.setVisible(true);
		
		scrollPane = new JScrollPane(groupPanel);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		//scrollPane.setVisible(true);
		
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
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 5, 0);
		panel.add(picLabel, c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(infoLabel, c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(scrollPane, c);
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(closeButton, c);
		
		dialog.setContentPane(panel);
		//Used to center on page
		dialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - 150,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - 200);
		dialog.setTitle("Group List");
		dialog.setSize(350, 300);
		dialog.setVisible(true);
		
	}
	
	public void buildDeleteGroupGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		
		groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
		
		groupList = turn.getCurrentUser().getGroups();
		
		okButton.addActionListener(new buttonListener());
		cancelButton.addActionListener(new buttonListener());
		
		//Changes java icon
		BufferedImage myPicture = null;
		
		try {
			myPicture = ImageIO.read(new File("./GUIItems/deleteLogo.PNG"));
		}
		 catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		//Picture
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(75, 75, Image.SCALE_FAST)));
		
		for(int i = 0; i < groupList.size(); i++)
		{
			btn.add(new JCheckBox(groupList.get(i).getName()));
			btn.get(i).addItemListener(new checkBoxListener());
			groupPanel.add(btn.get(i));
		}
		
		scrollPane = new JScrollPane(groupPanel);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		
		
		//Login GUI Formatting
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 0, 5);
		panel.add(picLabel, c);
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(selGroupLabel, c);
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(scrollPane, c);
		
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
		dialog.setTitle("Delete Groups");
		dialog.setSize(350, 400);
		dialog.setVisible(true);
		
		
	}
	
	private class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(closeButton))
			{
				dialog.setVisible(false);
				dialog.dispose();
			}
			if(source.equals(okButton))
			{
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Group(s)", "Confirm", JOptionPane.YES_NO_OPTION);
				if(n != JOptionPane.YES_OPTION) {
					return;
				}
				n = JOptionPane.showConfirmDialog(null, "This is irreversible. Are you 100% sure?", "Caution", 0);
				if(n != JOptionPane.YES_OPTION)
				{
					return;
				}
				
				
				for(int i = 0; i < delGroupList.size(); i++)
				{
					turn.getCurrentUser().removeGroup(delGroupList.get(i));
				}
				dialog.setVisible(false);
				dialog.dispose();	
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
					delGroupList.add(groupList.get(index));
				}
				else if(btn.get(index).isSelected() == false)
				{
					System.out.println("Deselected "+ index);
					delGroupList.remove(groupList.get(index));
				}
				
			}
		}
	}
}
