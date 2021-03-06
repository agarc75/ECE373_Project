package GUI.MainMenuGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import framework.Task;
import framework.Turns;
import framework.User;

public class delMulTaskGUI {
	private Turns turn = null;
	
	private JDialog dialog = new JDialog();
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	
	//Labels
	private JLabel selTasksLabel = new JLabel("Select the tasks you want to remove:");

	//Buttons
	private JButton okButton = new JButton("Okay");
	private JButton cancelButton = new JButton("Cancel");
	
	//For removing tasks
	private JScrollPane removeTaskScroll;
	private JPanel taskPanel;
	private ArrayList<JCheckBox> btn = new ArrayList<JCheckBox>();
	private ArrayList<Task> taskList = null;
	private ArrayList<Task> delTempTasks = new ArrayList<Task>();
	
	public delMulTaskGUI(Turns turn) {
		this.turn = turn;
		this.taskList = turn.getCurrentUser().getTasks();
	}
	
	public void newDelMulTaskGUI() {
		panel.setBackground(Color.LIGHT_GRAY);
		
		taskPanel = new JPanel();
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		
		taskList = turn.getCurrentUser().getTasks();
		
		okButton.addActionListener(new buttonListener());
		cancelButton.addActionListener(new buttonListener());
		
		//Changes java icon
		BufferedImage myPicture = null;
		
		try {
			myPicture = ImageIO.read(new File("./GUIItems/deleteLogo.PNG"));
		}
		 catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		//Picture
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(75, 75, Image.SCALE_FAST)));
		
		for(int i = 0; i < taskList.size(); i++)
		{
			btn.add(new JCheckBox(taskList.get(i).getName()));
			btn.get(i).addItemListener(new checkBoxListener());
			taskPanel.add(btn.get(i));
		}
		
		removeTaskScroll = new JScrollPane(taskPanel);
		removeTaskScroll.setPreferredSize(new Dimension(200, 100));
		
		
		//Login GUI Formatting
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 0, 5);
		panel.add(picLabel, c);
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(selTasksLabel, c);
		
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(removeTaskScroll, c);
		
		c.gridwidth = 1;
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 0;
	    c.gridy = 7;
	    panel.add(okButton, c);
		
	    c.weighty = 5;
		c.weightx = 2;
		c.gridx = 1;
	    c.gridy = 7;
		panel.add(cancelButton, c);
		
		dialog.setContentPane(panel);
		//Used to center on page
		dialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - 150,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - 200);
		dialog.setTitle("Delete Multiple Tasks");
		dialog.setSize(350, 400);
		dialog.setVisible(true);
		
	}
	
	private class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(okButton))
			{
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all these task", "Confirm", JOptionPane.YES_NO_OPTION);
				if(n != JOptionPane.YES_OPTION) {
					return;
				}
				n = JOptionPane.showConfirmDialog(null, "This is irreversible. Are you 100% sure?", "Caution", 0);
				if(n != JOptionPane.YES_OPTION)
				{
					return;
				}
				
				
				for(int i = 0; i < delTempTasks.size(); i++)
				{
					if(delTempTasks.get(i).getCreator() == turn.getCurrentUser()) {
						turn.getCurrentUser().deleteTask(delTempTasks.get(i));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Task \"" + delTempTasks.get(i).getName() + "\" is not yours to delete" , "Error", 0);
					}
					
				}
				dialog.setVisible(false);
				dialog.dispose();
				
			}
			if(source.equals(cancelButton))
			{
				dialog.setVisible(false);
				dialog.dispose();
			}
			
		}
		
	}
	
	private class checkBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox source = (JCheckBox)(e.getSource());
			int index = btn.indexOf(e.getSource());
			if(source.equals(btn.get(index)))
			{
				if(btn.get(index).isSelected())
				{
					System.out.println("Selected" + index);
					delTempTasks.add(taskList.get(index));
				}
				else if(btn.get(index).isSelected() == false)
				{
					System.out.println("Deselected "+ index);
					delTempTasks.remove(taskList.get(index));
				}
				
			}
		}
	}
}
