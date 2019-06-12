package net.ptcs.my12306.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ptcs.my12306.entity.Users;
import net.ptcs.my12306.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(description = "", urlPatterns = { "/UserServlet" })
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
		StringBuffer sb = validateRegisterForm(username, password, confirm_password);
		
		if(sb.length() > 0) {
			//如果校验不通过，那么返回注册页面，让用户再注册一次
			request.setAttribute("message", "必填信息为空，请重新注册");
//			request.getRequestDispatcher("/user_register.jsp").forward(request, response);
			request.getRequestDispatcher("/ToRegisterViewServlet").forward(request, response);
		}else {
			//3.调用底层service的注册方法添加用户到数据库
			Date birthday=null;
			try {
				birthday=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			UserService userService=UserService.getInstance();
			
			Users user = new Users(request.getParameter("username"), request.getParameter("password"), 
					request.getParameter("sex").charAt(0), birthday);
			user.setLoginIp(request.getRemoteAddr());
			//服务端校验通过之后，注册方法调用之前，应该先判断用户名是否已经存在
			/*
			 * 则需要定义判断用户名是否已经存在的方法，如果存在则返回注册页面，提示用户名已经存在，
			 * 								 如果不存在则继续注册
			 */

			if(userService.isExistsUserName(username))
			{
				//用户名已经存在，回到注册页面
				request.setAttribute("message", "用户名已被占用");
//				request.getRequestDispatcher("/user_register.jsp").forward(request, response);
				request.getRequestDispatcher("/ToRegisterViewServlet").forward(request, response);
		
			}else
			{

				if(userService.register(user))
				{
					//System.out.println("register success");
					//注册成功，重定向去到登录页面
					//request.getRequestDispatcher("/login.jsp").forward(request, response);
					/*
					 
					 //弹窗效果:技术实现，对响应进行设置，响应就是response
					response.setContentType("text/html;charset=utf-8");
					//获取输出流，输出一段script代码
					PrintWriter pw=response.getWriter();
					pw.println("<script>alert('"+"注册成功"+"');location.href='login.jsp';</script>");
				
					 
					 */
					//生产环境不用挨骂的代码：需求,既要有弹窗又要重定向登录页面
					
					response.sendRedirect(request.getContextPath()+"/login.jsp?message=registersuccess");
					
					//response.sendRedirect(request.getContextPath()+"/login.jsp");//request.getContextPath()===/my12306_user_register
				}else
				{
//					System.out.println("register fail");
					//注册失败，回到注册页面
					request.setAttribute("message", "注册失败");
					//request.getRequestDispatcher("/user_register.jsp").forward(request, response);
					request.getRequestDispatcher("/ToRegisterViewServlet").forward(request, response);
				}
			}
		}
	}
	/**
	 * 对表单进行服务端校验的方法 
	 * @param username
	 * @param password
	 * @param confirm_password
	 * @return 
	 */
	private StringBuffer validateRegisterForm(String username, String password,
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
		if(!password.equals(confirm_password))
		{
			validate_message.append("两次密码输入不一致");
		}
		if(validate_message.length()>0)
		{
			System.out.println(validate_message.toString());
			return validate_message;
		}
		return validate_message;
	}
       
   
}
