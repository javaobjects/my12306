package net.ptcs.my12306.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ptcs.my12306.service.UserService;

/**
 * Servlet implementation class CheckNameServlet
 */
@WebServlet(description = "检查用户名是否存在", urlPatterns = { "/CheckNameServlet" })
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		
		//调用底层service，到数据库查询用户名，判断用户名是否可用
		UserService userService = UserService.getInstance();
		response.setContentType("text/plain;charset=utf-8");
		
		if(!userService.isExistsUserName(username))
		{
			//返回客户端结果：可用
			response.getWriter().println("可用");
		}else
		{
			//返回客户端结果：不可用
			response.getWriter().println("不可用");
		}
	}
	

	
}
