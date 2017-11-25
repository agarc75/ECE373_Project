package GUI;

import framework.Task;
import framework.Turns;
import framework.User;

public class TurnsGUI
{
	
	
	public static void main(String[] arg)
	{	
		//Test user
		Turns turn = new Turns();
		User user1 = new User("Rigo Avila", "ravila", "1", "1234");
		User user2 = new User("Aza", "elguapo", "aza@gmail.com", "2468");
		User user3 = new User("Aaron", "themyth", "aaron@aol.com", "1357");
		
		//test task
		Task task1 = new Task("Trash", user1);
		Task task2 = new Task("Stuff1", user1);
		Task task3 = new Task("Stuff2", user1);
		Task task4 = new Task("Stuff3", user1);
		
		task1.addUser(user2);
		task1.addUser(user3);
		task2.addUser(user2);
		task2.addUser(user3);
		task3.addUser(user2);
		task3.addUser(user3);
		task4.addUser(user2);
		task4.addUser(user3);
		
		
		turn.addUser("ravila", user1);
		turn.addUser("elguapo", user2);
		turn.addUser("themytho", user3);
		
		
		//new LoginGUI(turn);
		
		//Bypasses login for testing
		turn.setCurrentUSer(user1);
		new MainScreenGUI(turn);
		
		
		
	}
}