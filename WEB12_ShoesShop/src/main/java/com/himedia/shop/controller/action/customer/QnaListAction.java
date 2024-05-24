package com.himedia.shop.controller.action.customer;

import java.io.IOException;
import java.util.ArrayList;

import com.himedia.shop.controller.action.Action;
import com.himedia.shop.dao.QnaDao;
import com.himedia.shop.dto.MemberVO;
import com.himedia.shop.dto.QnaVO;
import com.himedia.shop.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null) {
			response.sendRedirect("shop.do?command=loginForm");
		}else {
			QnaDao qdao = QnaDao.getInstance();
			Paging paging = new Paging();
			int page = 1;
			if( request.getParameter("page")!= null) {
				page =Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if( session.getAttribute("page") != null) {
				page= (Integer) session.getAttribute("page");
			}else {
				session.removeAttribute("page");
			}
			paging.setPage(page);
			paging.setDisplayPage(5);
			paging.setDisplayRow(5);
			
			int count = qdao.getAllCount();
			paging.setTotalCount(count);
			
			ArrayList<QnaVO> list = qdao.selectQna(paging);
			request.setAttribute("qnaList",list);
			request.setAttribute("paging", paging);
			request.getRequestDispatcher("customer/qnaList.jsp").forward(request, response);
		}

	}

}
