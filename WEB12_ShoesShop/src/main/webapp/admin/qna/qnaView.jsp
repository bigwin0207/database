<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>

<article>
<form method="post" name="frm">
	<h2>Q & A View</h2>
				<input type="hidden" name="qseq" value="${QnaVO.qseq}"/>
				<div class="field" style="border-top:2px solid  yellowgreen; ">
					<label>작성자</label><div>${QnaVO.userid}</div>
				</div>
				<div class="field" style="border-top:1px dotted  yellowgreen;">
					<label>제목</label><div>${QnaVO.subject}</div>
				</div>
				<div class="field" style="border-top:1px dotted  yellowgreen;">
					<label>등록일</label><div><fmt:formatDate value="${QnaVO.indate}" type="date" /></div>
				</div>
				<div class="field" style="border-top:1px dotted  yellowgreen;">
					<label>질문내용</label><div><pre>${QnaVO.content}</pre></div>
				</div>
				<div class="field" style="border-bottom:2px solid  yellowgreen; border-top:1px dotted  yellowgreen;">
					<label>답변내용</label>
					<div style="padding:30px; justify-content:flex-start; align-items:center;">
					<c:choose>
					<c:when test="${empty QnaVO.reply}">
						<img src="admin/images/opinionimg01.gif" style="flex:1; width:200px;">
						<textarea name="reply" rows="3" cols="60"></textarea>
						<input type="button" style="background-color:blueviolet; color:white; border:none;"  value="저장" onClick="go_rep();">
					</c:when>
					<c:otherwise><!-- 관리자 답변후 표시 -->
						${QnaVO.reply}
					</c:otherwise>
					</c:choose>
					</div>
				</div>
				<div class="btn" >
					<input type="button" value="목록으로" onClick="location.href='shop.do?command=adminQnaList'">
				</div>
</form>
</article>
<%@ include file="/admin/footer.jsp" %>