package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class List_Insert {

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
			Scanner sc = new Scanner(System.in);
			
			System.out.print("아이디를 입력하세요");
			String userid =  sc.nextLine();
			System.out.print("패스워드를 입력하세요");
			String pwd = sc.nextLine();
			System.out.print("폰번호를 입력하세요");
			String phone = sc.nextLine();
			System.out.print("이름을 입력하세요");
			String name = sc.nextLine();
			System.out.print("이메일을 입력하세요");
			String email = sc.nextLine();
			System.out.print("작성자를 입력하세요");
			String writer = sc.nextLine();
			System.out.print("제목을 입력하세요");
			String subject  = sc.nextLine();
			System.out.print("내용을 입력하세요");
			String content = sc.nextLine();
			System.out.print("날짜 입력하세요");
			String writedate = sc.nextLine();
			System.out.print("조회수를 입력하세요");
			int readcount = sc.nextInt();
			
			
			
			
			String sql = " insert into list values(? , ? , ? , ?, ? ,? , ? , ? , ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, userid);
			pstmt.setString(2,  pwd );
			pstmt.setString(3, phone);
			pstmt.setString(4, name);
			pstmt.setString(5, email);
			pstmt.setString(6, writer);
			pstmt.setString(7,  subject );
			pstmt.setString(8, content);
			pstmt.setString(9, writedate);
			pstmt.setInt(10, readcount);
			
			
			
			int result = pstmt.executeUpdate();
			
			if(result == 1)System.out.println("레코드 추가 성공");
			else System.out.println("레코드 추가 실패 ");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(con != null)con.close();
			if(pstmt != null)pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		




	}

}
