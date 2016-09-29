import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DropMode;



public class CountLoops {

	public JLabel lblNewLabel;
	

	private JFrame frame;
	public int i;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CountLoops window = new CountLoops();
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
	public CountLoops() {
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
		
		JLabel lblHi = new JLabel("Here we want to count !");
		lblHi.setBounds(12, 41, 363, 15);
		frame.getContentPane().add(lblHi);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//String s;
				StringBuffer sb = new StringBuffer();
				
				int i = 0;
				while(i<100){
					//textField.setText(i+"\n");
					//s =Integer.toString(i);
					i+=1;
					sb = sb.append(i+"\n");
					//i++;
					//System.out.println(sb);
					
					
					textField.setText(sb.toString());
						
				}
				
				//textField.setText(sb.toString());
				
				/*int i=1;
				do {
					textField.setText(Integer.toString(i));
					i++;
				} while (i<100);*/
				
				/*int x = 1;
				do {
				System.out.println("Looping, round " + x);
				x++;
				} while (x <= 10);*/
			}
			
		});
		btnStart.setBounds(36, 94, 117, 25);
		frame.getContentPane().add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(240, 25, 135, 219);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
