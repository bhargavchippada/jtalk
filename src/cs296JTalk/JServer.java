package cs296JTalk;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class JServer
{
   private ServerSocket serverSocket;
   Socket server;
   public JChatComm Sess;
   int port = 5123;
   public JServer() throws IOException
   {
      serverSocket = new ServerSocket(port);
      Sess=new JChatComm(null);
   }

   public void acceptConnection() throws IOException, InterruptedException
   {
         try
         {
            System.out.println("Waiting for client on port " +serverSocket.getLocalPort() + "...");
            server = serverSocket.accept();
            Sess=new JChatComm(server);
         }
         catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
         }
   }
   
   
}
