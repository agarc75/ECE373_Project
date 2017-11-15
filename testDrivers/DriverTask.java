/* READ BEFORE USE
 * 
 * The Task driver tests every method of the User class. Users are created and then added to the 
 * tasks. This is tested by printing out Jim, Aza, Aaron. The creator should be Jim and is printed as such
 * The remove user and add user methods are tested by adding Jim, Aza, and Aaron. The remove is tested by removing Aaron
 * Correct responses are printed after.
 * 
 * To use the driver, simply run it a a java application.
 */

package testDrivers;

import framework.Task;
import framework.User;


public class DriverTask 
{
	public static void main(String args[]) 
	{
		User user1 = new User("Jim", "thelegend27", "youknow@gmail.com", "1234");
		User user2 = new User("Aza", "elguapo", "aza@gmail.com", "2468");
		User user3 = new User("Aaron", "themyth", "aaron@aol.com", "1357");
		Task task1 = new Task();
		
		task1.setName("TestTask1");
		task1.setCreator(user1);
		//User should also appear in user list
		
		//Adding other users to user list
		task1.addUser(user2);
		task1.addUser(user3);
		
		//Sets the user that needs to complete the task
		task1.setCurrentUser(user1);
		
		//print method to check what is being output
		//prints out all users
		System.out.println("Users in this task are: ");
		for(int i=0; i < task1.getUserList().size(); i++) {
			System.out.println(task1.getUserList().get(i).getName());
		}
		
		//Prints out creator Jim
		System.out.println("\nThe creater for " + task1.getName() + " is: " 
		+ task1.getCreator().getName());
		System.out.println("Correct: Jim");
		
		//Prints the current users and changes. should be jim
		System.out.println("\nThe current user for the task is: " + task1.getCurrentUser().getName());
		System.out.println("Correct: Jim");
		
		//updates current user. should be aza
		task1.nextUser();
		System.out.println("\nThe current user for the task is: " + task1.getCurrentUser().getName());
		System.out.println("Correct: Aza");
		
		//updates current user. should be aaron
		task1.nextUser();
		System.out.println("\nThe current user for the task is: " + task1.getCurrentUser().getName());
		System.out.println("Correct: Aaron");
		
		//removes user aaron from task
		task1.removeUser(user3);
		//prints out all users
		System.out.println("\nThe remaining users in this task are: ");
		for(int i=0; i < task1.getUserList().size(); i++) {
			System.out.println(task1.getUserList().get(i).getName());
		}
		System.out.println("Correct: \nJim\nAza");
		
		//Testing to change the order
		task1.changeOrder(0, user2);
		//Aza should now be first
		//prints out all users
		System.out.println("\nNew position for users in this task are: ");
		for(int i=0; i < task1.getUserList().size(); i++) {
			System.out.println(task1.getUserList().get(i).getName());
		}
		System.out.println("Correct: \nAza\nJim");
		
		//Removing missing user should return false since user is not there
		System.out.println("\nRemoving Aaron who was already removed");
		System.out.println("Output: " + task1.removeUser(user3) + "\nCorrect: false");
		
		
	}
	
	
	

}
