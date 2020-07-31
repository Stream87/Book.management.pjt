package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;
	static Login frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uAD00\uB9AC\uC790\uCF54\uB4DC");
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(91, 116, 100, 15);
		
		//관리자 코드
		textField = new JPasswordField();
		contentPane.add(textField);
		textField.setBounds(240, 113, 116, 21);
		textField.setColumns(10);
		
		JButton loginButton = new JButton("\uB85C\uADF8\uC778");
		contentPane.add(loginButton);
		loginButton.setBounds(109, 190, 97, 23);
		
		JButton endButton = new JButton("\uC885\uB8CC");
		contentPane.add(endButton);
		endButton.setBounds(240, 191, 97, 23);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uD504\uB85C\uADF8\uB7A8");
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(146, 21, 154, 35);
		
		
			endButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
		

		
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id="1234";
				
				if(id.equals(textField.getText()))
				{ JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
					
					Menu Menuframe = new Menu();
			
					frame.setVisible(false);
					Menuframe.setVisible(true);
					
				}else { JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
			}
				}
			});
		
	}
}