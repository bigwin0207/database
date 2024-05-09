<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement pstmt = null;

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/scott";
String id="root";
String pw="adminuser";

String sql = "insert into members(id, name, pwd, phone) values( ? , ? , ? , ?)";

//insertForm.jsp  에서 전송된 데이터들을 이용하여 Members 테이블에 레코드를 추가하세요

String userid = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String phone = request.getParameter("phone");
try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, id, pw);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(2, name);
		pstmt.setString(3, pwd);
		pstmt.setString(4, phone);
		pstmt.executeUpdate();
}catch( Exception e){ e.printStackTrace();
}finally{
		try{
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception e){ e.printStackTrace();
		}
}
response.sendRedirect("MemberMGR.jsp");

%>










