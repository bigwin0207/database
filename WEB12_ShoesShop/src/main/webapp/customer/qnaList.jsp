<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<section>
		
	<%@ include file="sub_image_menu.jsp" %> 
			<article>
			<form>
				<h2>Q & A List</h2>
					<div class="tb">
						<div class="row">
							<div class="coltitle">번호</div>
							<div class="coltitle">제목</div>
							<div class="coltitle">작성일</div>
							<div class="coltitle">답변여부</div>
						</div>
						<c:forEach items="${qnaList}" var="qnaVO">
							<div class="row">
								<div class="col">${qnaVO.qseq}</div>
								<div class="col">
									<a href="shop.do?command=qnaView&qseq=${qnaVO.qseq}">${qnaVO.subject}</a>
								</div>
								<div class="col"><fmt:formatDate value="${qnaVO.indate}" type="date" /></div>
								<div class="col">
									<c:choose>
										<c:when test="${empty qnaVO.reply}">NO</c:when>
										<c:otherwise>YES</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:forEach>
							<c:url var="action" value="shop.do?command=qnaList"/>
						<div class="row">
							<div class="coltitle"  style="font-size:120%; font-weight:bold;">
								<c:if test="${paging.prev}">
									<a href="${action}&page=${paging.beginPage-1}">◀</a>&nbsp;
								</c:if>
								<c:forEach begin="${paging.beginPage}" end="${paging.endPage}" var="index">
									<c:if test="${paging.page == index }">
										<span style="color:red">&nbsp;${index}&nbsp;</span>
									</c:if>
									<c:if test="${paging.page != index }">
										<a href="${action}&page=${index}">${index}&nbsp;</a>
									</c:if>
								</c:forEach>
								<c:if test="${paging.next}">
									&nbsp;<a href="${action}&page=${paging.endPage+1}">▶</a>&nbsp;
								</c:if>
							</div>
						</div>
					<div class="row">
						<div class="coltitle">
							<div class="btn">
							<input type="button" value="질문하기" onClick="location.href='shop.do?command=writeQnaForm'"/>
							</div>
						</div>
					</div>
				</div>
				</form>
			</article>
	</div>
</section>


<%@ include file="../footer.jsp" %>