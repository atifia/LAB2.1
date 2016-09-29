import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.DropMode;
import javax.swing.JTextPane;

public class ApplicationWindow {

	JFrame frame;
	public JLabel lblShow;
	public JButton btnRun;
	public JTextField txtInput;
	private JTextField textShow;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
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
	
	
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					
					//txtInput.requestFocusInWindow();
					
				
					String s = txtInput.getText();
					UnixCommander uc = new UnixCommander();
					textArea.setText(uc.execute(s));
				
					
					}
					catch(Exception e1){
						
						//JOptionPane.showMessageDialog(null, "Wrong input ! Try again.");
						//lblShow.setText("Wrong input ! Please try again.");
						
						textShow.setText(e1.getMessage());
						
						}
					
				
				
			}
		});
		btnRun.setBounds(12, 69, 115, 32);
		frame.getContentPane().add(btnRun);
		
		/*lblShow = new JLabel("");
		lblShow.setFont(new Font("Dialog", Font.BOLD, 10));
		lblShow.setHorizontalAlignment(SwingConstants.LEFT);
		lblShow.setVerticalAlignment(SwingConstants.TOP);
		lblShow.setBounds(22, 169, 402, 119);
		frame.getContentPane().add(lblShow);
		*/
		txtInput = new JTextField();
		txtInput.setBackground(Color.BLACK);
		txtInput.setFont(new Font("Dialog", Font.BOLD, 12));
		txtInput.setForeground(Color.GREEN);
		txtInput.setHorizontalAlignment(SwingConstants.LEFT);
		txtInput.setBounds(12, 12, 412, 45);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		
		textShow = new JTextField();
		textShow.setForeground(Color.GREEN);
		textShow.setBackground(Color.BLACK);
		textShow.setFont(new Font("Dialog", Font.BOLD, 10));
		//textShow.setBounds(12, 113, 412, 133);
		textArea.setBounds(12, 113, 412, 133);
		//frame.getContentPane().add(textShow);
		frame.getContentPane().add(textArea);

		textShow.setColumns(10);
	}
}
