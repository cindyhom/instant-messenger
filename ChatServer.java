import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ChatServer implements Runnable
{  
   private ArrayList<ChatServerThread> clients; // = new ArrayList<ChatServerThread>();
   private ServerSocket server = null;
   private Thread       thread = null;
   private int clientCount = 0;
  
   
   
   public ChatServer(int port)
   {  
	   clients  = new ArrayList<ChatServerThread>();
	   clients.clear();

	   try
      {  System.out.println("Binding to port " + port + ", please wait  ...");
         server = new ServerSocket(port);  
         System.out.println("Server started: " + server);
         start(); }
      catch(IOException ioe)
      {  System.out.println("Can not bind to port " + port + ": " + ioe.getMessage()); }
   }
   public void run()
   {  while (thread != null)
      {  try
         {  System.out.println("Waiting for a client ..."); 
            addThread(server.accept()); }
         catch(IOException ioe)
         {  System.out.println("Server accept error: " + ioe); stop(); }
      }
   }
   public void start()  { 
	   if (thread == null)
	      {  thread = new Thread(this); 
	         thread.start();
	      } 
	   }
   public void stop()   {
	   if (thread != null)
	      {  thread.stop(); 
	         thread = null;
	      }

	   }
   private int findClient(int ID)
   {  for (int i = 0; i < clientCount; i++)
         if (clients.get(i).getID() == ID)
            return i;
      return -1;
   }
   public synchronized void handle(int ID, String input)
   {  if (input.equals(".bye"))
      {  clients.get(findClient(ID)).send(".bye");
      
         remove(ID); }
      else
         for (int i = 0; i < clientCount; i++)
            clients.get(i).send(input);   
   }
   public synchronized void remove(int ID)
   {  int pos = findClient(ID);
      if (pos >= 0)
      {  ChatServerThread toTerminate = clients.get(pos);
         System.out.println("Removing client thread " + ID + " at " + pos);
         if (pos < clientCount-1)
            for (int i = pos+1; i < clientCount; i++)
            	clients.set((i-1), clients.get(i));
         clientCount--;
         try
         {  toTerminate.close(); }
         catch(IOException ioe)
         {  System.out.println("Error closing thread: " + ioe); }
         toTerminate.stop(); }
   }
   private void addThread(Socket socket)
   {    //if(clientCount < clients.size()){
	   clients.add(clients.size(), new ChatServerThread(this,socket));
	   System.out.println("Client accepted: " + socket);
	 //  	clients.set(clients.size(), new ChatServerThread(this, socket));
      	 
         try
         {  
        	clients.get(clients.size()-1).open();
        	clients.get(clients.size()-1).start(); 
        	clientCount++;
             }
         catch(IOException ioe)
         {  System.out.println("Error opening thread: " + ioe); } 
   }
   //else 
	//   System.out.println("ClientRefused: " + clientCount);
  // }

   public static void main(String args[]) { 
	   Boolean need_info = false;
	   signIn getStart = new signIn();
	   
	   while(!need_info){
		  need_info = getStart.has_info(); 
		 System.out.println(need_info.toString());
	   }
	   
	   System.out.println("Here we go");
	   
	  ChatServer server = new ChatServer(getStart.get_user_port()); 
	  System.out.println("Here we go2");
	   ChatClient proxy = new ChatClient(getStart.get_user_ip(), getStart.get_user_port(),
			   getStart.get_user_name()); 
  
    }
}

