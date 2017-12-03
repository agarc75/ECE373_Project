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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import framework.Task;
import framework.Turns;

public class TaskListGUI extends JPanel 
{
	private static final long serialVersionUID = 1L;
	Turns turn = null;
	ArrayList<Task> tempTaskList = null;
	
	Color ButtonColor = new Color(102, 178, 255);
	Font font = new Font("Ariel", Font.PLAIN, 15);
	ArrayList<JToggleButton> btn = new ArrayList<JToggleButton>();
	private ButtonGroup btnGroup = new ButtonGroup();
	
	Font taskLabelFont = new Font("Ariel", Font.BOLD, 25);
	JLabel tasksLabel = new JLabel("Tasks");
	
	MainScreenGUI tempFrame;
	
	
	
	public TaskListGUI(Turns turn, MainScreenGUI frame) {
		this.turn = turn;
		tempTaskList = turn.getCurrentUser().getTasks();
		tempFrame = frame;
		
		
		Dimension buttonSize = new Dimension(300, 50);
		
		tasksLabel.setForeground(Color.LIGHT_GRAY);
		tasksLabel.setFont(taskLabelFont);
		
		
		setBackground(Color.DARK_GRAY);
		
		//Adds label to top
		add(tasksLabel);
		
		for (int i = 0; i < tempTaskList.size(); i++)
		{
		    btn.add(new JToggleButton(tempTaskList.get(i).getName()));
		    btn.get(i).addActionListener(new buttonListener());
		    btn.get(i).setPreferredSize(buttonSize);
		    btn.get(i).setMaximumSize(buttonSize);
		    btn.get(i).setFont(font);
		    btn.get(i).setForeground(Color.WHITE);
		    btn.get(i).setBorder(new LineBorder(Color.BLACK));
		    btn.get(i).setFocusPainted(true);
			btn.get(i).setBackground(ButtonColor);
			btnGroup.add(btn.get(i));
		    add(btn.get(i));
		    
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
	}
	
	private class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JToggleButton source = (JToggleButton)(e.getSource());
			int index = btn.indexOf(e.getSource());
			if(source.equals(btn.get(index)))
			{
				turn.setCurrentTask(tempTaskList.get(index));
				tempFrame.addCurrentTaskGUI();
			}
		}
		
	}
}
