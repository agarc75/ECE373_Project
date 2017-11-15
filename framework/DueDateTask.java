package framework;

import java.util.Date;
import java.io.Serializable;

public class DueDateTask extends Task implements Serializable
{
	//fields for DueDateTask//
	private Date duedate;
	private boolean status;
	
	//constructors for DueDateTask//
	public DueDateTask()
	{
		this.duedate = null;
		this.status = false;
	}
	
	public DueDateTask(String aname, User acreator, Date duedate)
	{
		super(aname, acreator);
		this.duedate = duedate;
		this.status = false;
	}
	
	
	//methods for DueDateClass//
	public void setDueDate(Date adate)
	{
		this.duedate = adate;
	}
	
	public Date getDate()
	{
		return this.duedate;
	}
	
	public void setBool(boolean astatus)
	{
		status = astatus;
	}
	
	public boolean getBool()
	{
		return this.status;
	}
	
}
