<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userName = request.getParameter("userName"); // response.sendRedirect로 전송된 경우
%>

<h2><%=userName %>(<%=request.getParameter("userID") %>)님 환영합니다</h2>
</body>
</html>