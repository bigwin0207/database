package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDao {
	
	private RentDao() {}
	private static RentDao itc = new RentDao();
	public static RentDao getInstence() {
		return itc;
	}
	
	// Dbman db = new Dbman();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//	public void abc() { 
	//		 con = Dbman.getConnection();
	//		 
	//		 Dbman.close(con,pstmt,rs);
	// }	
	
	public ArrayList<RentDto> selectRent() {
		ArrayList<RentDto> list = new ArrayList<RentDto>();
		con = Dbman.getConnection();
		
		String sql = "select*from rentDetail order by numseq desc"; //view 생성 후 select
		
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RentDto rdto = new RentDto();
				rdto.setNumseq(rs.getInt("numseq"));
				rdto.setRentdate(rs.getString("rd"));
				rdto.setBnum(rs.getInt("bnum"));
				rdto.setSubject(rs.getString("subject"));
				rdto.setMnum(rs.getInt("mnum"));
				rdto.setName(rs.getString("name"));
				rdto.setRentprice(rs.getInt("rentprice"));
				rdto.setDiscount(rs.getInt("discount"));
				rdto.setAmount(rs.getInt("amount"));
				list.add(rdto);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs); }
		return list;
	}

	public int memberOk(String membernum) {
		int result = 0;
		con =Dbman.getConnection();
		// String sql = "select count(*)as cnt from memberlist where mebernum = ?" ;
		String sql = "select* from memberlist where mebernum = ?" ;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(membernum));
			rs = pstmt.executeQuery();
			if(rs.next() ) {
				// result = rs.getInt("cnt");
				result =1;
			}
		} catch (SQLException e) {  e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		return result;
	}
	
	public int bookOk(String booknum) {
		int result = 0;
		con =Dbman.getConnection();
		// String sql = "select count(*)as cnt from booklist where booknum = ?" ;
		String sql = "select* from booklist where booknum = ?" ;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(booknum));
			rs = pstmt.executeQuery();
			if(rs.next() ) {
				// result = rs.getInt("cnt");
				result =1;
			}
		} catch (SQLException e) {  e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs); }
		return result;
	}
}
