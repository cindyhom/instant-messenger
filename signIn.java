import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sun.glass.events.MouseEvent;

public class signIn  {
	JFrame chatWindow; 
	JFrame error_window; 
	JLabel ip_address;
	JLabel port_num;
	JLabel username; 
	JTextField choose_ip;
	JTextField choose_port;
	JTextField choose_name; 
	JButton connect; 
	JLabel welcome_message; 

	private String user_ip = "";
	private int user_port = -111;
	private String user_name = ""; 
			
	public Boolean has_correct_info = false; 
	
	public Boolean has_info(){
		return has_correct_info; 
	}
	
	public JFrame get_frame(){
		return chatWindow;
	}
	
	public String get_user_ip(){
		return user_ip;
	}
	
	public int get_user_port(){
		return user_port; 
	}
	
	public String get_user_name(){
		return user_name; 
	}
	
	
	public void set_user_ip(String a){
		user_ip = a;
	}
	
	public void set_user_port(String b){
		user_port = Integer.parseInt(b); 
		 
	}
	
	public void set_user_name(String c){
		user_name = c; 
	}
	
	
	
	signIn(){
		get_with_it(); 
	}
		
	public void get_with_it(){
	error_window = new JFrame("ERROR: Insufficient information"); 
	JPanel set = new JPanel(); 
	set.setLayout(new GridBagLayout());
	GridBagConstraints locate = new GridBagConstraints(); 
	locate.fill = GridBagConstraints.HORIZONTAL; 
	
	error_window.setSize(260, 200);
	JLabel mensaje = new JLabel("Please information in all three fields");
	locate.gridx = 0;
	locate.gridy = 0;
	set.add(mensaje, locate); 
	

	JButton okay = new JButton("Okay"); 
	locate.gridx = 0; 
	locate.gridy = 1; 
	okay.setSize(50, 50);	
	okay.addActionListener(new OkayButtonListener());	
	set.add(okay, locate); 
	error_window.add(set); 


		
	chatWindow = new JFrame("Chatroom Sign In");
	JPanel pane = new JPanel();
	chatWindow.setSize(360, 300);

	pane.setLayout(new GridBagLayout());
	GridBagConstraints place = new GridBagConstraints(); 
	place.fill = GridBagConstraints.HORIZONTAL; 
	
	welcome_message = new JLabel("Please enter the following information: \n"); 
	place.gridx = 1;
	place.gridy = 0;
	pane.add(welcome_message, place); 
	
	ip_address = new JLabel("IP Address: "); 
	place.gridx = 0;
	place.gridy = 2;
	pane.add(ip_address, place);
	
	choose_ip = new JTextField(20);		
	place.gridx = 1;
	place.gridy = 2;
	pane.add(choose_ip, place);
	
	port_num = new JLabel("Port Number: ");
	place.gridx = 0;
	place.gridy = 3;
	pane.add(port_num, place);
	
	
	choose_port = new JTextField(20);	
	place.gridx = 1;
	place.gridy = 3;
	pane.add(choose_port, place);
	
	
	
	username = new JLabel("UserName: ");
	place.gridx = 0;
	place.gridy = 4;
	pane.add(username, place);
	
	choose_name = new JTextField(20);	
	place.gridx = 1;
	place.gridy = 4;
	pane.add(choose_name, place);
	
	
	connect = new JButton("Connect!");
	connect.setSize(100, 60);
	place.gridx = 1;
	place.gridy = 7;
	
	
	connect.addActionListener(new ConnectButtonListener());  
	pane.add(connect, place);
	chatWindow.add(pane); 
	chatWindow.setVisible(true);
	
	}

	
	 class ConnectButtonListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            set_user_ip(choose_ip.getText()); 
				set_user_port(choose_port.getText()); 
				set_user_name(choose_name.getText()); 
				chatWindow.setVisible(false); 
	        
				if (choose_name.getText().equals("")|| choose_port.getText().equals("") || choose_ip.getText().equals("")){
					System.out.println("we have an issue");
					chatWindow.setVisible(true);
					error_window.setVisible(true);	
					
	        }
				else {
					System.out.println("username: " + get_user_name());
					System.out.println("user port: " + get_user_port());
					System.out.println("user ip: " + get_user_ip());
					has_correct_info = true; 
					return; 
					//chatWindow.dispose();
					
				}
	    }
	 }
	        
	        
	 class OkayButtonListener implements ActionListener {

	        public void actionPerformed(ActionEvent e) {
	            error_window.setVisible(false);
	        }
	    } 
	
	
	
	

	
	
	public static void main(String[] args){
		 
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				
				signIn open = new signIn();
				if(open.has_info())
				{
					System.out.println("I am here");
					open.notify(); 	
					return; 
				}

				
			}
			
			
		}); 
				
	}



	
	
}//END class Window




