import java.util.HashMap;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


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
		for (User someUser: users.values())
		{
			if (someUser.getEmail().equals(email))
			{
				return someUser;
			}
		}
		
		return null;
	}
	
	public static void saveData(Turns turns)
	{
		FileOutputStream outFile = null;
		ObjectOutputStream outObject = null;
		
		try
		{
			outFile = new FileOutputStream("Turns.ser");
			outObject = new ObjectOutputStream(outFile);
			
			outObject.writeObject(turns);
			
			outObject.close();
			outFile.close();
		}
		catch (IOException i)
		{
			i.printStackTrace();
		}
	}
	
	public static Turns loadData()
	{
		FileInputStream inFile = null;
		ObjectInputStream inObject = null;
		
		Turns turns = null;
		
		try
		{
			inFile = new FileInputStream("Turns.ser");
			inObject = new ObjectInputStream(inFile);
			
			turns = (Turns) inObject.readObject();
			
			inObject.close();
			inFile.close();
		}
		catch (IOException i)
		{
			i.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return turns;
	}
	
}
