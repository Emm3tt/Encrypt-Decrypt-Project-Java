import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Main extends JFrame
{


	private Cryptic crypt;
	private Container contentPane;
	private JButton encryptJButton, decryptJButton;
	private JLabel messageJLabel,decodedJLabel;
	private JTextField messageJTextField,decodedJTextField;

	public Main()
	
	{
		
		crypt = new Cryptic();
		
		constructUserInterface();
		
	}
	
	public void constructUserInterface()
	
	{
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GRAY);
		
		messageJLabel = new JLabel();
		messageJLabel.setText("Message");
		messageJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		messageJLabel.setForeground(Color.BLACK);
		messageJLabel.setBounds(250,0,300,50);
		contentPane.add(messageJLabel);
		
		messageJTextField = new JTextField("");
		messageJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		messageJTextField.setForeground(Color.GRAY);
		messageJTextField.setHorizontalAlignment(JTextField.CENTER);
		messageJTextField.setBounds(150,100,300,50);
		contentPane.add(messageJTextField);
		
		encryptJButton = new JButton();
		encryptJButton.setText("Encrypt");
		encryptJButton.setFont(new Font ("Times New Roman",Font.BOLD,30));
		encryptJButton.setForeground(Color.GRAY);
		encryptJButton.setBounds(200,200,200,100);
		contentPane.add(encryptJButton);
		
		encryptJButton.addActionListener(
				
				new ActionListener()
				
				{
					
					public void actionPerformed(ActionEvent event)
					
					{
						
						decodedJTextField.setText(crypt.encrypt(messageJTextField.getText(), "MONDAY"));
						messageJTextField.setText("");
						
					}
					
				}
				
			);
		
		
		decodedJLabel = new JLabel();
		decodedJLabel.setText("Decoded");
		decodedJLabel.setFont(new Font ("Times New Roman",Font.BOLD,30));
		decodedJLabel.setForeground(Color.BLACK);
		decodedJLabel.setBounds(250,300,550,88);
		contentPane.add(decodedJLabel);
		
		decodedJTextField = new JTextField("");
		decodedJTextField.setFont(new Font ("Times New Roman",Font.BOLD,30));
		decodedJTextField.setForeground(Color.GRAY);
		decodedJTextField.setHorizontalAlignment(JTextField.CENTER);
		decodedJTextField.setBounds(150,400,300,50);
		contentPane.add(decodedJTextField);
		
		decryptJButton = new JButton();
		decryptJButton.setText("Decrypt");
		decryptJButton.setFont(new Font ("Times New Roman",Font.BOLD,30));
		decryptJButton.setForeground(Color.GRAY);
		decryptJButton.setBounds(200,500,200,100);
		contentPane.add(decryptJButton);
		
		decryptJButton.addActionListener(
				
				new ActionListener()
				
				{
					
					public void actionPerformed(ActionEvent event)
					
					{
						
						messageJTextField.setText(crypt.decrypt(decodedJTextField.getText(), "MONDAY"));
						decodedJTextField.setText("");
						
					}
					
				}
				
			);
		
		
		
		this.setTitle("Welcome");
		this.setVisible(true);
		this.setSize(600,600);
		this.setResizable(true);
		
	}
	
	public static void main(String[] args) 
	{
		
		Main app = new Main();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

}

