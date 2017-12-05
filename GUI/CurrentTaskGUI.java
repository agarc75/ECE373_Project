package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		Font userNameFont = new Font("Arial", Font.PLAIN, 40);
	   	private Dimension panelSize = new Dimension(500, 550);
	   
	   	public CurrentTaskGUI(Turns turn, Task selTask) 
	   	{
	   		if(selTask != null) {
		   		this.turn = turn;
		   		this.currentTask = selTask;
		   		this.usersAmount = selTask.getUserList().size();
		   		setBackground(Color.GRAY);
	   		}
	    }
	    public void paintComponent(Graphics g)
	    {
		   // Call the base class paint method.
		   super.paintComponent(g);
		   
		   panelSize = this.getSize();
		   int radius = 150;
		   int xpos = ((int) panelSize.getWidth() / 2) - radius/2;
		   int ypos = ((int) panelSize.getHeight() / 4) - radius/2;
		   
		   //System.out.println(currentTask.getCurrentUser().getUsername().length());
		   
		   if(turn == null)
		   {
			   BufferedImage myPicture = null;
			   BufferedImage myBackground = null;
				
				try {
					myPicture = ImageIO.read(new File("./GUIItems/arrow1.PNG"));
					myBackground = ImageIO.read(new File("./GUIItems/currentTaskBackground.jpg"));
				}
				 catch (IOException exc) {
				    exc.printStackTrace();
				}
				
				int xpic = ((int) panelSize.getWidth() / 2) -100;
				int ypic = ((int) panelSize.getHeight() / 2) - 100;
				
				g.drawImage(myBackground.getScaledInstance(((int) panelSize.getWidth()),((int) panelSize.getHeight()), Image.SCALE_FAST), 0, 0, null);
				g.drawImage(myPicture.getScaledInstance(200, 200, Image.SCALE_FAST), xpic, ypic, null);
				
			   
		   }
		   else {
			   BufferedImage myCircleBackground = null;
				
				try {
					myCircleBackground = ImageIO.read(new File("./GUIItems/circleBackground.png"));
				}
				 catch (IOException exc) {
				    exc.printStackTrace();
				}
				
				g.drawImage(myCircleBackground.getScaledInstance(((int) panelSize.getWidth()),((int) panelSize.getHeight()), Image.SCALE_FAST), 0, 0, null);
				
			   
			   switch (usersAmount) {
			   	case 2:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.setColor(Color.WHITE);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getCurrentUser().getInitials(), xpos + radius /4 + 10, ypos + radius / 2 + 15);
			   		
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos, ypos + 200, radius, radius);
			   		g.setColor(Color.GRAY);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getUserList().get(1).getInitials(), xpos + radius /4 + 10, ypos + radius / 2 + 15 + 200);
			   	
				
				break;
			   	case 3:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.setColor(Color.WHITE);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getCurrentUser().getInitials(), xpos + radius /4 + 10, ypos + radius / 2 + 15);
				   
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 100, ypos + 200, radius, radius);
				   
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos - 100, ypos + 200, radius, radius);
			   		g.setColor(Color.GRAY);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getUserList().get(1).getInitials(), xpos + radius /4 + 10 - 100, ypos + radius / 2 + 15 + 200);
			   	
				break;
			   	case 4:
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.setColor(Color.WHITE);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getCurrentUser().getInitials(), xpos + radius /4 + 10, ypos + radius / 2 + 15);
				   
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 100, ypos + 150, radius, radius);
			   		
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos, ypos + 300, radius, radius);
				   
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos - 100, ypos + 150, radius, radius);
			   		g.setColor(Color.GRAY);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getUserList().get(1).getInitials(), xpos + radius /4 + 10 - 100, ypos + radius / 2 + 15 + 150);
			   	
				break;
			   	case 5:
			   		xpos+=18;
			   		radius = radius - 25;
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.setColor(Color.WHITE);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getCurrentUser().getInitials(), xpos + radius /4 + 4, ypos + radius / 2 + 15);
				   
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 150, ypos + 100, radius, radius);
			   					   		
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos + 100, ypos + 250, radius, radius);
			   		
			   		g.setColor(Color.GREEN);
			   		g.fillOval(xpos - 100, ypos + 250, radius, radius);
				   
			   		g.setColor(Color.ORANGE);
			   		g.fillOval(xpos - 150, ypos + 100, radius, radius);
			   		g.setColor(Color.GRAY);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getUserList().get(1).getInitials(), xpos + radius /4 + 10 - 160, ypos + radius / 2 + 15 + 100);
			   	
			   	break;
	
			   	default:
			   		BufferedImage myTurnArrows= null;
					ypos=+150;
					
					try {
						myCircleBackground = ImageIO.read(new File("./GUIItems/arrow1.png"));
					}
					 catch (IOException exc) {
					    exc.printStackTrace();
					}
					
					g.drawImage(myCircleBackground.getScaledInstance(300, 300, Image.SCALE_FAST), xpos - 75, ypos - 80, null);
					
			   		g.setColor(darkRed);
			   		g.fillOval(xpos, ypos, radius, radius);
			   		g.setColor(Color.WHITE);
			   		g.setFont(userNameFont);
			   		g.drawString(currentTask.getCurrentUser().getInitials(), xpos + radius /4 + 10, ypos + radius / 2 + 15);
				break;
			}
		   }
	   }
	    
	   
	   
	   
	   

}
