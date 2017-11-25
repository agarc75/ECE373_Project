package GUI;

import framework.Turns;
import framework.User;

public class TurnsGUI
{
	
	
	public static void main(String[] arg)
	{	
		//Test user
		Turns turn = new Turns();
		User ravila = new User("Rigo Avila", "ravila", "ravila@email.com", "1234");
		turn.addUser("ravila", ravila);
		
		new LoginGUI(turn);
		
		//Returns true if user logins in or creates account successfully
		if(LoginGUI.getCorrectUser()) {
			System.out.println("Welcome User");
		}
		
	}
}