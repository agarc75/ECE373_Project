package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import framework.Turns;

public class MainScreenGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Turns turn;
	private CurrentTaskGUI currentGUI;
	private TaskDetailsGUI detailsGUI;
	
	private JMenuBar menuBar;
	
	public MainScreenGUI(Turns turn) {
		super("Welcome to Turns");
		this.turn = turn;
		
		setSize(1200, 600);
		setLocationRelativeTo(null);
		setBackground(Color.DARK_GRAY);
		
		menuBar = new JMenuBar();
		JMenu taskMenu = new JMenu("Tasks Options");
		JMenu friendMenu = new JMenu("Friend Options");
		JMenu accountMenu = new JMenu("Account Options");
		
		menuBar.add(taskMenu);
		menuBar.add(friendMenu);
		menuBar.add(accountMenu);
		menuBar.setVisible(true);
		
		
		setJMenuBar(menuBar);
		
		currentGUI = new CurrentTaskGUI(turn, turn.getCurrentTask());
		detailsGUI = new TaskDetailsGUI(turn, turn.getCurrentTask());
		//Changes Java Icon to Turns logo
		try {
		    setIconImage(ImageIO.read(new File("./GUIItems/appLogo.PNG")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane(new TaskListGUI(turn, this));
		scrollPane.setPreferredSize(new Dimension(318, 500));
		add(scrollPane, BorderLayout.LINE_START);
		
		add(currentGUI, BorderLayout.CENTER);
		add(detailsGUI, BorderLayout.LINE_END);

		
		//pack();
		setVisible(true);
	
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
	
}