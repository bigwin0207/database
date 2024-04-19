package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class MemberDao {
	
	
	
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
    public ArrayList<MemberDto> getMemberlist() {
		
		con = getConnection();
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		
		String sql = "select * from member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			MemberDto mdto = new MemberDto();
			mdto.setUserid(userid);
			mdto.setPwd(rs.getString("pwd"));
			mdto.setName(rs.getString("name"));
			mdto.setPhone(rs.getString("phone"));
			mdto.setEmail(rs.getString("email"));
			
			list.add(mdto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return list;
	}
    

}