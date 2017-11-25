package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import framework.Task;
import framework.Turns;

public class TaskListGUI extends JPanel 
{
	private static final long serialVersionUID = 1L;
	Turns turn = null;
	ArrayList<Task> tempTaskList = null;
	
	Color ButtonColor = new Color(102, 178, 255);
	Font font = new Font("Arial", Font.PLAIN, 15);
	
	public TaskListGUI(Turns turn) {
		tempTaskList = turn.getCurrentUser().getTasks();
		
		ArrayList<JButton> btn = new ArrayList<JButton>();
		
		Dimension buttonSize = new Dimension(300, 20);
		
		
		
		setBackground(Color.BLACK);
		setLayout(new GridLayout(10, 0));
		
		for (int i = 0; i < tempTaskList.size(); i++)
		{
		    btn.add(new JButton(tempTaskList.get(i).getName()));
		    btn.get(i).addActionListener(new buttonListener());
		    btn.get(i).setPreferredSize(buttonSize);
		    btn.get(i).setMinimumSize(buttonSize);
		    btn.get(i).setFont(font);
		    btn.get(i).setForeground(Color.WHITE);
			btn.get(i).setBackground(ButtonColor);
		    add(btn.get(i));
		    
		}
		
		
		setVisible(true);
	}
	
	private class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
