package cs296JTalk;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JPacket implements Serializable{
	JMessage jmessage;
	String date_time;
	public JPacket(String mess)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		date_time = sdf.format(date);
		jmessage = new JMessage(mess);
	}
	public void print()
	{
		System.out.println(jmessage.message+" "+date_time);
	}
}
