package GUI;

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
		User user2 = new User("Aza", "elguapo", "aza@gmail.com", "2468");
		User user3 = new User("Aaron", "themyth", "aaron@aol.com", "1357");
		User user4 = new User();
		User user5 = new User();
		
		//test task
		Task task1 = new Task("Trash", user1);
		Task task2 = new Task("Stuff1", user1);
		Task task3 = new Task("Stuff2", user1);
		Task task4 = new Task("Stuff3", user1);
		Task task5 = new Task("Stuff3", user1);
		Task task6 = new Task("Stuff3", user1);
		Task task7 = new Task("Stuff3", user1);
		Task task8 = new Task("Stuff3", user1);
		Task task9 = new Task("Stuff3", user1);
		Task task10 = new Task("Stuff3", user1);
		Task task11 = new Task("Stuff4", user1);
		Task task12 = new Task("Stuff5", user1);
		
		
		
		task1.addUser(user2);
		task1.addUser(user3);
		
		task2.addUser(user2);
		task2.addUser(user3);
		task2.addUser(user4);
		task2.addUser(user5);
		
		task3.addUser(user2);
		task3.addUser(user3);
		
		task4.addUser(user2);
		task4.addUser(user3);
		task5.addUser(user2);
		task5.addUser(user3);
		task6.addUser(user2);
		task6.addUser(user3);
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
		task12.addUser(user2);
		task12.addUser(user3);
		
		
		turn.addUser("ravila", user1);
		turn.addUser("elguapo", user2);
		turn.addUser("themytho", user3);
		
		
		new LoginGUI(turn);
		
		//Bypasses login for testing
		//turn.setCurrentUSer(user1);
		//new MainScreenGUI(turn);
		
		
		
	}
}