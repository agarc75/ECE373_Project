package testDrivers;

import framework.Task;
import framework.User;


public class DriverTask {
	public void main() {
		User user1 = new User("Jim", "thelegend27", "youknow@gmail.com", "1234");
		User user2 = new User("Aza", "elguapo", "aza@gmail.com", "2468");
		User user3 = new User("Aaron", "themyth", "aaron@aol.com", "1357");
		Task task1 = new Task();
		
		task1.setName("TestTask1");
		task1.setCreater(user1);
		//User should also appear in user list
		
		//Adding other users to user list
		task1.addUser(user2);
		task1.addUser(user3);
		
		//Sets the user that needs to complete the task
		task1.setCurrentUser(user2);
		
		//print method to check what is being output
		//Prints out creator
		System.out.println("The creater for " + task1.getName() + " is: " 
		+ task1.getCreater());
		
		
		
		
	}
	
	
	

}
