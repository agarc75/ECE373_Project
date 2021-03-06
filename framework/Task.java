package framework;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Task implements Serializable
{
	private String name;
	private User creator;
	private ArrayList<User> users;
	private User currentuser;
	private GregorianCalendar duedate;
	
	public Task()
	{
		name = "";
		creator = null;
		users = new ArrayList<User>();
		currentuser = null;
		this.duedate = null;
	}
	
	public Task(String name, User creator)
	{
		this.name = name;
		this.creator = creator;
		users = new ArrayList<User>();
		creator.addTask(this);
		currentuser = creator;
		users.add(creator);
	}
	
	public Task(String name, User creator, GregorianCalendar duedate)
	{
		this.name = name;
		this.creator = creator;
		creator.addTask(this);
		users = new ArrayList<User>();
		currentuser = creator;
		this.duedate = duedate;
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
		currentuser = creator;
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
	
	public void setDueDate(GregorianCalendar adate)
	{
		this.duedate = adate;
	}
	
	public GregorianCalendar getDate()
	{
		return this.duedate;
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
			user.addTask(this);
			return true;
		}
	}
	
	public boolean removeUser(User user)
	{
		if(this.users.contains(user))
		{
			if(user == this.getCurrentUser()) {
				this.nextUser();
			}
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
		User tempUser = null;
		
		if (this.users.indexOf(this.currentuser) == this.users.size() - 1)
		{
			this.currentuser = this.users.get(0);
		}
		else {
			tempUser = this.users.remove(0);
			this.currentuser = this.users.get(0);
			this.users.add(tempUser);
		}
		
		
	}
	
	public void changeOrder(int pos, User user)
	{
		if(this.removeUser(user) && pos < this.users.size() )
		{
			this.users.add(pos, user);
		}
	}
	
	public String getUserOrderString()
	{
		String temp = new String();
		int order = 1;
		
		temp += order + ") " + this.currentuser.getName() + ": " + this.currentuser.getUsername();
		order += 1;
		
		int currentUserIndex = this.users.indexOf(this.currentuser);
		
		
		for (int i = currentUserIndex + 1; i != this.users.size(); ++i)
		{
			if (i >= this.users.size())
			{
				i = 0;
			}
			
			temp += "<br />" + order + ") " + this.users.get(i).getName() + ": " + this.users.get(i).getUsername();
			
			order += 1;
		}
			
		return temp;
	}	
}
