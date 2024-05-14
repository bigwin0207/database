package com.himedia.board.controller.action.board;

import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.dao.BoardDao;
import com.himedia.board.dao.MemberDao;
import com.himedia.board.dto.BoardDto;
import com.himedia.board.dto.MemberDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InsertBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto = new BoardDto();
		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		
		bdao.insertBoard(bdto);
		
		response.sendRedirect("board.do?command=main");
		}
	

	}

