package framework;

import java.util.ArrayList;
import java.io.Serializable;

public class Group implements Serializable
{
	//fields for Group//
	
	private String name;
	private ArrayList<User> members;
	
	//constructor for Group//
	
	public Group() 
	{
		this.name = "Unknown";
		this.members = null;
		
	}
	
	//methods for Group Class//
	
	public void setName(String Name)
	{
		this.name = Name;
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public ArrayList<User> getMembers()
	{
		return this.members;
	}
	
	public void addMember(User user)
	{
		this.members.add(user);
	}
	
	public void removeMember(User user)
	{
		this.members.remove(user);
	}
	
}
