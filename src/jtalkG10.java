import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cs296JTalk.JChatComm;
import cs296JTalk.JClient;
import cs296JTalk.JServer;
import cs296JTalk.RecvMessTh;
import cs296JTalk.SendMessTh;

public class jtalkG10 {
public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
{
	JChatComm jchatcom;
	if(args.length==0)
	{
		JServer Serve=new JServer();
		Serve.acceptConnection();
		jchatcom=Serve.Sess;
		SendMessTh sendth=new SendMessTh(jchatcom);
		RecvMessTh recvth=new RecvMessTh(jchatcom);
		sendth.start();
		recvth.start();
        System.out.println("Enter 1 to accept connection or any other key to reject");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("1")){
            jchatcom.sendMessage("Sure. Let us begin.");
            System.out.println("Sure. Let us begin.");
            }
        else {
        	System.out.println("Disconnected");
        	jchatcom.sendMessage("End Chat");
        	}
	}
	else
	{
		JClient Clien=new JClient();
		Clien.callServer(args[0], 5123);
		jchatcom=Clien.Sess;
		jchatcom.sendMessage("Free for a chat?");
		System.out.println("Free for a chat?");
		SendMessTh sendth=new SendMessTh(jchatcom);
		RecvMessTh recvth=new RecvMessTh(jchatcom);
		sendth.start();
		recvth.start();
		Thread.sleep(10000);
		if(jchatcom.log.History.size()==1)
		{
			System.out.println("Server not Responding");
			jchatcom.endChat();
		}
		
	}
}
}


