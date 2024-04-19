package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BoardDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid ="scott";
    String pw ="tiger";

    public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, pw);
		} catch (SQLException e) {  e.printStackTrace();
		} catch (ClassNotFoundException e) {  e.printStackTrace();
		} 
		return con;
}
    public ArrayList<boardDto> getboardlist() {
		
		con = getConnection();
		ArrayList<boardDto> list = new ArrayList<boardDto>();
		
		
		String sql = "select * from board";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			boardDto bdto = new boardDto();
			bdto.setBoardnum(rs.getInt("boardnum"));
			bdto.setWriter(rs.getString("writer"));
			bdto.setSubject(rs.getString("subject"));
			bdto.setContent(rs.getString("content"));
			bdto.setWrite(rs.getString("write"));
			bdto.setReadcount(rs.getString("readcount"));
			
			list.add(bdto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return list;
	}
}
