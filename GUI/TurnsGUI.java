package GUI;

import java.io.File;

import GUI.MainMenuGUI.taskMenuGUI;
import framework.Group;
import framework.Task;
import framework.Turns;
import framework.User;
import sun.security.x509.IssuerAlternativeNameExtension;

public class TurnsGUI
{
	
	
	public static void main(String[] arg)
	{	
		//Test user
		Turns turn = new Turns();
		User user1 = new User("Rigo Avila", "ravila", "1", "1234");
		User user2 = new User("Aza Cordova", "elguapo", "aza@gmail.com", "2468");
		User user3 = new User("Aaron Garcia", "themyth", "aaron@aol.com", "1357");
		User user4 = new User("Hello World", "thelegend", "test@aol.com", "1234");
		User user5 = new User();
		User user6 = new User();
		User user7 = new User();
		
		
		//test task
		Task task1 = new Task("Stuff1", user1);
		Task task2 = new Task("Stuff2", user1);
		Task task3 = new Task("Stuff3", user1);
		Task task4 = new Task("Stuff4", user1);
		Task task5 = new Task("Stuff5", user1);
		Task task7 = new Task("Stuff3", user1);
		Task task8 = new Task("Stuff3", user1);
		Task task9 = new Task("Stuff3", user1);
		Task task10 = new Task("Stuff3", user1);
		Task task11 = new Task("Stuff4", user1);
//		Task task12 = new Task("Stuff5", user1);
		
		
		
		task1.addUser(user2);
		task1.nextUser();
		
		task2.addUser(user2);
		task2.addUser(user3);
		
		task3.addUser(user2);
		task3.addUser(user3);
		task3.addUser(user4);
		task3.nextUser();
		
		task4.addUser(user2);
		task4.addUser(user3);
		task4.addUser(user4);
		task4.addUser(user5);
		task4.nextUser();
		task4.nextUser();
		
		task5.addUser(user2);
		task5.addUser(user3);
		task5.addUser(user4);
		task5.addUser(user5);
		task5.addUser(user6);
		task5.addUser(user7);
		
		task7.addUser(user2);
		task7.addUser(user3);
		task8.addUser(user2);
		task8.addUser(user3);
		task9.addUser(user2);
		task9.addUser(user3);
		task10.addUser(user2);
		task10.addUser(user3);
		task11.addUser(user2);
		task11.addUser(user3);
//		task12.addUser(user2);
//		task12.addUser(user3);
		
		
		turn.addUser("ravila", user1);
		turn.addUser("elguapo", user2);
		turn.addUser("themytho", user3);
		
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
		
		
		//Loads data on startup
		File tmpDir = new File("Turns.ser");
		if(tmpDir.exists() == true)
		{
			turn = Turns.loadData();
		}
		else
		{
			Turns.saveData(turn);
		}
		
		//new LoginGUI(turn);
		
		//Bypasses login for testing
		turn.setCurrentUSer(user1);
		new MainScreenGUI(turn);
		
		//turn.setCurrentUSer(user1);
		//taskMenuGUI temp = new taskMenuGUI(turn);
		//temp.newTaskGUI();
		
		
	}
}