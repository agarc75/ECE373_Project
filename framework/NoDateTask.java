package framework;

import java.io.Serializable;

public class NoDateTask extends Task implements Serializable
{
	//fields for NoDueDate//
	private int cyclelimit;
	
	//constructor for NoDueDate//
	public NoDateTask()
	{
		cyclelimit = 0;
	}
	
	public NoDateTask(String aname, User acreator, int cycletime)
	{
		super(aname, acreator);
		this.cyclelimit = cycletime;
	}
	
	//methods for NoDateTask//
	
	public void setCycleLimit(int acyclelimit)
	{
		this.cyclelimit = acyclelimit;
	}
	
	public int getCycleTime()
	{
		return this.cyclelimit;
	}
}
