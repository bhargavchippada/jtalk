package cs296JTalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SendMessTh extends Thread{
	public JChatComm comm;	
	public SendMessTh(JChatComm jcom)
	{
		comm=jcom;
	}
	public void run() 
	{
		while(comm.connopen)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				if(System.in.available()!=0) {
				String str = br.readLine();
				comm.sendMessage(str);
				}
			} catch (IOException e) {
			}
		}
	}
}
