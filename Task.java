import java.util.ArrayList;
import java.io.Serializable;

public class Task implements Serializable
{
	private String name;
	private User creater;
	private ArrayList<User> users;
	private User currentuser;
	
	public Task()
	{
		name = "";
		creater = null;
		users = new ArrayList<User>();
		currentuser = null;
	}
	
	public Task(String name, User creater)
	{
		this.name = name;
		this.creater = creater;
		this.users = new ArrayList<User>();
		currentuser = null;
		this.users.add(creater);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setCreater(User creater)
	{
		this.creater = creater;
	}
	
	public User getCreater()
	{
		return this.creater;
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
	
	public void changeOrder(int pos, User user)
	{
		if(this.removeUser(user) && pos < this.users.size() )
		{
			this.users.add(pos, user);
		}
	}
	
}
