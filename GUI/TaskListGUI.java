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

import framework.Task;
import framework.Turns;

public class TaskListGUI extends JPanel 
{
	private static final long serialVersionUID = 1L;
	Turns turn = null;
	ArrayList<Task> tempTaskList = null;
	
	Color ButtonColor = new Color(102, 178, 255);
	Font font = new Font("Arial", Font.PLAIN, 15);
	
	Font taskLabelFont = new Font("Serif", Font.BOLD, 20);
	JLabel tasksLabel = new JLabel("Tasks");
	
	public TaskListGUI(Turns turn) {
		tempTaskList = turn.getCurrentUser().getTasks();
		
		ArrayList<JButton> btn = new ArrayList<JButton>();
		
		Dimension buttonSize = new Dimension(300, 50);
		
		tasksLabel.setForeground(Color.LIGHT_GRAY);
		tasksLabel.setFont(taskLabelFont);
		tasksLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		setBackground(Color.BLACK);
		
		//Adds label to top
		add(tasksLabel);
		
		for (int i = 0; i < tempTaskList.size(); i++)
		{
		    btn.add(new JButton(tempTaskList.get(i).getName()));
		    btn.get(i).addActionListener(new buttonListener());
		    btn.get(i).setPreferredSize(buttonSize);
		    btn.get(i).setMaximumSize(buttonSize);
		    btn.get(i).setFont(font);
		    btn.get(i).setForeground(Color.WHITE);
			btn.get(i).setBackground(ButtonColor);
		    add(btn.get(i));
		    
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
