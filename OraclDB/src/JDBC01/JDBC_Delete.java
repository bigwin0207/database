package JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Delete {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String id ="scott";
	    String pw ="tiger";
	    Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			Scanner sc = new Scanner(System.in);
			
			System.out.print("삭제할 회원의 번호를 입력하세요");
			int num = Integer.parseInt(sc.nextLine());
			int select = Integer.parseInt(sc.nextLine());
			
			String sql = "";
			if(select == 1 ) {
				
				sql = "delete customer set sql = ? set email = ? where num = ? ";
			}else {
				System.out.print("삭제에 실패 했습니다");
				
			}
			
			
			
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
