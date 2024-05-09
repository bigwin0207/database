<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_getCookie.jsp</title>
</head>
<body>

<% 
// 쿠키내용 한번에 다 얻어오는 명령-쿠키객체 배열로 얻어옵니다
Cookie[] cookies =request.getCookies();

for(Cookie c : cookies){
	out.println("<h2>" + c.getName() + " : " + c.getValue() + "</h2>");
}
%>
</body>
</html>