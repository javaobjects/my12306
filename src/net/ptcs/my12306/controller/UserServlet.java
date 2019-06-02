package net.ptcs.my12306.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.neuedu.my12306.service.UserService;
import net.ptcs.my12306.entity.Users;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*
		 stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getSex() + "");
			stmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			stmt.setString(5, user.getLoginIp());
		 */
		//1.获取数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirm_password=request.getParameter("confirm_password");
		String sex=request.getParameter("sex");
		String birthday_date=request.getParameter("birthday");
		
		//2.数据的非空校验和合法性校验
		validateRegisterForm(username, password, confirm_password);
		
		//3.调用底层service的注册方法添加用户到数据库
		Date birthday=null;
		try {
			birthday=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserService userService=UserService.getInstance();
		
		Users user=new Users(request.getParameter("username"), request.getParameter("password"), 
				request.getParameter("sex").charAt(0), birthday);
		user.setLoginIp(request.getRemoteAddr());
		if(userService.register(user))
		{
			System.out.println("register success");
		}else
		{
			System.out.println("register fail");
		}
		
		
	}

	/**
	 * 对表单进行服务端校验的方法 
	 * @param username
	 * @param password
	 * @param confirm_password
	 */
	private void validateRegisterForm(String username, String password,
			String confirm_password) {
		StringBuffer validate_message=new StringBuffer();
		if(username==null||"".equals(username))
		{
			validate_message.append("用户名为空");
		}
		if(password==null||"".equals(password)||confirm_password==null||"".equals(confirm_password))
		{
			validate_message.append("密码或者确认密码为空");
		}
		if(password.equals(confirm_password))
		{
			validate_message.append("两次密码输入不一致");
		}
		if(validate_message.length()>0)
		{
			System.out.println(validate_message.toString());
			return;
		}
	}
       
   
}
