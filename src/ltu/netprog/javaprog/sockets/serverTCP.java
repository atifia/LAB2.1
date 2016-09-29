package ltu.netprog.javaprog.sockets;

import java.awt.EventQueue;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class serverTCP {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serverTCP window = new serverTCP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public serverTCP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(29, 35, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				// define a constant used as size of buffer 
				static final int BUFSIZE=1024;
				// main starts things rolling
				 
					
					if (args.length != 1){
						throw new IllegalArgumentException("Must specify a port!");
					}
					
					int port = Integer.parseInt(args[0]);
					try { 
						// Create Server Socket (passive socket) 
						ServerSocket ss = new ServerSocket(12345);
						
						while (true) { 
							Socket s = ss.accept();
							handleClient(s);
							
						} 
						
					} catch (IOException e) {
						System.out.println("Fatal I/O Error !"); 
						System.exit(0);
						
					}
					
				}
				
				
			});
		
		btnSend.setBounds(29, 110, 117, 25);
		frame.getContentPane().add(btnSend);
		
		textField_1 = new JTextField();
		textField_1.setBounds(29, 184, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	

	static void handleClient(Socket s) throws IOException 
	{ 
		byte[] buff = new byte[BUFSIZE];
		byte[] show = new byte[BUFSIZE];
		int bytesread = 0;
		
		//print out client's address
		System.out.println("Connection from " + s.getInetAddress().getHostAddress());
		
		//Set up streams 
		
		InputStream in = s.getInputStream();  
		OutputStream out = s.getOutputStream(); 
		
		//StringBuffer text = new StringBuffer();
		//InetAddress localhost = InetAddress.getLocalHost();
		
		
		
		
		//read/write loop 

//Modify your code here so that it sends back your name in addition to the echoed symbols
		while ((bytesread = in.read(buff)) != -1) {
			
			out.write(buff,0,bytesread);
			System.out.println(InetAddress.getLocalHost());
			out.write(show);
				
			
			//out.writeBytes(InetAddress.getLocalHost().toString());
			
			} 
		
		System.out.println("Client has left\n"); 
		
		s.close();
		
	}
	
}
}


