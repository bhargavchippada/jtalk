package cs296JTalk;

import java.io.Serializable;

public class JMessage implements Serializable{
	String message;
	public JMessage(String mess)
	{
		if(mess.length()<=140)
		message=mess;
		else
		{
			message=mess.substring(0,140);
		}
	}
}
