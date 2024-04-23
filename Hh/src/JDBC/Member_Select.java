package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_Select {

	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/scott";
		String driver = "com.mysql.cj.jdbc.Driver";
		String id ="root";
	    String pw ="adminuser";
		
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			String sql = "select * from list";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("아이디\t패스워드\t\t phone \t\t\t 이름 \t\t 이메일 \t\t\t 작성자 \t\t제목 \t\t 내용 \t\t\t\t 날짜\t\t 조회수");
			System.out.println("----------------------------------------------------------");
			
			while(rs.next()) {
				
				String userid = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String phone = rs.getString("phone");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String writedate = rs.getString("writedate");
				int readcount = rs.getInt("readcount");
				System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t\t\t%s\t%s\n",userid, pwd, phone, name, email,writer, subject, content,writedate,readcount);
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(con != null)con.close();
			if(pstmt != null)pstmt.close();
			if(rs != null) rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
