package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import framework.Turns;

public class MainScreenGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Turns turn;
	
	public MainScreenGUI(Turns turn) {
		super("Welcome to Turns");
		this.turn = turn;
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setBackground(Color.DARK_GRAY);
		
		//Changes Java Icon to Turns logo
		try {
		    setIconImage(ImageIO.read(new File("./GUIItems/appLogo.PNG")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		
		
		add(new TaskListGUI(turn), BorderLayout.LINE_START);
		
		
		
	
		//pack();
		setVisible(true);
		
		
	
	
	}
	
}