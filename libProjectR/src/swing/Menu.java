package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chatting.ChatClient;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel backLabel = new JLabel("");
		backLabel.setIcon(new ImageIcon("img/javalogin.png"));
	
		
		backLabel.setBounds(0, 0, 478, 307);
		contentPane.add(backLabel);
		
		
		JButton sqlButton = new JButton("SQL\uBAA8\uB4DC");
		sqlButton.setBounds(105, 114, 97, 74);
		backLabel.add(sqlButton);
		
		JButton excelButton = new JButton("Excel\uBAA8\uB4DC");
		excelButton.setBounds(272, 114, 97, 74);
		backLabel.add(excelButton);
		
		JLabel lblNewLabel = new JLabel("\uBAA8\uB4DC\uC120\uD0DD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 34, 154, 35);
		backLabel.add(lblNewLabel);
		
		JButton chatbtn = new JButton("\uCC44\uD305\uBAA8\uB4DC");
		chatbtn.setBounds(179, 231, 97, 23);
		backLabel.add(chatbtn);
		

		
		sqlButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SqlMode SqlModeframe = new SqlMode();
				contentPane.setVisible(false);
				SqlModeframe.setVisible(true);
			}

		});
		
		excelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ExcelMode excelModeframe = new ExcelMode();
				contentPane.setVisible(false);
				excelModeframe.setVisible(true);
			}

		});
		
		
		chatbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChatClient cc =	new ChatClient();
			
				
			}
		});
	}
}
