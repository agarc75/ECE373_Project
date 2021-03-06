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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import framework.Turns;
import framework.User;

public class viewFriendsGUI {
	//framework
	private Turns turn = null;
	private ArrayList<User> friendList = null;
	
	//Labels
	private JLabel infoLabel = new JLabel("Friends List:");

	//Buttons
	private JButton closeButton = new JButton("Close");
	
	//Panels
	private JDialog dialog = new JDialog();
	private JScrollPane scrollPane;
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel friendsPanel = new JPanel();
	private GridBagConstraints c = new GridBagConstraints();
	
	
	public viewFriendsGUI(Turns turn)
	{
		this.turn = turn;
		this.friendList = turn.getCurrentUser().getFriends();
		createFriendsGUI();
	}
	
	public void createFriendsGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		friendsPanel.setLayout(new BoxLayout(friendsPanel, BoxLayout.Y_AXIS));
		
		ArrayList<String> tempString = new ArrayList<String>();
		
		//Action Listeners
		closeButton.addActionListener(new buttonListener());
		
		for(int i = 0; i < friendList.size(); i++)
		{	
			tempString.add(friendList.get(i).getName() + " : " + friendList.get(i).getUsername());
			friendsPanel.add(new JLabel(tempString.get(i)));
			System.out.println(tempString.get(i));
		}
		
		
		
		friendsPanel.setVisible(true);
		
		scrollPane = new JScrollPane(friendsPanel);
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
		dialog.setTitle("Friend List");
		dialog.setSize(350, 300);
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
		}
	}
	
	
	
	

}
