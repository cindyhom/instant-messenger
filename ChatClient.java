import java.net.*;
import java.io.*;

public class ChatClient implements Runnable
{  private Socket socket              = null;
   private Thread thread              = null;
   private DataInputStream  console   = null;
   private DataOutputStream streamOut = null;
   private ChatClientThread client    = null;
   private int port	= -111;  
   private String name = null; 
   private Gui portal; 
   
   public ChatClient(String serverName, int serverPort, String username)
   
   {  portal = new Gui(); 
   	  portal.set_name(username);
   	  name = username; 
   	  
	//  System.out.println("Establishing connection. Please wait ...");
	  portal.chatWindow.append("Establishing connection. Please wait ...\n");
      try
      {  socket = new Socket(serverName, serverPort);
      	portal.chatWindow.append("Connected: " + socket + "\n");
       //  System.out.println("Connected: " + socket);
         start();
      }
      catch(UnknownHostException uhe)
      {  portal.chatWindow.append("Host unknown: " + uhe.getMessage() + "\n"); 
      
      }
      catch(IOException ioe)
      {  portal.chatWindow.append("Unexpected exception: " + ioe.getMessage()+ "\n"); }
   }
   
   public String get_name(){
	   return name; 
   }
   
   @SuppressWarnings("deprecation")
public void run()
   {  while (thread != null)
      {  try
         {  
    	  	//String news = console.readLine();
    	  String news = null; 
    	  	if(portal.get_full_mess()==null){
    	  		System.out.println(portal.get_full_mess()==null); 
    	  	}
    	  	else{
    	  		news = portal.get_full_mess(); 	
    	  		portal.set_full_mess(null);
    	  		streamOut.writeUTF(news);
    	  		streamOut.flush();    	  		
    	  	}

    	  	
    	  	
                    
            
         }
         catch(IOException ioe)
         {  portal.chatWindow.append("Sending error: " + ioe.getMessage());
            stop();
         }
      }
   }
   public String handle(String msg)
   {  if (msg.equals(".bye"))
      {  portal.chatWindow.append("Good bye. Press RETURN to exit ...");
         stop();
      }
      else
      {
    	  portal.chatWindow.append(msg + "\n"); 
          
      }
   return msg; 

   }
   public void start() throws IOException
   {  
	  console   = new DataInputStream(System.in);
      streamOut = new DataOutputStream(socket.getOutputStream());
      if (thread == null)
      {  client = new ChatClientThread(this, socket);
         thread = new Thread(this);                   
         thread.start();
      }
   }
   public void stop()
   {  if (thread != null)
      {  thread.stop();  
         thread = null;
      }
      try
      {  if (console   != null)  console.close();
         if (streamOut != null)  streamOut.close();
         if (socket    != null)  socket.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing ..."); }
      client.close();  
      client.stop();
   }
   
   
   
   public static void main(String args[])
   {  ChatClient client = null;
   
   Boolean need_info = false;
   signIn getStart = new signIn();
   
   while(!need_info){
	  need_info = getStart.has_info(); 
	 System.out.println(need_info.toString());
   }
   

   
   
   
   
   
   
   System.out.println("Here we go");
   
         client = new ChatClient(getStart.get_user_ip(), 
        		 getStart.get_user_port(), getStart.get_user_name());
  
   }
}
