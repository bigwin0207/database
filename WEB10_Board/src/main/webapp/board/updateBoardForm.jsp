<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css"/>
<script src="script/board.js"></script>
</head>
<body>
<div id="main_container">
	<h2>게시글 등록</h2>
	<div class="board">
	<form class="insertBoard" method="post" name="insertBoard" action="board.do">
		<div class="field"><label>작성자</label><input type="text" name="userid" value="${loginUser.userid}" readonly /></div>
		<div class="field"><label>비밀번호</label><input style="flex:2" type="password" name="pass" /><div  style="flex:2; margin-left:20px;">게시물 작성 시 입력한 비밀번호 입력</div></div>
		<div class="field"><label>이메일</label><input type="text" name="email" value="${board.email}"/></div>
		<div class="field"><label>제목</label><input type="text" name="title"  value="${board.title}"/></div>
		<div class="field"><label>내용</label><textarea name="content" rows="10" cols="100"/>${board.content}</textarea>
		</div>
		<div class="field">
		<input type="submit" value="수정완료" onClick="return updateBoardCheck('${board.pass}')" />
	   	<input type="button" value="되돌아가기" onClick="location.href='board.do?command=boardView&num=${board.num}'"/> />
	   	</div>
		<input type="hidden" name="command" value="updateBoard"/>
		<input type="hidden" name="num" value="${board.num}"/>
		</form>
	</div>
</div>

</body>
</html>