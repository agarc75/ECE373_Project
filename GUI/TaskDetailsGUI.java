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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

import framework.Task;
import framework.Turns;
import framework.User;

public class TaskDetailsGUI extends JPanel
{
	Task aTask;
	Turns aTurn;
	public TaskDetailsGUI (Turns turn, Task task)
	{
		aTask = task;
		aTurn = turn;
		
		if(task == null)
		{
			setPreferredSize(new Dimension(300, 300));
			setBackground(Color.DARK_GRAY);
			return;
		}
		
		JLabel taskName = new JLabel(task.getName());
		taskName.setFont(new Font("Arial", Font.BOLD, 25));
		taskName.setHorizontalAlignment(SwingConstants.CENTER);
		taskName.setVerticalAlignment(SwingConstants.CENTER);
		taskName.setForeground(Color.LIGHT_GRAY);
		
		JPanel label = new JPanel();
		label.setBackground(Color.DARK_GRAY);
		label.add(taskName);
		label.setPreferredSize(new Dimension(300, 35));
		
		JEditorPane details = new JEditorPane();
		details.setContentType("text/html");
		String paneText = "<div><font size=5 color=BLACK face='Ariel Black'>" + "Current User Order" + "</font></div>" + "<br />"
				+ "<div><font size=4 color=BLACK face='Ariel'>" + task.getUserOrderString() + "</font></div><br /><br />"
				+ "<div><font size=5 color=BLACK face='Ariel Black'>" + "Task Creator" + "</font></div>" + "<br />"
				+ "<div><font size=4 color=BLACK face='Ariel'>" + task.getCreator().getName() + "</font></div>";
		
		add(label);
		setPreferredSize(new Dimension(300, 500));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		if (task.getDate() == null)
		{
			paneText += "<br /><br /><div><font size=5 color=BLACK face='Ariel Black'>" + "Task Has No Due Date" + "</font></div>" + "<br />";
		}
		else
		{
			SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d");
			format.setCalendar(task.getDate());
			paneText += "<br /><br /><div><font size=5 color=BLACK face='Ariel Black'>" + "Task Due Date<br /><br /></font></div>" + "<div><font size=4 color=BLACK face='Ariel'>" + format.format(task.getDate().getTime()) + "</font></div>" + "<br />";
		}
		
		details.setText(paneText);
		details.setPreferredSize(new Dimension(300, 600));
		JScrollPane textScrollPane = new JScrollPane(details);
		textScrollPane.setPreferredSize(new Dimension(300, 500));
		add(textScrollPane);
		
		JLabel taskOptions = new JLabel("Task Options");
		taskOptions.setFont(new Font("Arial", Font.BOLD, 20));
		taskOptions.setForeground(Color.LIGHT_GRAY);
		JPanel taskLabel = new JPanel();
		taskLabel.setBackground(Color.DARK_GRAY);
		taskLabel.add(taskOptions);
		taskLabel.setPreferredSize(new Dimension(300, 35));
		
		add(taskLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		if (turn.getCurrentUser() == task.getCurrentUser())
		{
			JButton nextUser = new JButton("Turned");
			nextUser.addActionListener(new buttonListener());
			nextUser.setBackground(new Color(102, 178, 255));
			nextUser.setForeground(Color.WHITE);
			nextUser.setFont(new Font("Arial", Font.PLAIN, 15));
			
			
			buttonPanel.add(nextUser);
		}
		
		JButton addUser = new JButton("Add User");
		addUser.addActionListener(new buttonListener());
		addUser.setBackground(new Color(102, 178, 255));
		addUser.setForeground(Color.WHITE);
		addUser.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPanel.add(addUser);
		
		if (turn.getCurrentUser() == task.getCreator())
		{
			JButton deleteTask = new JButton("Delete Task");
			deleteTask.addActionListener(new buttonListener());
			deleteTask.setBackground(new Color(102, 178, 255));
			deleteTask.setForeground(Color.WHITE);
			deleteTask.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonPanel.add(deleteTask);
			
			JButton removeUser = new JButton("Remove User");
			removeUser.addActionListener(new buttonListener());
			removeUser.setBackground(new Color(102, 178, 255));
			removeUser.setForeground(Color.WHITE);
			removeUser.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonPanel.add(removeUser);
		}
		
		JScrollPane buttonScroll = new JScrollPane(buttonPanel);
		
		if (buttonPanel.getComponentCount() > 2)
		{
			buttonScroll.setPreferredSize(new Dimension(300, 54));
		}
		else
		{
			buttonScroll.setPreferredSize(new Dimension(300, 36));
		}
		
		add(buttonScroll);
		
		setVisible(true);
	}
	
	private class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton toggled = (JButton) e.getSource();
			String toggledText = toggled.getText();
			
			if (toggledText.equals("Turned"))
			{
				int n = JOptionPane.showConfirmDialog(null, "Task Completed?", "Turns", JOptionPane.YES_NO_OPTION);
				
				if (n == JOptionPane.YES_OPTION)
				{
					aTask.nextUser();
					setVisible(false);
					revalidate();
					repaint();
					setVisible(true);
				}
			}
			else if (toggledText.equals("Add User"))
			{
				String user = JOptionPane.showInputDialog(null, "Enter Username to Add.", "Add User", JOptionPane.OK_CANCEL_OPTION);
				
				if (user != null)
				{
					User temp = aTurn.getUser(user);
					
					if (temp != null)
					{
						aTask.addUser(temp);
						JOptionPane.showMessageDialog(null, temp.getName() + " has been added to the task");
					}
					else if (!user.equals(""))
					{
						JOptionPane.showMessageDialog(null, "User Does Not Exist");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No User Added", "Turns", JOptionPane.OK_OPTION);
					}
				}
			}
			else if (toggledText.equals("Delete Task"))
			{
				int n = JOptionPane.showConfirmDialog(null, "Delete Task?", "Turns", JOptionPane.YES_NO_OPTION);
				
				if (n == JOptionPane.YES_OPTION)
				{
					aTask.getCreator().deleteTask(aTask);
				}
			}
			else if (toggledText.equals("Remove User"))
			{
				String user = JOptionPane.showInputDialog(null, "Enter Username to Remove.");
				if(user == null) {
					return;
				}
				
				User temp = aTurn.getUser(user);
				
				if (aTask.getUserList().contains(temp))
				{
					aTask.removeUser(temp);
					JOptionPane.showMessageDialog(null, temp.getName() + " has been removed from the task");
				}
				else if (!user.equals(""))
				{
					JOptionPane.showMessageDialog(null, "User Does Not Exist Or Is Not In The Task");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No User Removed", "Turns", JOptionPane.OK_OPTION);
				}
			}
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
