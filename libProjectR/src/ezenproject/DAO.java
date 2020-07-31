package ezenproject;

import java.util.*;
import java.util.Date;

import errorAndfalse.RecordNotFoundException;

import java.sql.*;

public class DAO {

	String driver = "oracle.jdbc.driver.OracleDriver";

	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String userid = "sys as SYSDBA";

	String passwd = "1234";

	public DAO( ) {

		try {

			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	public ArrayList<DTO> select() {

		ArrayList<DTO> list = new ArrayList<DTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {		

			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT * FROM abookmange";

			pstmt = con.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				DTO dto = new DTO();

				dto.setCode(rs.getString("code"));

				dto.setBookname(rs.getString("bookname"));

				dto.setAuthor(rs.getString("author"));

				dto.setEditorial(rs.getString("editorial"));

				dto.setPublish_day(rs.getDate("publish_day"));

				dto.setCondition(rs.getString("condition"));

				dto.setKind(rs.getString("kind"));
			
				dto.setRemain(rs.getInt("remain"));
				
				dto.setCategory(rs.getInt("category"));

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return list;

	} 



	public int insert(DTO dto) {

		Connection con = null;

		PreparedStatement pstmt = null;

		int n = 0;



		try {
			con = DriverManager.getConnection(url, userid, passwd);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}


		String sql = "INSERT INTO abookmanage(code,bookname,author,editorial,publish_day,condition,kind,remain,category)"
				+
				" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			pstmt = con.prepareStatement(sql);

			System.out.println(dto.getCode());

			pstmt.setString(1, dto.getCode());

			pstmt.setString(2, dto.getBookname());

			pstmt.setString(3, dto.getAuthor());

			pstmt.setString(4, dto.getEditorial());

			pstmt.setDate(5, convertToSQL(dto.getPublish_day()));

			pstmt.setString(6, dto.getCondition());

			pstmt.setString(7, dto.getKind());
	
			pstmt.setInt(8, dto.getRemain());
	
			pstmt.setInt(9, dto.getCategory());

			n = pstmt.executeUpdate();

			con.commit();

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return n;

	} 


	public int delete(String bookcode) {

		Connection con = null;

		PreparedStatement pstmt = null;

		int n = 0;

		try {

			con = DriverManager.getConnection(url, userid, passwd);

			String sql = "DELETE FROM abookmanage WHERE code = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bookcode);

			n = pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return n;

	} 


		public int update(DTO dto) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int n = 0;
		try {

			con = DriverManager.getConnection(url, userid, passwd);

			String sql = "UPDATE abookmanage SET bookname=?,  author=?, editorial=?, publish_day=?, condition=?, " +

               " kind=?, remain=?, category=? WHERE code = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getBookname());
			pstmt.setString(2, dto.getAuthor());

			pstmt.setString(3, dto.getEditorial());

			pstmt.setDate(4, convertToSQL(dto.getPublish_day()));

			pstmt.setString(5, dto.getCondition());

			pstmt.setString(6, dto.getKind());
	
			pstmt.setInt(7, dto.getRemain());
		
			pstmt.setInt(8, dto.getCategory());

			pstmt.setString(9, dto.getCode());

			n = pstmt.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return n;

	} 



	public ArrayList<DTO> isExist(String randomCode) {

		boolean result;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DTO> list = new ArrayList<DTO>();
		try {

			con = DriverManager.getConnection(url, userid, passwd);

			String sql = "SELECT * FROM abookmange WHERE code = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, randomCode);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				DTO dto = new DTO();

				dto.setCode(rs.getString("code"));

				list.add(dto);
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return list;

	}



	public ArrayList<DTO> searchAll(){

		Connection con = null;

		PreparedStatement pstmt = null;


		ResultSet rs = null;


		ArrayList<DTO> dtolist = new ArrayList<DTO>();

		try {

			con = DriverManager.getConnection(url, userid, passwd);

		
			String sql = "SELECT * FROM abookmanage";

			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();

			while (rs.next()) {

			
				DTO dto = new DTO();

				dto.setCode(rs.getString("code"));
				dto.setBookname(rs.getString("bookname"));
				dto.setAuthor(rs.getString("author"));
				dto.setEditorial(rs.getString("editorial"));	
	
				dto.setPublish_day(new Date(rs.getDate("publish_day").getTime()));
				dto.setCondition(rs.getString("condition"));
				dto.setKind(rs.getString("kind"));
		
				dto.setRemain(rs.getInt("remain"));
		
				dto.setCategory(rs.getInt("category"));

		
				dtolist.add(dto);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}


		return dtolist;

	}



	public ArrayList<DTO> search(String bookname) throws RecordNotFoundException {




		Connection con = null;
		PreparedStatement pstmt = null;
	
		ResultSet rs = null;

		ArrayList<DTO> dtolist = new ArrayList<DTO>();

		try {

			con = DriverManager.getConnection(url, userid, passwd);

	
			String sql = "SELECT * FROM abookmanage WHERE (bookname||Editorial||Publish_day) LIKE '%"+bookname+"%'";
		

			System.out.println(sql);
			System.out.println(bookname);

			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();

		
			while (rs.next()) {

				System.out.println("111");

		
				DTO dto = new DTO();

				dto.setCode(rs.getString("code"));
				dto.setBookname(rs.getString("bookname"));
				dto.setAuthor(rs.getString("author"));
				dto.setEditorial(rs.getString("editorial"));	
			
				dto.setPublish_day(new Date(rs.getDate("publish_day").getTime()));
				dto.setCondition(rs.getString("condition"));
				dto.setKind(rs.getString("kind"));
				
				dto.setRemain(rs.getInt("remain"));
				
				dto.setCategory(rs.getInt("category"));

		
				dtolist.add(dto);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return dtolist;

	} 
	
	

	
	
	public int count() {
		int rowcount=0;
		
	try {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		     Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "sys as SYSDBA", "1234");
    Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    
    ResultSet rs = stmt.executeQuery( "SELECT * FROM abookmanage");
     rs.last();     
     rowcount = rs.getRow();
     rs.beforeFirst();

     System.out.println("Total rows : " + rowcount);         
    
     rs.close();
     stmt.close();
     conn.close();
	}catch(SQLException e){
		
	}
     return rowcount;
	}
	
	

	public int floorA() {
		int rowcount=0;
	try {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		   Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "sys as SYSDBA", "1234");
    Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    
    ResultSet rs = stmt.executeQuery( "SELECT code FROM abookmanage WHERE code LIKE 'A%'");
     rs.last();     
     rowcount = rs.getRow();
     rs.beforeFirst();
     System.out.println("Total rows : " + rowcount);         
    
     rs.close();
     stmt.close();
     conn.close();
	}catch(SQLException e){
		
	}
     return rowcount;
	}
	
	

	public int floorB() {
		int rowcount=0;
	try {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		     Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "sys as SYSDBA", "1234");
    Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    
    ResultSet rs = stmt.executeQuery( "SELECT code FROM abookmanage WHERE code LIKE 'B%'");
     rs.last();     
     rowcount = rs.getRow();
     rs.beforeFirst();
     System.out.println("Total rows : " + rowcount);         
    
     rs.close();
     stmt.close();
     conn.close();
	}catch(SQLException e){
		
	}
     return rowcount;
	}
	
	
	

	public int floorC() {
		int rowcount=0;
	try {
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "sys as SYSDBA", "1234");
    Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    
    ResultSet rs = stmt.executeQuery( "SELECT code FROM abookmanage WHERE code LIKE 'C%'");
     rs.last();     
     rowcount = rs.getRow();
     rs.beforeFirst();
     System.out.println("Total rows : " + rowcount);         
    
     rs.close();
     stmt.close();
     conn.close();
	}catch(SQLException e){
		
	}
     return rowcount;
	}
	
	
	public java.sql.Date convertToSQL(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
}