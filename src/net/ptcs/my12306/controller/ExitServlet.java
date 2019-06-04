package net.ptcs.my12306.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExitServlet
 */
@WebServlet("/ExitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exitSerlet");
		
		/*
		 * 退出功能的思路：
		 * 1.把cookie清除掉
		 * 2.返回登录页面
		 * 3.把session也清理掉
		 */
		//3.把session也清理掉
		HttpSession session=request.getSession();
		session.invalidate();//销毁session，会马上重新创建一个新的session
		
		//1.把cookie清除掉
		Cookie username_cookie=new Cookie("username", null);
		username_cookie.setMaxAge(0);
		username_cookie.setPath(request.getContextPath()+"/");
		
		Cookie password_cookie=new Cookie("password",null);
		password_cookie.setMaxAge(0);
		password_cookie.setPath(request.getContextPath()+"/");
		
		Cookie rule_cookie=new Cookie("rule",null);
		rule_cookie.setMaxAge(0);
		rule_cookie.setPath(request.getContextPath()+"/");
		
		response.addCookie(username_cookie);
		response.addCookie(password_cookie);
		response.addCookie(rule_cookie);
		//2.返回登录页面
		response.sendRedirect("login.jsp");
	}
       

}
