package software;
import java.util.HashMap;
import people.User;
import java.io.Serializable;


public class Turns implements Serializable
{
	//fields for Turns//
	private HashMap<String,User> users;
	private User currentUser;
	
	//constructor for Turns//
	public Turns()
	{
		this.users = null;
		this.currentUser = null;
	}
	
	//methods for Turns//
	public void addUser(String userName, User user)
	{
		this.users.put(userName, user);
	}
	
	public void removeUSer(String userName, User user)
	{
		this.users.remove(userName,user);
		
	}
	
	public void setCurrentUSer(User user)
	{
		this.currentUser = user;
	}

	public User getCurrentUser()
	{
		return this.currentUser;
	}
	
	public User findUserEmail(String email)
	{
		User someUser = null;
		
		//missing hella code bruuuuv!!!!!//
		
		return someUser;
	}
	
}
