package cs296JTalk;

import java.io.IOException;

public class RecvMessTh extends Thread{
	public JChatComm comm;
	public RecvMessTh(JChatComm jcom)
	{
		comm=jcom;
	}
	public void run() 
	{	
		while(comm.connopen)
		{
			try {
			comm.receiveMessage();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
			}
		}
	}
}
