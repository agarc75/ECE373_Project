package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import framework.DueDateTask;
import framework.Turns;

public class TaskDetailsGUI extends JPanel
{
	public TaskDetailsGUI (Turns turn, DueDateTask task)
	{
		JLabel taskName = new JLabel(task.getName());
		JTextArea currentUserOrder = new JTextArea("Current User Order\n\n" + task.getUserOrderString());
		
		add(taskName);
		add(currentUserOrder);
		
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
		
}
