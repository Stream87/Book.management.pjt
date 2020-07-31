package swing;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ezenproject.DAO;
import ezenproject.DTO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class ExcelMode extends JFrame {

	private JPanel contentPane;
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
	String[][] content;
	int selectedrow = -1;

	/**
	 * Create the frame.
	 */
	public ExcelMode() {
		
		manageExcel excel = new manageExcel();
	
		dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC \uD654\uBA74 (Excel Mode)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 26, 154, 35);
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
		
		JLabel lblNewLabel_5 = new JLabel("\uC7A5\uB974");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(70, 202, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uCD9C\uD310\uC77C");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(386, 151, 57, 15);
		contentPane.add(lblNewLabel_6);
		

		
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
		
		JButton addButton = new JButton("\uB370\uC774\uD130 \uCD94\uAC00");
		addButton.setBounds(87, 569, 110, 23);
		contentPane.add(addButton);
				
		JButton insertButton = new JButton("Excel\uB370\uC774\uD130 \uC77D\uAE30");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		insertButton.setBounds(412, 569, 139, 23);
		contentPane.add(insertButton);
		
		JButton makeButton = new JButton("Excel\uD30C\uC77C \uB9CC\uB4E4\uAE30");
		makeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		makeButton.setBounds(609, 569, 139, 23);
		contentPane.add(makeButton);
		
		JButton endButton = new JButton("\uC885\uB8CC");
		endButton.setBounds(809, 569, 97, 23);
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
		
		//JTable�� ����
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(54, 261, 706, 268);
		contentPane.add(scrollPane);
		
		JButton saveDBButton = new JButton("DB\uC5D0 \uC800\uC7A5\uD558\uAE30");
		saveDBButton.setBounds(772, 326, 134, 43);
		contentPane.add(saveDBButton);
		
		JButton deleteButton = new JButton("\uB370\uC774\uD130 \uC0AD\uC81C");
		deleteButton.setBounds(247, 569, 110, 23);
		contentPane.add(deleteButton);
		
		JButton loadDBButton = new JButton("DB\uC5D0\uC11C \uAC00\uC838\uC624\uAE30");
		loadDBButton.setBounds(772, 408, 134, 43);
		contentPane.add(loadDBButton);
		
		
		//������ư
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(selectedrow!=-1) {
					tableModel.removeRow(selectedrow);				
				}
				
				selectedrow=-1;

				table.updateUI();

			}
		});	
		
		//���콺 Ŭ�� ����������
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// ���콺���� ������ �ٹ�ȣ���
				selectedrow = table.getSelectedRow();
				
			}	
		});
		
		//���� ���� ����� ��ư
		makeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int rowcount = tableModel.getRowCount();
				System.out.println(rowcount);
				ArrayList<Object[]> datalist = new ArrayList<Object[]>();
				
				for(int i = 0; i< rowcount; i++) {
					Object[] objectArray = new Object[9];
					objectArray[0] = tableModel.getValueAt(i, 0);
					objectArray[1] = tableModel.getValueAt(i, 1);
					objectArray[2] = tableModel.getValueAt(i, 2);
					objectArray[3] = tableModel.getValueAt(i, 3);
					objectArray[4] = tableModel.getValueAt(i, 4);
					objectArray[5] = tableModel.getValueAt(i, 5);
					objectArray[6] = tableModel.getValueAt(i, 6);
					objectArray[7] = tableModel.getValueAt(i, 7);
					objectArray[8] = tableModel.getValueAt(i, 8);
					datalist.add(objectArray);
				}
				
				excel.createExcelfile(datalist);

			}
		});	
		
		//���� ���� �б� ��ư
		insertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//���̺� �ʱ�ȭ
				tableModel.setNumRows(0);
				
				ArrayList<String[]> readList = new ArrayList<>();
				readList = excel.readExcelfile();
				
				int Sizeall = readList.size();
				
				//���̺� ���� �ϳ��ϳ� ä���ֱ�
				for(int i = 0; i< Sizeall; i++) {
					
					tableModel.addRow(readList.get(i));
				}
				
				// ���̺� �ٲ������� �ݿ�
				table.updateUI();
				
			}
		});	
		
		//���̺� 1�� �߰� ��ư
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String newcontent[] = new String[9];

				// "�ڵ�","å�̸�","����","���ǻ�","������","å����","�帣","Remain","Category"
				newcontent[0] = codeLabel.getText();
				newcontent[1] = booknameLabel.getText();
				newcontent[2] = authorLabel.getText();
				newcontent[3] = chulpanLabel.getText();
				newcontent[4] = dateLabel.getText();
				newcontent[5] = conditionLabel.getText();
				newcontent[6] = genreLabel.getText();
				newcontent[7] = RemainLabel.getText();
				newcontent[8] = categoryLabel.getText();

				tableModel.addRow(newcontent);

				// ���̺� �ٲ������� �ݿ�
				table.updateUI();

			}
		});	
		
		//DB���� ������ ���� ��������
		
		loadDBButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

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

			}
		});	
		
		saveDBButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int rowcount = tableModel.getRowCount();
				System.out.println(rowcount);

				for(int i = 0; i< rowcount; i++) {
					
					DTO dto = new DTO();

					dto.setCode((String)tableModel.getValueAt(i, 0));
					dto.setBookname((String)tableModel.getValueAt(i, 1));
					dto.setAuthor((String)tableModel.getValueAt(i, 2));
					dto.setEditorial((String)tableModel.getValueAt(i, 3));
					
					String date = (String)tableModel.getValueAt(i, 4);
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date to = new Date();
					try {
						to = transFormat.parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					dto.setPublish_day(to);
					
					dto.setCondition((String)tableModel.getValueAt(i, 5));
					dto.setKind((String)tableModel.getValueAt(i, 6));
					
					String Remain =(String)tableModel.getValueAt(i, 7);
					int remainint = Integer.parseInt(Remain);
					dto.setRemain(remainint);
					
					String category = (String)tableModel.getValueAt(i, 8);
					int categoryint = Integer.parseInt(category);
					dto.setCategory(categoryint);
					
					dao.insert(dto);
				}

			}
		});	
	
	}
}