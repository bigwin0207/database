<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
// updateMember_do.jsp
// 데이터베이스 연결하고 , 전달된 내용을 레코드를 수정하세요
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement pstmt = null;

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/scott";
String id="root";
String pw="adminuser";

String sql = "update members set  id=?, name=?, pwd=?, phone=? where id=?";

String name = request.getParameter("name");
String pwd = request.getParameter("pwd");
String phone = request.getParameter("phone");
/* String updateid = request.getParameter("id");  */
String oldid = request.getParameter("oldid");
String newid = request.getParameter("newid");

try{
	Class.forName(driver);
	con = DriverManager.getConnection(url, id, pw);
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, newid);
	pstmt.setString(2, name);
	pstmt.setString(3, pwd);
	pstmt.setString(4, phone);
	pstmt.setString(5, oldid);
	pstmt.executeUpdate();		
}catch(Exception e){	e.printStackTrace();
}finally{
	try {
		if (pstmt != null) pstmt.close();
		if (con != null)	con.close();
	} catch (Exception e) {	e.printStackTrace();	}
}
response.sendRedirect("MemberMGR.jsp");
%>