package cs296JTalk;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class JChatComm {
	public JChatSession log;
	Socket conn;
	boolean connopen;
	public JChatComm(Socket soc)
	{
		connopen=true;
		conn=new Socket();
		conn=soc;
		log=new JChatSession();
	}
	public void sendMessage(String mess) throws IOException
	{
		JPacket Packet = new JPacket(mess);
		OutputStream os = conn.getOutputStream();  
		ObjectOutputStream oos = new ObjectOutputStream(os);   
		oos.writeObject(Packet);
		logMessage(Packet,"me");
		if(mess.equals("End Chat")) {
			endChat();}
	}
	public void receiveMessage() throws IOException, ClassNotFoundException
	{
		InputStream is = conn.getInputStream();
		if(is.available()==0){}
		else
		{
			//log.printLog();
			ObjectInputStream ois = new ObjectInputStream(is);  
			JPacket Packet = (JPacket)ois.readObject();
			Packet.print();
			logMessage(Packet,conn.getRemoteSocketAddress().toString());
			if(Packet.jmessage.message.equals("End Chat")) {
				endChat();}
		}
	}
	void logMessage(JPacket p,String who)
	{
		log.History.addElement(p);
		log.name.addElement(who);
	}
	public void endChat() throws IOException
	{
		conn.close();
		connopen=false;
		System.out.println("Ending the Chat");
	}

}
