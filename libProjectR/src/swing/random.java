package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Choice;

public class random extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					random frame = new random();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public random() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("New button");
		button.setBounds(105, 208, 76, 23);
		contentPane.add(button);
		
		Button button_1 = new Button("New button");
		button_1.setBounds(214, 208, 76, 23);
		contentPane.add(button_1);
		
		TextField textField = new TextField();
		textField.setBounds(118, 144, 161, 23);
		contentPane.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(118, 103, 161, 23);
		contentPane.add(textField_1);
		
		Choice choice = new Choice();
		choice.setBounds(121, 37, 99, 21);
		contentPane.add(choice);
	}
}
