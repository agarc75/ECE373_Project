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
	
	public boolean validate(String password)
	{
		return this.password.equals(password);
	}
	
	public boolean addGroup(Group group)
	{
		return groups.add(groups);
	}
	
	public boolean removeGroup(Group group)
	{
		return groups.remove(group);
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public ArrayList<Task> getTaskList()
	{
		return this.tasks;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getUsername()
	{
		return this.username;
	}
}
