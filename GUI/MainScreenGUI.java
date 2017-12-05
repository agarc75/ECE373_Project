package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUI.MainMenuGUI.delMulTaskGUI;
import GUI.MainMenuGUI.taskMenuGUI;
import framework.Turns;

public class MainScreenGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Turns turn;
	private CurrentTaskGUI currentGUI;
	private TaskDetailsGUI detailsGUI;
	private TaskListGUI taskListsGUI;
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JScrollPane scrollPane;
	
	//Task menu
	private JMenu taskMenu = new JMenu("Tasks Options");
	private JMenuItem newTaskItem = new JMenuItem("Create new Task");
	private JMenuItem deleteMulTaskItem = new JMenuItem("Delete Multipe Tasks");
	private JMenuItem refreshTaskList = new JMenuItem("Refresh Task Lists");
	
	//Friend Menu
	private JMenu friendMenu = new JMenu("Friend Options");
	private JMenuItem addFriendItem = new JMenuItem("Add a friend");
	private JMenuItem removeFriendItem = new JMenuItem("Remove Friend");
	private JMenuItem viewGroupItem = new JMenuItem("View Groups");
	private JMenuItem newGroupItem = new JMenuItem("New  Groups");
	private JMenuItem deleteGroupItem = new JMenuItem("Delete Groups");
	
	//Account Menu
	private JMenu accountMenu = new JMenu("Account Options");
	private JMenuItem editAccountItem = new JMenuItem("Edit account information");
	private JMenuItem logoutItem = new JMenuItem("Logout from Turns");
	
	public MainScreenGUI(Turns turn) {
		super("Welcome to Turns");
		this.turn = turn;
		
		setSize(1200, 600);
		setLocationRelativeTo(null);
		setBackground(Color.DARK_GRAY);
		
		//Adding action listeners
		newTaskItem.addActionListener(new menuListener());
		deleteMulTaskItem.addActionListener(new menuListener());
		refreshTaskList.addActionListener(new menuListener());
		
		addFriendItem.addActionListener(new menuListener());
		removeFriendItem.addActionListener(new menuListener());
		viewGroupItem.addActionListener(new menuListener());
		newGroupItem.addActionListener(new menuListener());
		deleteGroupItem.addActionListener(new menuListener());
		
		editAccountItem.addActionListener(new menuListener());
		logoutItem.addActionListener(new menuListener());
		
		
		menuBar.add(taskMenu);
		taskMenu.add(newTaskItem);
		taskMenu.add(deleteMulTaskItem);
		taskMenu.add(refreshTaskList);
		
		menuBar.add(friendMenu);
		friendMenu.add(addFriendItem);
		friendMenu.add(removeFriendItem);
		friendMenu.add(viewGroupItem);
		friendMenu.add(newGroupItem);
		friendMenu.add(deleteGroupItem);
		
		menuBar.add(accountMenu);
		accountMenu.add(editAccountItem);
		accountMenu.add(logoutItem);
		
		menuBar.setVisible(true);
		
		setJMenuBar(menuBar);
		
		currentGUI = new CurrentTaskGUI(turn, turn.getCurrentTask());
		detailsGUI = new TaskDetailsGUI(turn, turn.getCurrentTask());
		taskListsGUI = new TaskListGUI(turn, this);
		
		
		//Changes Java Icon to Turns logo
		try {
		    setIconImage(ImageIO.read(new File("./GUIItems/appLogo.PNG")));
		}catch (IOException exc) {
		    exc.printStackTrace();
		}
		scrollPane = new JScrollPane(taskListsGUI);
		if(turn.getCurrentUser().getTasks().size() > 10)
		{
			scrollPane.setPreferredSize(new Dimension(318, 500));
		}else {
			scrollPane.setPreferredSize(new Dimension(318, 500));
		}
		
		add(scrollPane, BorderLayout.LINE_START);
		add(currentGUI, BorderLayout.CENTER);
		add(detailsGUI, BorderLayout.LINE_END);

		
		//pack();
		setVisible(true);
		
		//Changing default close operation
		this.addWindowListener(new windowListener());
	
	}
	
	public void addCurrentTaskGUI()
	{	
		currentGUI.setVisible(false);
		remove(currentGUI);
		detailsGUI.setVisible(false);
		remove(detailsGUI);
		add(detailsGUI = new TaskDetailsGUI(turn, turn.getCurrentTask()), BorderLayout.LINE_END);
		add(currentGUI = new CurrentTaskGUI(turn, turn.getCurrentTask()), BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void refreshTaskList() {
		remove(scrollPane);
		taskListsGUI = new TaskListGUI(turn, this);
		scrollPane = new JScrollPane(taskListsGUI);
		if(turn.getCurrentUser().getTasks().size() > 10)
		{
			scrollPane.setPreferredSize(new Dimension(318, 500));
		}else {
			scrollPane.setPreferredSize(new Dimension(303, 500));
		}
		System.out.println("Task List Refreshed");
		add(scrollPane, BorderLayout.LINE_START);
		repaint();
		revalidate();
	}
	
	
	
	public class menuListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			if(source.equals(newTaskItem)) {
				taskMenuGUI temp = new taskMenuGUI(turn);
				temp.newTaskGUI();
			}
			
			if(source.equals(refreshTaskList)) {
				refreshTaskList();
			}
			
			if(source.equals(deleteMulTaskItem)) {
				delMulTaskGUI temp = new delMulTaskGUI(turn);
				temp.newDelMulTaskGUI();
			}
		}
	}
	
	public class windowListener implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e) {
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			Turns.saveData(turn);
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
}