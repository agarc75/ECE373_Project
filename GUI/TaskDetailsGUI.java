package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import framework.Task;
import framework.Turns;

public class TaskDetailsGUI extends JPanel
{
	public TaskDetailsGUI (Turns turn, Task task)
	{
		if(task == null)
		{
			setPreferredSize(new Dimension(300, 300));
			setBackground(Color.DARK_GRAY);
			return;
		}
		JLabel taskName = new JLabel(task.getName());
		JTextArea currentUserOrder = new JTextArea("Current User Order\n\n" + task.getUserOrderString());
		
		add(taskName);
		add(currentUserOrder);
		setPreferredSize(new Dimension(300, 300));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		if (task.getDate() == null)
		{
			JLabel taskDate = new JLabel("Task Has No Due Date");
			add(taskDate);
		}
		else
		{
			JTextArea taskDate = new JTextArea("Task Due Date\n\n" + task.getDate().toString());
			add(taskDate);
		}
		
		
		if (turn.getCurrentUser() == task.getCurrentUser())
		{
			JButton nextUser = new JButton("Turn Completed");
			nextUser.addActionListener(new buttonListener());
			nextUser.setBackground(new Color(102, 178, 255));
			nextUser.setForeground(Color.WHITE);
			nextUser.setFont(new Font("Arial", Font.PLAIN, 15));
			
			add(nextUser);
		}
		
		setVisible(true);
	}
	
	private class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void paintComponent(Graphics g)
    {
		   // Call the base class paint method.
		   super.paintComponent(g);
		   
		   Dimension panelSize = new Dimension(500, 550);
		   panelSize = this.getSize();
		   
		   BufferedImage myPicture = null;
			
			try {
				myPicture = ImageIO.read(new File("./GUIItems/detailsBackground.png"));
			}
			 catch (IOException exc) {
			    exc.printStackTrace();
			}
			
			int xpic = ((int) panelSize.getWidth() / 2 - 100);
			int ypic = ((int) panelSize.getHeight() / 2 -100);
			
			g.drawImage(myPicture.getScaledInstance(200, 200, Image.SCALE_FAST), xpic, ypic, null);		   
		   
    }
		
}
