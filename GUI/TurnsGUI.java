package GUI;
import framework.Turns;

public class TurnsGUI
{
	private static Turns turn;
	
	public static void main(String[] arg)
	{
		new LoginGUI(turn);
	}
}