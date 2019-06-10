package net.ptcs.my12306.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToUpdatePasswordServlet
 */
@WebServlet(description = "", urlPatterns = { "/ToUpdatePasswordServlet" })
public class ToUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respnose) throws ServletException, IOException {

		//跳转到修改密码页面
		request.getRequestDispatcher("/user/user_password_edit.jsp").forward(request,respnose);
	}
       

}
