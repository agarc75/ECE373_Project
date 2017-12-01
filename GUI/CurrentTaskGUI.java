package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import framework.Task;
import framework.Turns;
import framework.User;
import javafx.scene.shape.Circle;

public class CurrentTaskGUI extends JPanel {
		private Color darkRed = new Color(175,16, 16);
		private Turns turn;
		private Task currentTask;
		private int usersAmount = 0;
		Font userNameFont = new Font("Arial", Font.PLAIN, 20);
	   	private Dimension panelSize = new Dimension(500, 550);
	   
	   	public CurrentTaskGUI(Turns turn, Task selTask) 
	   	{
	   		this.turn = turn;
	   		this.currentTask = selTask;
	   		this.usersAmount = selTask.getUserList().size();
		   setBackground(Color.GRAY);
	    }
	    public void paintComponent(Graphics g)
	    {
		   // Call the base class paint method.
		   super.paintComponent(g);
		   
		   panelSize = this.getSize();
		   int radius = 150;
		   int xpos = ((int) panelSize.getWidth() / 2) - radius/2;
		   int ypos = ((int) panelSize.getHeight() / 4) - radius/2;
		   
		   System.out.println(currentTask.getCurrentUser().getUsername().length());
		   
			   switch (usersAmount) {
			   	case 2:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.drawString(currentTask.getCurrentUser().getUsername(), xpos, ypos);
			   		
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos, ypos + 200, radius, radius);
				
				break;
			   	case 3:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.drawString(currentTask.getCurrentUser().getUsername(), xpos, ypos);
				   
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 100, ypos + 200, radius, radius);
				   
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos - 100, ypos + 200, radius, radius);
					
				break;
			   	case 4:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.drawString(currentTask.getCurrentUser().getUsername(), xpos, ypos);
				   
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 100, ypos + 150, radius, radius);
			   		
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos, ypos + 300, radius, radius);
				   
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos - 100, ypos + 150, radius, radius);
				break;
			   	case 5:
			   		radius = radius - 25;
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.setColor(Color.WHITE);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getCurrentUser().getUsername(), xpos, ypos + radius / 2);
				   
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 150, ypos + 100, radius, radius);
			   		
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 100, ypos + 250, radius, radius);
			   		
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos - 100, ypos + 250, radius, radius);
				   
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos - 150, ypos + 100, radius, radius);
			   	
			   	break;
	
			   	default:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
				break;
			}
	   }
	    
	   
	   
	   
	   

}
