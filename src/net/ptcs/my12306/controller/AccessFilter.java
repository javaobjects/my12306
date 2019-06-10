package net.ptcs.my12306.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ptcs.my12306.entity.Users;

/**
 * Servlet Filter implementation class AccessFilter
 */
@WebFilter(description = "对访问进行控制的过滤器类", urlPatterns = { "/AccessFilter" })
public class AccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//这行代码保证多个过滤器依次执行
		/**
		 * 如何进行访问权限控制？
		 * 思路：
		 * 1、获取请求的url
		 * 2、对url进行判断，看用户是不是访问管理员模块，看用户是不是访问用户模块
		 * 3、如果访问管理员模块，那么必须第一登录，第二用户的rule是1，否则先登录去
		 * 4、如何访问用户模块，那么必须第一登录，第二用户的rule是2,否则先登录去
		 * 5、如果访问的既不是管理员模块又不是用户模块，那么放行
		 * 
		 * 
		 */
		HttpServletRequest res = null;
		if(request instanceof HttpServletRequest) {
			request = (HttpServletRequest)request;
		}
		
		HttpServletResponse resp = null;
		if(response instanceof HttpServletResponse) {
			response = (HttpServletResponse)response;
		}
		
		String url = res.getRequestURL().toString();
		System.out.println("url:" + url);
		
		
		//从session获取user
		HttpSession session = res.getSession();
		Users user = (Users)session.getAttribute("user");
		
		if(url.contains("/admin/")) {

			if(user != null) {
				//用户已登录
				if(user.getRule().equals("1")) {
					//放行的代码
					chain.doFilter(request,response);
				}else {
					//登录咯但是身份不对 重定向到登录页面
					resp.sendRedirect(res.getContextPath() + "/login.jsp");
				}
			}else {
				//没有登录重定向到登录页面
				resp.sendRedirect(res.getContextPath() + "/login.jsp");
			}
		}else if(url.contains("/user/")) {
			if(user != null) {
				//用户已登录
				if(user.getRule().equals("2")) {
					//放行的代码
					chain.doFilter(request,response);
				}else {
					//登录咯但是身份不对 重定向到登录页面
					resp.sendRedirect(res.getContextPath() + "/login.jsp");
				}
			}else {
				//没有登录重定向到登录页面
				resp.sendRedirect(res.getContextPath() + "/login.jsp");
			}
		}else {
			//放行的代码
			chain.doFilter(request,response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
