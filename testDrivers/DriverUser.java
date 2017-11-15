/* READ BEFORE USE
 * 
 * The User driver tests every method of the User class. The methods are tested using a
 * combination of boolean, String, and ArrayList methods. All expected outputs are printed
 * out next to the actual method output.
 * 
 * To use the driver, simply run it a a java application.
 */

package testDrivers;

import framework.User;
import framework.Group;
import framework.Task;

public class DriverUser
{
	public static void main(String args[])
	{
		User user = new User("Aaron Garcia", "agarc75", "agarc75@yahoo.com", "p@SSworD");
		
		User friend = new User("friend1", null, null, null);
		
		Group group = new Group();
		Task task = new Task("task1", user);
		
		//User method testing
		
		System.out.println("User method testing\n");
		
		System.out.println("addFriend(Friend friend): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.addFriend(friend)) + "\n");
		
		System.out.println("getFriends(): Expected output -- friend1");
		System.out.println("Output: " + user.getFriends().get(0).getName() + "\n");
		
		System.out.println("removeFriend(Friend friend): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.removeFriend(friend)) + "\n");
		
		System.out.println("addTask(Task task): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.addTask(task)) + "\n");
		
		System.out.println("getTasks(): Expected output -- task1");
		System.out.println("Output: " + user.getTasks().get(0).getName() + "\n");
		
		System.out.println("removeTask(Task task): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.removeTask(task)) + "\n");
		
		System.out.println("addGroup(Group group): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.addGroup(group)) + "\n");
		
		System.out.println("getGroups(): Expected output -- Unknown");
		System.out.println("Output: " + user.getGroups().get(0).getName() + "\n");
		
		System.out.println("removeGroup(Group group): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.removeGroup(group)) + "\n");
		
		System.out.println("setPassword(String password): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.setPassword("1234")) +  "\n");
		
		System.out.println("validate(String password): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.validate("1234")) + "\n");
		
		System.out.println("getName(): Expected output -- Aaron Garcia");
		System.out.println("Output: " + user.getName() + "\n");
		
		System.out.println("setEmail(String email): Expected output -- true");
		System.out.println("Output: " + Boolean.toString(user.setEmail("agarc75@email.arizona.edu")) + "\n");
		
		
		System.out.println("getEmail(): Expected output -- agarc75@email.arizona.edu");
		System.out.println("Output: " + user.getEmail() + "\n");
		
		System.out.println("getUsername(): Expected output -- agarc75");
		System.out.println("Output: " + user.getUsername() + "\n");
	}
}
