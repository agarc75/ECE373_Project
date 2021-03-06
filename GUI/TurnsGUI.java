package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import GUI.MainMenuGUI.taskMenuGUI;
import framework.Group;
import framework.Task;
import framework.Turns;
import framework.User;
import java.util.GregorianCalendar;
import sun.security.x509.IssuerAlternativeNameExtension;

public class TurnsGUI
{
	
	
	public static void main(String[] arg) throws IOException
	{	
		//Test user
		Turns turn = new Turns();
		User user1 = new User("Rigo Avila", "ravila", "1", "123456");
		User user2 = new User("Aza Cordova", "elguapo", "aza@gmail.com", "123456");
		User user3 = new User("Aaron Garcia", "themyth", "aaron@aol.com", "123456");
		User user4 = new User("Kevin Fish", "thelegend", "test@aol.com", "123456");
		User user5 = new User("Guy Person", "guy", "guy@gmail.com", "123456");
		User user6 = new User("Roger Jimenez", "rogs", "roger@gmail.com", "123456");
		User user7 = new User("pleb", "pleb", null, null);
		
		
		//test task
		Task task1 = new Task("Trask Rotation", user1);
		Task task2 = new Task("Dish Rotation", user1);
		Task task3 = new Task("Copy Paper", user1);
		Task task4 = new Task("Finalize Budget", user1);
		Task task5 = new Task("Can't Delete", user2);
		Task task7 = new Task("Not your turn", user1);
		Task task8 = new Task("More than 5", user1);
		Task task9 = new Task("Remove User", user1);
		Task task10 = new Task("Stuff5", user1);
		Task task11 = new Task("Stuff6", user1);
		Task task12 = new Task("Stuff7", user1);
		
		
		
		task1.addUser(user2);
		task1.addUser(user3);
		task1.addUser(user4);
		task1.addUser(user5);
		task1.setDueDate(new GregorianCalendar(2017, 12, 4));
		
		task2.addUser(user2);
		task2.addUser(user3);
		task2.addUser(user4);
		
		task3.addUser(user2);
		task3.addUser(user3);
		
		task4.addUser(user2);
		
		task5.addUser(user1);
		task5.addUser(user3);
		task5.addUser(user4);
		task5.addUser(user5);
		
		task7.addUser(user2);
		task7.addUser(user3);
		task7.addUser(user4);
		task7.addUser(user5);
		
		
		task8.addUser(user2);
		task8.addUser(user3);
		task8.addUser(user4);
		task8.addUser(user5);
		task8.addUser(user6);
		task8.addUser(user7);
		
		
		task9.addUser(user2);
		task9.addUser(user3);
		task9.addUser(user4);
		task10.addUser(user2);
		task10.addUser(user3);
		task11.addUser(user2);
		task11.addUser(user3);
		task12.addUser(user2);
		task12.addUser(user3);
		
		
		turn.addUser("ravila", user1);
		turn.addUser("elguapo", user2);
		turn.addUser("themyth", user3);
		turn.addUser("thelegend", user4);
		turn.addUser("guy", user5);
		turn.addUser("rogs", user6);
		turn.addUser("pleb", user7);
		
		user1.addFriend(user2);
		user1.addFriend(user3);
		user1.addFriend(user4);
		user1.addFriend(user5);
		user1.addFriend(user6);
		user1.addFriend(user7);
		
		Group group1 = new Group("Roommates");
		user1.addGroup(group1);
		Group group2 = new Group("work");
		user1.addGroup(group2);
		Group group3 = new Group("home");
		user1.addGroup(group3);
		Group group4 = new Group("School");
		user1.addGroup(group4);
		
		group1.addMember(user2);
		group1.addMember(user3);
		group1.addMember(user4);
		group1.addMember(user5);
		
		group2.addMember(user2);
		group2.addMember(user3);
		group2.addMember(user4);
		group3.addMember(user5);
		
		
		//Loads data on startup
		/*File tmpDir = new File("Turns.ser");
		if(tmpDir.exists() == true)
		{
			turn = Turns.loadData();
		}
		else
		{
			Turns.saveData(turn);
		}*/
	
		File tmpDir = new File("Turns.ser");
		boolean exists = tmpDir.exists();
		if(exists == false) {
			File file = new File("Turns.ser");
			file.createNewFile();
			System.out.println("File created");
		}
		
		//Bypasses login for testing
		//turn.setCurrentUSer(user1);
		BufferedReader br = new BufferedReader(new FileReader("Turns.ser"));
		
		if (br.readLine() == null)
		{
			br.close();
		}
		else
		{
			br.close();
			turn = Turns.loadData();
		}
		
		new LoginGUI(turn);
		//new MainScreenGUI(turn);
		

		//taskMenuGUI temp = new taskMenuGUI(turn);
		//temp.newTaskGUI();
		
		
	}
}