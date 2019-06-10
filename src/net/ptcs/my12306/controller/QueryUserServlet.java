package net.ptcs.my12306.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ptcs.my12306.entity.Users;
import net.ptcs.my12306.service.UserService;

/**
 * 对应管理员模块：查询用户信息功能的servlet
 */
@WebServlet(description = "对应管理员模块：查询用户信息功能的servlet", urlPatterns = { "/QueryUserServlet" })
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------------");
		//获取表单数据
		String username=request.getParameter("username");
		
		String cert_type=request.getParameter("cert_type");
		String cert=request.getParameter("cert");
		
		String user_type=request.getParameter("user_type");
		String sex=request.getParameter("sex");
		System.out.println("======================");
		
		//怎么查询servlet是不管的，全部交给service，servlet只管调用
		UserService userService=UserService.getInstance();
		
		List<Users> users=userService.getUserByCondition(username,Integer.parseInt(cert_type),cert,Integer.parseInt(user_type),sex.charAt(0));
		
		System.out.println(users.toString());
		
		//回传刚刚输入的查询条件
		request.setAttribute("username", username);
		request.setAttribute("cert_type", cert_type);
		request.setAttribute("cert", cert);
		request.setAttribute("user_type", user_type);
		request.setAttribute("sex", sex);
		request.setAttribute("userList", users);//把查询结果users传给userlist.jsp页面
		request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);
	}
       
}
