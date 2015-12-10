import java.util.*;
public class Priority {
	private String[][] patients;
	private int length;
	public Priority(int max)
	{
		patients = new String[max][2];
	}
	public void addPatient(String name)
	{
		if(length + 1 >= patients.length)
			throw new IllegalStateException("Can't add to a full Queue.");
		patients[length][0] = name;
		length++;
	}
	public void addPriorityPatient(String name)
	{
		if(length + 1 >= patients.length)
			throw new IllegalStateException("Can't add to a full Queue.");
		patients[length][0] = name;
		patients[length][1] = "priority";
		length++;
	}
	public String peek()
	{
		if(length == 0)
			throw new IllegalStateException("No people in Queue."); 
		return patients[0][0];
	}
	public void dequeue()
	{
		if(length == 0)
			throw new IllegalStateException("No people in Queue."); 
		patients[0] = null;
		for(int i = 0; i < length-1; i++)
		{
			patients[i] = patients[i+1];
		}
		patients[length] = null;
		length--;
	}
}
