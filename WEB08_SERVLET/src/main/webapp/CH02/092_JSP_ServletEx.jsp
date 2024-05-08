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
String id = (String)request.getAttribute("id");
String pwd = (String)request.getAttribute("pwd");
String gender = (String)request.getAttribute("gender");
String content = (String)request.getAttribute("content");
String[] itemName = (String[])request.getAttribute("item");
String job = (String)request.getAttribute("job");
%>
<h2>
아이디: <%=id %><br/>
암호: <%=pwd %><br/>
성별: <%=gender %><br/>
하고싶은말: <%=content %><br/>
구입하신 상품 :
<%
	for(String item : itemName)
		out.print(item + " ");
%><br/>
직업 : <%=request.getAttribute("job") %><br/>
</h2>
</body>
</html>