package com.hiemia.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hiemia.member.dto.MemberDto;


public class UpadateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpadateServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott";
		String id="root";
		String pw="adminuser";

		String sql = "select *from members where id=?";

		String userid = request.getParameter("id");
		MemberDto mdto = new MemberDto();
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				mdto.setId(rs.getString("id"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
			}
		}catch(ClassNotFoundException e){	e.printStackTrace();
		}catch(SQLException e){	e.printStackTrace();
		}finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null)	con.close();
			} catch (Exception e) {	e.printStackTrace();	}
		}
		request.setAttribute("member",mdto);
		RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Connection con = null;
		PreparedStatement pstmt = null;

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott";
		String id="root";
		String pw="adminuser";
		String sql="update members set  name=?, pwd=?, phone=? where id=?";
				
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String updateid = request.getParameter("id");
		
		try{
				Class.forName(driver);
				con = DriverManager.getConnection(url, id, pw);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, pwd);
				pstmt.setString(3, phone);
				pstmt.setString(4, updateid);
				pstmt.executeUpdate();
		}catch( Exception e){ e.printStackTrace();
		}finally{
				try{
					if(con!=null) con.close();
					if(pstmt!=null) pstmt.close();
				}catch(Exception e){ e.printStackTrace();
				}
		}
		RequestDispatcher rd = request.getRequestDispatcher("start.do");
		rd.forward(request,response);
	}
	
}

