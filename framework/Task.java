package framework;

import java.util.ArrayList;
import java.io.Serializable;

public class Task implements Serializable
{
	private String name;
	private User creator;
	private ArrayList<User> users;
	private User currentuser;
	
	public Task()
	{
		name = "";
		creator = null;
		users = new ArrayList<User>();
		currentuser = null;
	}
	
	public Task(String name, User creator)
	{
		this.name = name;
		this.creator = creator;
		creator.addTask(this);
		users = new ArrayList<User>();
		currentuser = null;
		users.add(creator);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setCreator(User creator)
	{
		this.creator = creator;
		addUser(creator);
	}
	
	public User getCreator()
	{
		return this.creator;
	}
	
	public ArrayList<User> getUserList()
	{
		return this.users;
	}
	
	public void setCurrentUser(User user)
	{
		this.currentuser = user;
	}
	
	public User getCurrentUser()
	{
		return this.currentuser;
	}
	
	//****Methods*******
	public boolean addUser(User user)
	{
		if (this.users.contains(user))
		{
			return false;
		}
		else
		{
			this.users.add(user);
			return true;
		}
	}
	
	public boolean removeUser(User user)
	{
		if(this.users.contains(user))
		{
			this.users.remove(user);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void nextUser()
	{
		if (this.users.indexOf(this.currentuser) == this.users.size() - 1)
		{
			this.currentuser = this.users.get(0);
		}
		else
		{
			this.currentuser = this.users.get(this.users.indexOf(currentuser) + 1);
		}
	}
	
	public void changeOrder(int pos, User user)
	{
		if(this.removeUser(user) && pos < this.users.size() )
		{
			this.users.add(pos, user);
		}
	}
	
}