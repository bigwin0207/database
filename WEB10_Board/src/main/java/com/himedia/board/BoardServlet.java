package com.himedia.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.himedia.board.controller.action.Action;
import com.himedia.board.controller.action.LoginAction;
import com.himedia.board.controller.action.LoginFormAction;


public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Action ac = null;
		
		String command = request.getParameter("command");
		System.out.print("command : " + command);
		
		if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac  = new LoginAction();
		ac.execute(request,response);
		 
			/*
			 * if(command.equals("loginForm")) {
			 * 
			 * // LoginFormAction lfa = new LoginFormAction(); ac = new LoginFormAction();
			 * //lfa.execute(request,response); // ac.execute(request,response); }else
			 * if(command.equals("login")) { ac = new LoginAction(); }
			 * ac.execute(request,response);
			 */
		
		/*
			 * else if(command.equals("joinForm")) {
			 * 
			 * joinFormAction jfa = new joinFormAction(); jfa.execute(request,response);
			 * 
			 * }else if(command.equals("join")) {
			 * 
			 * 
			 * joinAction ja = new joinAction(); ja.execute(request,response); }
			 */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
