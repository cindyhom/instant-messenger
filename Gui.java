import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.swing.*;

public class Gui {
	
	JTextField userText;  
	JTextArea chatWindow;
	JButton sendFile; 
	JButton sendMessage; 
    JFrame window; 
    String name = null; 
    String full_mess = null; 
    Boolean mess_sent; 
    JScrollPane scrollPane;
    FileOutputStream fos = null;
    DataOutputStream streamOut = null; 
    
    Gui() {
    	go(); 
    }
    	
     
    public void go(){
    	mess_sent = false; 
    	name = "Mystery_user"; 
    	window = new JFrame("Chat Room"); 
    	window.setBackground(Color.blue);
    	window.setSize(400, 300);
    	
    	JPanel panel1 = new JPanel(new BorderLayout()); 
    	panel1.setBackground(Color.GRAY);
    	
    	
    	 	
    	userText = new JTextField(15); 
    	JPanel border = new JPanel(); 
    	border.setBackground(Color.GRAY);
    	panel1.add(userText, "Center");
    	sendMessage = new JButton("Send"); 
    	sendMessage.addActionListener(new ButtonListener());
    	panel1.add(sendMessage, "East"); 
    	panel1.add(border, "North");
    	
    	JPanel panel2 = new JPanel(new BorderLayout());
    	chatWindow = new JTextArea(); 
    	chatWindow.setEditable(false);
     	scrollPane = new JScrollPane();
     	scrollPane.getVerticalScrollBar(); 
     	//setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
     	//ScrollPaneConstraints.
     	chatWindow.add(scrollPane);    	
    	//scrollPane.setHorizionalScrollBarPolicy(HORIZONTAL_); 
     	panel2.add(chatWindow); 

    	
  
    	JPanel panel3 = new JPanel();
    	panel3.setLayout(new BorderLayout());
    	JPanel filler1 = new JPanel();
    	JPanel filler2 = new JPanel();
    	JPanel filler3 = new JPanel();
    	JPanel filler4 = new JPanel();
    	
    	filler1.setBackground(Color.GRAY);
    	filler2.setBackground(Color.GRAY);
    	filler3.setBackground(Color.GRAY);
    	filler4.setBackground(Color.GRAY);

    	
    	JPanel panelsmosh = new JPanel();

    	panelsmosh.setBackground(Color.GRAY);    	
    	sendFile = new JButton("Send File");  
    	sendFile.addActionListener(new SendFileButton());
    	panelsmosh.add(sendFile); 
    	panelsmosh.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridx = 0;
    	c.gridy = 0;
    	panelsmosh.add(sendFile, c);
 

    	
    

    	panel3.setBackground(Color.GRAY);
     	panel3.add(panelsmosh, "Center");    	
    	panel3.add(filler1,"North"); 
    	panel3.add(filler2,"South"); 
    	panel3.add(filler3, "West");
    	panel3.add(filler4, "East");

    	
    	JPanel panel4 = new JPanel(); 
    	panel4.setBackground(Color.GRAY);
    	

    	
    	JPanel panel5 = new JPanel();
    	panel5.setBackground(Color.GRAY);

    	
    	
    	window.getContentPane().add(panel1, "South"); 
    	window.getContentPane().add(panel2, "Center"); 
    	window.getContentPane().add(panel3, "West"); 
    	window.getContentPane().add(panel4, "North"); 
    	window.getContentPane().add(panel5, "East"); 
    	   	
    	
    	window.setVisible(true);
   }   
          
    
    
      	class ButtonListener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
        		String msg_to_send = userText.getText();
        		String n = name + ": " + msg_to_send;
        		set_full_mess(n); 
        		
    			//chatWindow.append(full_mess + '\n');
    				userText.setText("");
        	}
        }  

      	class SendFileButton implements ActionListener{
        	public void actionPerformed(ActionEvent e){
        		JFrame paper = new JFrame("File"); 
        		paper.setSize(300, 200);
        		JPanel panel = new JPanel();
        		JLabel sorrymessage = new JLabel("This feature is unavailable at the time :("); 
        		JLabel label = new JLabel("Enter Name of File: ");
        		JTextField nombre = new JTextField(30); 
        		nombre.setEnabled(true);
        		panel.add(label, "West");
        		panel.add(nombre, "East");
        		paper.add(panel);
        		paper.add(sorrymessage);
        		paper.setVisible(true);
        		
        		
        		
        	}
        }  
      	
    public String get_full_mess(){
    	return full_mess;  
    }
    public void set_full_mess(String n){
    	full_mess =n; 
    }
      	
    public static void main(String[] args) {

    	Gui gui = new Gui();

    }

	public void set_name(String username) {
		name = username; 
		
	}
}
