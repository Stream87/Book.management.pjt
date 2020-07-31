package swing;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hemf.record.emf.HemfText.SetTextJustification;
import org.apache.poi.ss.formula.functions.Count;

import errorAndfalse.RecordNotFoundException;

//import org.w3c.dom.events.MouseEvent;

import ezenproject.DAO;
import ezenproject.DTO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Checkbox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class SqlMode extends JFrame {

	private JPanel contentPane;
	private JTextField searchLabel;
	private JTextField codeLabel;
	private JTextField chulpanLabel;
	private JTextField genreLabel;
	private JTextField booknameLabel;
	private JTextField dateLabel;
	private JTextField RemainLabel;
	private JTextField authorLabel;
	private JTextField conditionLabel;
	private JTextField categoryLabel;
	private JTable table;
	DAO dao;
	DefaultTableModel tableModel;
	private JTextField floortext;
	private JTextField textField_1;
	private JTextField StockField;
	
	
    Calendar calendar1 = Calendar.getInstance(); 
    int hour = calendar1.get(Calendar.HOUR_OF_DAY); 
    int min = calendar1.get(Calendar.MINUTE); 
    int sec = calendar1.get(Calendar.SECOND);

    javax.swing.Timer timer; 
    JLabel lbPresent;
    JLabel TimeLabel;


	/**
	 * Create the frame.
	 */
	public SqlMode() {
		
		dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC \uD654\uBA74 (SQL MODE)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 26, 268, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCF54\uB4DC");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 97, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCC45\uC774\uB984");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(386, 100, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(70, 148, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC80\uC0C9\uD558\uAE30");
		lblNewLabel_4.setBounds(563, 26, 57, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC7A5\uB974");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(70, 202, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uCD9C\uD310\uC77C");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(386, 151, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		searchLabel = new JTextField();
		searchLabel.setBounds(621, 27, 154, 21);
		contentPane.add(searchLabel);
		searchLabel.setColumns(10);
		
		JButton searchButton = new JButton("\uAC80\uC0C9");
		searchButton.setBounds(788, 26, 97, 23);
		contentPane.add(searchButton);
		

		
		JLabel lblNewLabel_7 = new JLabel("Remain");
		lblNewLabel_7.setBounds(386, 205, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uC800\uC790");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(665, 94, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uCC45\uC0C1\uD0DC");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(665, 145, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Category");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(665, 199, 57, 15);
		contentPane.add(lblNewLabel_10);
		
		codeLabel = new JTextField();
		codeLabel.setBounds(149, 94, 116, 21);
		contentPane.add(codeLabel);
		codeLabel.setColumns(10);
		
		chulpanLabel = new JTextField();
		chulpanLabel.setBounds(149, 145, 116, 21);
		contentPane.add(chulpanLabel);
		chulpanLabel.setColumns(10);
		
		genreLabel = new JTextField();
		genreLabel.setBounds(149, 199, 116, 21);
		contentPane.add(genreLabel);
		genreLabel.setColumns(10);
		
		booknameLabel = new JTextField();
		booknameLabel.setBounds(455, 97, 116, 21);
		contentPane.add(booknameLabel);
		booknameLabel.setColumns(10);
		
		dateLabel = new JTextField();
		dateLabel.setBounds(455, 148, 116, 21);
		contentPane.add(dateLabel);
		dateLabel.setColumns(10);
				
		RemainLabel = new JTextField();
		RemainLabel.setBounds(455, 202, 116, 21);
		contentPane.add(RemainLabel);
		RemainLabel.setColumns(10);
		
		authorLabel = new JTextField();
		authorLabel.setBounds(734, 91, 116, 21);
		contentPane.add(authorLabel);
		authorLabel.setColumns(10);
		
		conditionLabel = new JTextField();
		conditionLabel.setBounds(734, 142, 116, 21);
		contentPane.add(conditionLabel);
		conditionLabel.setColumns(10);
		
		categoryLabel = new JTextField();
		categoryLabel.setBounds(734, 196, 116, 21);
		contentPane.add(categoryLabel);
		categoryLabel.setColumns(10);
		
		JButton chatButton = new JButton("\uCC44\uD305 \uBA54\uC138\uC9C0");
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chatButton.setBounds(752, 272, 116, 43);
		contentPane.add(chatButton);
		 
		JButton resetButton = new JButton("\uD544\uB4DC \uCD08\uAE30\uD654");
		resetButton.setBounds(769, 441, 116, 43);
		contentPane.add(resetButton);
		
		JButton addButton = new JButton("\uB370\uC774\uD130 \uCD94\uAC00");
		addButton.setBounds(70, 569, 110, 23);
		contentPane.add(addButton);
				
		JButton fixButton = new JButton("\uC218\uC815");
		fixButton.setBounds(304, 569, 97, 23);
		contentPane.add(fixButton);
		
		JButton deleteButton = new JButton("\uC0AD\uC81C");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		deleteButton.setBounds(523, 569, 97, 23);
		contentPane.add(deleteButton);
		
		JButton endButton = new JButton("\uC885\uB8CC");
		endButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		
		endButton.setBounds(724, 569, 97, 23);
		contentPane.add(endButton);
	     //전체 검색 기능
	      String header[] = {"코드","책이름","저자","출판사","출판일","책상태","장르","Remain","Category"};
	      
	      String content[][] = {
	            {"코드1","책이름1","저자1","출판사1","출판일1","책상태1","장르1","Remain1","Category1"},
	            {"코드2","책이름2","저자2","출판사2","출판일2","책상태2","장르2","Remain2","Category2"},
	            {"코드3","책이름3","저자3","출판사3","출판일3","책상태3","장르3","Remain3","Category3"}
	      }; 
		
		//���̺�� ����
		tableModel = new DefaultTableModel(content, header);

		//���̺� �� ���� �ʱ�ȭ
		tableModel.setNumRows(0);
		
		ArrayList<DTO> dtolistall = new ArrayList<DTO>();
		
		//������ ���̽� �ȿ� �ִ� ���� ��ü �˻�
		dtolistall = dao.searchAll();

		//������ üũ
		int dtoSizeall = dtolistall.size();

		//���̺� ���� �ϳ��ϳ� ä���ֱ�
		for(int i = 0; i< dtoSizeall; i++) {
			
			String newcontent[] = new String[9];
			
			//"�ڵ�","å�̸�","����","���ǻ�","������","å����","�帣","Remain","Category"
			newcontent[0] = dtolistall.get(i).getCode();
			newcontent[1] = dtolistall.get(i).getBookname();
			newcontent[2] = dtolistall.get(i).getAuthor();
			newcontent[3] = dtolistall.get(i).getEditorial();
			
			Date from = dtolistall.get(i).getPublish_day();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");
			String to = transFormat.format(from);
			
			newcontent[4] = to;
			newcontent[5] = dtolistall.get(i).getCondition();
			newcontent[6] = dtolistall.get(i).getKind();
			
			int remainvalue = dtolistall.get(i).getRemain();
			String remainstring = Integer.toString(remainvalue);
			newcontent[7] = remainstring;			
			int categoryvalue = dtolistall.get(i).getCategory();
			String categorystring = Integer.toString(categoryvalue);
			newcontent[8] = categorystring;
			
			tableModel.insertRow(i, newcontent);
			}

		
		
		
		//JTable�� ����
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ�
		table.getTableHeader().setResizingAllowed(false); // ũ�� ���� �Ұ�
		JScrollPane ConditoinAVg = new JScrollPane(table);
		ConditoinAVg.setBounds(54, 261, 658, 268);
		contentPane.add(ConditoinAVg);
		
		Button baguni = new Button("\uB300\uC5EC\uBAA9\uB85D");
		baguni.setActionCommand("");
		baguni.setBounds(769, 516, 116, 23);
		contentPane.add(baguni);
		
		floortext = new JTextField();
		floortext.setBounds(792, 325, 76, 21);
		contentPane.add(floortext);
		floortext.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(811, 356, 57, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Button RandomCode = new Button("RandomCode");
		RandomCode.setBounds(278, 92, 86, 23);
		contentPane.add(RandomCode);
		
		JLabel lblNewLabel_11 = new JLabel("Stock");
		lblNewLabel_11.setBounds(753, 390, 37, 15);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("ConditionAvg");
		lblNewLabel_12.setBounds(720, 359, 80, 15);
		contentPane.add(lblNewLabel_12);
		
		StockField = new JTextField();
		StockField.setBounds(798, 387, 70, 21);
		contentPane.add(StockField);
		StockField.setColumns(10);
		
		timer = new Timer(1000, null);
        timer.setInitialDelay(0);
        timer.start();

        TimeLabel = new JLabel("현재시간: " + hour + "시" + min + "분" + sec + "초");
        
		TimeLabel.setBounds(365, 33, 172, 21);
		
		contentPane.add(TimeLabel);
        
		
		RandomCode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				java.util.Random rand = new java.util.Random();
				
				String resultcode = "";
				
				String firstcode = "ABC";
				char firstChar = firstcode.charAt(rand.nextInt(firstcode.length()-1));
				resultcode= resultcode+firstChar;
				
				String secondcode = "1234567890";
					for(int i = 0; i <= 5; i ++) {
						char secondChar = secondcode.charAt(rand.nextInt(secondcode.length()-1));
						resultcode = resultcode + secondChar;
					}
				
				
				String thirdcode = "abcdefghijklmnopqrstuvwxyz";
				for(int i = 0; i <= 3; i ++) {
					char thirdChar = thirdcode.charAt(rand.nextInt(thirdcode.length()-1));
					resultcode = resultcode + thirdChar;
				}
				
				codeLabel.setText(resultcode);
				
			}

		});
		
		


		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				
				int selectedrow = table.getSelectedRow();
				
				//�ڵ�
				String code = (String) tableModel.getValueAt(selectedrow, 0);
				codeLabel.setText(code);
				
				//å�̸�
				String name = (String) tableModel.getValueAt(selectedrow, 1);
				booknameLabel.setText(name);
				//����
				String author = (String) tableModel.getValueAt(selectedrow, 2);
				authorLabel.setText(author);
				//���ǻ�
				String company = (String) tableModel.getValueAt(selectedrow, 3);
				chulpanLabel.setText(company);
				//������
				String date = (String) tableModel.getValueAt(selectedrow, 4);
				dateLabel.setText(date);
				//å����
				String condition = (String) tableModel.getValueAt(selectedrow, 5);
				conditionLabel.setText(condition);
				//�帣
				String genere = (String) tableModel.getValueAt(selectedrow, 6);
				genreLabel.setText(genere);
				//������
				String remain = (String) tableModel.getValueAt(selectedrow, 7);
				RemainLabel.setText(remain);
				//ī�װ�
				String category = (String) tableModel.getValueAt(selectedrow, 8);
				categoryLabel.setText(category);
			}
		});
		

		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
		
				String codetext = codeLabel.getText();
				String chulpan = chulpanLabel.getText();
				String genre = genreLabel.getText();
				String bookname = booknameLabel.getText();
				
				String date = dateLabel.getText();
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date to = new Date();
				
				try {
					to = transFormat.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String Remain = RemainLabel.getText();
				int remainint = Integer.parseInt(Remain);
				
				String author = authorLabel.getText();
				String condition = conditionLabel.getText();
				
				String category = categoryLabel.getText();
				int categoryint = Integer.parseInt(category);
				
				//������ ������ DTO����
				
				DTO dto = new DTO();
				
				dto.setAuthor(author);
				dto.setBookname(bookname);
				dto.setCategory(categoryint);
				dto.setCode(codetext);
				dto.setCondition(condition);
				dto.setEditorial(chulpan);
				dto.setKind(genre);
				dto.setPublish_day(to);
				dto.setRemain(remainint);
				
				//DAO���� insert �Ѵ�
				//���̵� Ȯ�� ���� �ܼ�â üũ
				System.out.println(author);
	            System.out.println(bookname);
	            System.out.println(categoryint);
	            System.out.println(codetext);
	            System.out.println(condition);
	            System.out.println(chulpan);
	            System.out.println(genre);
	            System.out.println(to);
	            System.out.println(remainint);
	            
				int result = dao.insert(dto);
				
				tableModel.setNumRows(0);
				
				ArrayList<DTO> dtolistaftercreate = new ArrayList<DTO>();
				
				
				dtolistaftercreate = dao.searchAll();

				
				int dtoSizeall = dtolistaftercreate.size();

				
				for(int i = 0; i< dtoSizeall; i++) {
					
					String newcontent[] = new String[9];
					
				
					newcontent[0] = dtolistaftercreate.get(i).getCode();
					newcontent[1] = dtolistaftercreate.get(i).getBookname();
					newcontent[2] = dtolistaftercreate.get(i).getAuthor();
					newcontent[3] = dtolistaftercreate.get(i).getEditorial();
					
					Date from = dtolistaftercreate.get(i).getPublish_day();
					SimpleDateFormat transFormat1 = new SimpleDateFormat("yyyy/MM/dd");
					String to1 = transFormat1.format(from);
					newcontent[4] = to1;
					
					newcontent[5] = dtolistaftercreate.get(i).getCondition();
					newcontent[6] = dtolistaftercreate.get(i).getKind();
					
					int remainvalue = dtolistaftercreate.get(i).getRemain();
					String remainstring = Integer.toString(remainvalue);
					newcontent[7] = remainstring;
					
					int categoryvalue = dtolistaftercreate.get(i).getCategory();
					String categorystring = Integer.toString(categoryvalue);
					newcontent[8] = categorystring;
					
					tableModel.insertRow(i, newcontent);

				}
				
				//���̺� �ٲ������� �ݿ�
				table.updateUI();
				
				if(result!=0) {
					JOptionPane.showMessageDialog(null, "�Է¿Ϸ�");
				}else {
					JOptionPane.showMessageDialog(null, "�Է½���");
				}
			
			}

		});
		
		
		//������ �˻�
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//�ؽ�Ʈ �ʵ忡�� ���� �����´� (å�̸�, ���ǻ�� �˻�)
				String searchText = searchLabel.getText();
				ArrayList<DTO> dtolist = new ArrayList<DTO>();
				
				try {			
					dtolist = dao.search(searchText);
					
				} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
				
				tableModel.setNumRows(0);
				
				int dtoSize = dtolist.size();

				
				for(int i = 0; i< dtoSize; i++) {
					
					String newcontent[] = new String[9];
					
			
					newcontent[0] = dtolist.get(i).getCode();
					newcontent[1] = dtolist.get(i).getBookname();
					newcontent[2] = dtolist.get(i).getAuthor();
					newcontent[3] = dtolist.get(i).getEditorial();
					
					Date from = dtolist.get(i).getPublish_day();
					SimpleDateFormat transFormat1 = new SimpleDateFormat("yyyy/MM/dd");
					String to1 = transFormat1.format(from);
					//System.out.println(to1);
					newcontent[4] = to1;
					
					newcontent[5] = dtolist.get(i).getCondition();
					newcontent[6] = dtolist.get(i).getKind();
					
					int remainvalue = dtolist.get(i).getRemain();
					String remainstring = Integer.toString(remainvalue);
					newcontent[7] = remainstring;
					
					int categoryvalue = dtolist.get(i).getCategory();
					String categorystring = Integer.toString(categoryvalue);
					newcontent[8] = categorystring;
					
					tableModel.insertRow(i, newcontent);
					table.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ�
					table.getTableHeader().setResizingAllowed(false); // ũ�� ���� �Ұ�
				}
				
	
				table.updateUI();
				
			}
		});
		
		
		

		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//get text�� �ڵ� ���� �����´�.
				String codetext = codeLabel.getText();
				dao.delete(codetext);
				
				//���� �� ���̺� �� ���� �ʱ�ȭ
				tableModel.setNumRows(0);
				
				ArrayList<DTO> dtolistafterdelete = new ArrayList<DTO>();
				
				//������ ���̽� �ȿ� �ִ� ���� ��ü �˻�
				dtolistafterdelete = dao.searchAll();

				//������ üũ
				int dtoSizeall = dtolistafterdelete.size();

				//���̺� ���� �ϳ��ϳ� ä���ֱ�
				for(int i = 0; i< dtoSizeall; i++) {
					
					String newcontent[] = new String[9];
				
					newcontent[0] = dtolistafterdelete.get(i).getCode();
					newcontent[1] = dtolistafterdelete.get(i).getBookname();
					newcontent[2] = dtolistafterdelete.get(i).getAuthor();
					newcontent[3] = dtolistafterdelete.get(i).getEditorial();
					
					Date from = dtolistafterdelete.get(i).getPublish_day();
					SimpleDateFormat transFormat1 = new SimpleDateFormat("yyyy년MM월dd일");
					String to1 = transFormat1.format(from);
					newcontent[4] = to1;
					
					newcontent[5] = dtolistafterdelete.get(i).getCondition();
					newcontent[6] = dtolistafterdelete.get(i).getKind();
					
					int remainvalue = dtolistafterdelete.get(i).getRemain();
					String remainstring = Integer.toString(remainvalue);
					newcontent[7] = remainstring;
					
					int categoryvalue = dtolistafterdelete.get(i).getCategory();
					String categorystring = Integer.toString(categoryvalue);
					newcontent[8] = categorystring;
					
					tableModel.insertRow(i, newcontent);
					table.getTableHeader().setReorderingAllowed(false); 
					table.getTableHeader().setResizingAllowed(false); 
				}
				
		
				table.updateUI();

			}
		});	
	
		

		fixButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
		
				String codetext = codeLabel.getText();
				String chulpan = chulpanLabel.getText();
				String genre = genreLabel.getText();
				String bookname = booknameLabel.getText();
				
				String date = dateLabel.getText();
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date to = new Date();
				try {
					to = transFormat.parse(date);
				} catch (ParseException e) {
				
					e.printStackTrace();
				}

				String Remain = RemainLabel.getText();
				int remainint = Integer.parseInt(Remain);
				
				String author = authorLabel.getText();
				String condition = conditionLabel.getText();
				
				String category = categoryLabel.getText();
				int categoryint = Integer.parseInt(category);
				
	
				
				DTO dto = new DTO();
				
				dto.setAuthor(author);
				dto.setBookname(bookname);
				dto.setCategory(categoryint);
				dto.setCode(codetext);
				dto.setCondition(condition);
				dto.setEditorial(chulpan);
				dto.setKind(genre);
				dto.setPublish_day(to);
				dto.setRemain(remainint);				
				
				dao.update(dto);
				
		
				tableModel.setNumRows(0);
				
				ArrayList<DTO> dtolistafterfix = new ArrayList<DTO>();
				
			
				dtolistafterfix = dao.searchAll();

			
				int dtoSizeall = dtolistafterfix.size();

			
				for(int i = 0; i< dtoSizeall; i++) {
					
					String oldStr="1010/10/10";
					String newStr=oldStr.replace("/", "��");
					System.out.println(newStr);
					
					String newcontent[] = new String[9];
					
				
					newcontent[0] = dtolistafterfix.get(i).getCode();
					newcontent[1] = dtolistafterfix.get(i).getBookname();
					newcontent[2] = dtolistafterfix.get(i).getAuthor();
					newcontent[3] = dtolistafterfix.get(i).getEditorial();

					Date from = dtolistafterfix.get(i).getPublish_day();
					SimpleDateFormat transFormat1 = new SimpleDateFormat("yyyy/MM/dd");
					String to1 = transFormat1.format(from);
					newcontent[4] = to1;
					
					newcontent[5] = dtolistafterfix.get(i).getCondition();
					newcontent[6] = dtolistafterfix.get(i).getKind();
					
					int remainvalue = dtolistafterfix.get(i).getRemain();
					String remainstring = Integer.toString(remainvalue);
					newcontent[7] = remainstring;
					
					int categoryvalue = dtolistafterfix.get(i).getCategory();
					String categorystring = Integer.toString(categoryvalue);
					newcontent[8] = categorystring;
					
					tableModel.insertRow(i, newcontent);
					table.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ�
					table.getTableHeader().setResizingAllowed(false); // ũ�� ���� �Ұ�
				}
				//���̺� �ٲ������� �ݿ�
				table.updateUI();
			}
		});
	
		
	

		resetButton.addActionListener(new ActionListener() {
					DAO dao = new DAO();
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				codeLabel.setText("");
		
				booknameLabel.setText("");
			
				authorLabel.setText("");
			
				chulpanLabel.setText("");
			
				dateLabel.setText("");
			
				conditionLabel.setText("");
				
				genreLabel.setText("");
				
				RemainLabel.setText("");
			
				categoryLabel.setText("");
				
				StockField.setText(Integer.toString(dao.count()));
				//floortext.setText(Integer.toString(dao.floordiv()));
			}
		});
			

