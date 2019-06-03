package net.ptcs.my12306.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.neuedu.my12306.service.UserService;
import net.ptcs.my12306.entity.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取登录页面的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username: " + username +"\n password: " + password);
		/* 怎么写登录？
		 * 2.调用底层service的login方法，返回一条用户数据，这是一种用户体验
		 * 
		 * 如果用户信息不为空，则登录成功，跳转到用户模块的主页面
		 * 如果用户信息为空，则登录失败，提示失败信息并返回登录页面
		 */
		UserService service = UserService.getInstance();
		
		Users user = service.login(username,password);
		if(user == null) {
			//登录失败
			request.setAttribute("message", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//登陆成功
			//成功后跳转到哪？要看用户的rule：如果是管理员，去往管理员主页面；如果是普通用户，去往普通用户主页面
			if("2".equals(user.getRule())) {
				//普通用户
				request.getRequestDispatcher("user/index.jsp").forward(request,response);
			}else {
				//管理员
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);
			}
		}
	}
       

}
