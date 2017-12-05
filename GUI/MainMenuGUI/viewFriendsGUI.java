package GUI.MainMenuGUI;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
	
	public viewFriendsGUI(Turns turn)
	{
		this.turn = turn;
		this.friendList = turn.getCurrentUser().getFriends();
		//createFriendsGUI();
	}
	
	
	

}
