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
	public String dequeue()
	{
		int index = 0;
		if(length == 0)
			throw new IllegalStateException("No people in Queue."); 
		for(int i = length - 1; i >= 0; i--)
		{
			if(patients[i][1].equalsIgnoreCase("priority"))
				index = i;
		}
		length--;
		String name = patients[index][0];
		patients[index] = null;
		for(int i = index; i < length; i++)
		{
			patients[i] = patients[i+1];
		}
		patients[length] = null;
		return name;
	}
}
