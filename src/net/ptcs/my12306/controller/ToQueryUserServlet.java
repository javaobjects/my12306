package net.ptcs.my12306.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToQueryUserServlet
 */
@WebServlet(description = "去往查询用户界面的servlet", urlPatterns = { "/ToQueryUserServlet" })
public class ToQueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//由于不需要带礼物（传递数据）给页面，所以直接跳转过去
		request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);
	}

}
