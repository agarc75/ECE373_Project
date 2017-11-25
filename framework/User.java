package framework;

import java.util.ArrayList;
import java.io.Serializable;

public class User implements Serializable
{
	private String name;
	private String username;
	private String email;
	private String password;
	private String icon;
	private ArrayList<User> friends;
	private ArrayList<Task> tasks;
	private ArrayList<Group> groups;
	
	public User()
	{
	}
	
	public User(String name, String username, String email, String password)
	{
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.icon = null;
		this.friends = new ArrayList<User>();
		this.tasks = new ArrayList<Task>();
		this.groups = new ArrayList<Group>();
	}
	
	public boolean validatePassword(String password)
	{
		return this.password.equals(password);
	}
	
	
	public boolean addFriend(User user)
	{
		return friends.add(user);
	}
	
	public boolean removeFriend(User user)
	{
		return friends.remove(user);
	}
	
	public ArrayList<User> getFriends()
	{
		return friends;
	}
	
	public boolean addTask(Task task)
	{
		return tasks.add(task);
	}
	
	public boolean removeTask(Task task)
	{
		return tasks.remove(task);
	}

	public boolean addGroup(Group group)
	{
		return groups.add(group);
	}
	
	public boolean removeGroup(Group group)
	{
		return groups.remove(group);
	}
	
	public ArrayList<Group> getGroups()
	{
		return this.groups;
	}
	
	public boolean setPassword(String password)
	{
		this.password = password;
		
		return this.password.equals(password);
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public ArrayList<Task> getTasks()
	{
		return this.tasks;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public boolean setEmail(String email)
	{
		this.email = email;
		
		return this.email.equals(email);
	}
	
	public String getUsername()
	{
		return this.username;
	}
}