package net.ptcs.my12306.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ptcs.my12306.entity.CertType;
import net.ptcs.my12306.entity.City;
import net.ptcs.my12306.entity.UserType;
import net.ptcs.my12306.entity.Users;
import net.ptcs.my12306.service.UserService;
import net.ptcs.my12306.util.Md5Utils;

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
		
		//1.获取数据
		String username=request.getParameter("username");//用户名
		String password=request.getParameter("password");//密码
		String confirm_password=request.getParameter("confirm_password");//确认密码
		String real_name = request.getParameter("real_name");//真实姓名
		String sex=request.getParameter("sex");//性别
		String province = request.getParameter("province");//省份
		String city = request.getParameter("city");//城市
		String cert_type = request.getParameter("cert_type");//证件类型
		String cert = request.getParameter("cert");//证件号码
		String birthday_date=request.getParameter("birthday");//出生日期
		String user_type = request.getParameter("user_type");//旅客类型
		String content = request.getParameter("content");//备注
		String agree = request.getParameter("agree");//是否同意on/null 被选中/非选

		//2.数据的非空校验和合法性校验
		StringBuffer sb = validateRegisterForm(username, password, confirm_password,agree);
		
		if(sb.length() > 0) {
			//如果校验不通过，那么返回注册页面，让用户再注册一次
			request.setAttribute("message", "必填信息为空，请重新注册");
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

//			Integer id, String username, String password, String rule,
//			String realname, Character sex, City city, CertType certtype,
//			String cert, Date birthday, UserType usertype, String content,
//			Character status, String loginIp, String imagePath   String.charAt(Integer.parseInt(sex))  cert_type user_type 1
			
//			Users user = new Users(null,username,password,"2",real_name,null,
//					new City().setCityId(city),null,cert,birthday,null,content,null,request.getRemoteAddr(),null);//此处应该将所有的数据插入
			
			Users user = new Users();
			user.setUsername(username);//用户名
			user.setPassword(Md5Utils.md5(password));//密码
			user.setRule("2");//用户类型 2为普通用户
			user.setRealname(real_name);//真实姓名
			user.setSex(sex.charAt(0));//性别 String 转 Character
			
			City c = new City();
			c.setCityId(city);
			user.setCity(c);//获取城市 String 转 引用类型
			
			user.setCerttype(new CertType(Integer.parseInt(cert_type), null));//证件类型 String 转 引用类型
			
			user.setCert(cert);//证件号码
			
			try {
				user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday_date));
			} catch (ParseException e) {
				e.printStackTrace();
			}//出身日期 String 转 date
			
			user.setUsertype(new UserType(Integer.parseInt(user_type), null));//旅客类型 String 转 引用类型
			
			user.setContent(content);//备注
			user.setLoginIp(request.getRemoteAddr());//设置IP
			
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
	private StringBuffer validateRegisterForm(String username, String password,String confirm_password,String agree) {
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
		if(agree == null) {
			validate_message.append("请阅读《中国铁路客户服务中心网站服务条款》并勾选");
		}
		if(validate_message.length()>0)
		{
			System.out.println(validate_message.toString());
			return validate_message;
		}
		return validate_message;
	}
       
   
}
