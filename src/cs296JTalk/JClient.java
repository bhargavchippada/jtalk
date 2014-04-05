package cs296JTalk;

import java.io.IOException;
import java.net.Socket;

public class JClient
{
      String serverName ;
      int port ;
      public Socket client;
      public JChatComm Sess;
      public JClient() throws IOException{}
      public void callServer(String sername,int portnum){   
      serverName = sername;
      port = portnum;
      try
      {
         client = new Socket(serverName, port);
         Sess=new JChatComm(client);
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
      
}