//				CodeButton.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						DAO dao = new DAO();
//					String randomCode=Random();
//					if((dao.isExist(randomCode)))
//						 randomCode = Random();
//					else	
//						codeLabel.setText(Random());
//					}		      
//				});
		
				

		

			
		
		String[] cf = {"1층", "2층", "3층"};
		JComboBox choicefloors = new JComboBox(cf);
		choicefloors.setBounds(734, 325, 47, 21);
		
		contentPane.add(choicefloors);
		
	
			choicefloors.addMouseListener(new MouseAdapter() {
				public void  mouseClicked(MouseEvent e) {
			
					int index = choicefloors.getSelectedIndex();
					switch(index) {
					
					case 0 :{
						floortext.setText(Integer.toString(dao.floorA())); 
						choicefloors.updateUI();
					}break;
					case 1 :{
						floortext.setText(Integer.toString(dao.floorB())); 
						choicefloors.updateUI();
					}break;
					case 2: {
						floortext.setText(Integer.toString(dao.floorC()));
						choicefloors.updateUI();
					} break;
					default : break;
					}
					
				}
			});
		
	
	
	
	String[] ranCode = {"A", "B", "C"};
}
	
	
	
	
	
	public String Random(String randomco) {  
		int len = 6;
		        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
		            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
		            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
		            'U', 'V', 'W', 'X', 'Y', 'Z' };

		        int idx = 0;
		        StringBuffer sb = new StringBuffer();
		         System.out.println("charSet.length :: "+charSet.length);
		       for (int i = 0; i < len; i++) {
		        if(i==0) {
		           sb.append(randomco);
		            }else {
		            idx = (int) (charSet.length * Math.random()); 
		            System.out.println("idx :: "+idx);
		            sb.append(charSet[idx]);
		            }
		       }
		      System.out.println("sb result :: "+sb.toString());
		 String randomCode = sb.toString();
		return randomCode;	
		}
}