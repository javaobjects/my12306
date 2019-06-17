package net.ptcs.my12306.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ptcs.my12306.entity.CertType;
import net.ptcs.my12306.entity.City;
import net.ptcs.my12306.entity.UserType;
import net.ptcs.my12306.entity.Users;
import net.ptcs.my12306.service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(description = "", urlPatterns = { "/UpdateUserServlet" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、处理乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//2.获取这些待更新的数据：真实姓名 性别 城市 证件类型 证件号码 出生日期 旅客类型 备注：
		String id = request.getParameter("id");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		String certtype = request.getParameter("certtype");
		String cert = request.getParameter("cert");
		String birthday = request.getParameter("birthday");
		String usertype = request.getParameter("usertype");
		String content = request.getParameter("content");
		
		//3、把数据封闭到User对象中
		Date birth = null;
		try {
			birth = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CertType cert_type = new CertType(Integer.parseInt(certtype),null);
		UserType user_type = new UserType(Integer.parseInt(certtype),null);
		
		System.out.println(id);
		System.out.println(Integer.parseInt(id));
		System.out.println(realname);
		System.out.println(sex.charAt(0));
		System.out.println("city"+city);
		System.out.println(new City(Integer.parseInt(city)));
		System.out.println(cert_type);
		System.out.println(cert);
		System.out.println(birth);
		System.out.println(user_type);
		System.out.println(content);
		
		Users user=new Users(Integer.parseInt(id), null, null, null, realname, 
				sex.charAt(0), new City(Integer.parseInt(city)), cert_type, cert, birth, user_type, content, null, null, null);
		//4、调用底层的UserService中的更新方法更新用户信息
		UserService userService = UserService.getInstance();
		boolean result = userService.updateUser(user);
		
		if(result) {
			//重定向到ToUpdateUserServlet即可:再次获取更新后的用户信息然后去往更新页面展示，让用户看到更新后的效果
			//同步更新session中的用户信息
			HttpSession session = request.getSession();
			Users session_user = (Users) session.getAttribute("user");
			session.setAttribute("user", userService.login(session_user.getUsername(), session_user.getPassword()));
			response.sendRedirect("ToUpdateUserServlet");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>alert('更新失败');</script>");
		}
	}
}
