package net.ptcs.my12306.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ptcs.my12306.entity.City;
import net.ptcs.my12306.service.CityService;

/**
 * Servlet implementation class GetCityServlet
 */
@WebServlet(description = "省下拉框接口", urlPatterns = { "/GetCityServlet" })
public class GetCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provinceid=request.getParameter("pid");
		
		List<City> cities=CityService.getInstance().getCityByProvinceid(provinceid);
		System.out.println("获取的城市信息："+cities.toString());
		
		//输出一个xml文件
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		 PrintWriter writer=null;
				 try {
					writer=response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");//<?xml version="1.0" encoding="utf-8"?>
		 writer.write("<cities>");
		for(City city:cities)
		{
			//<city><cid>41</cid><cname>长沙市</cname></city>
			writer.write("<city><cid>"+city.getId()+"</cid><cname>"+city.getCityName()+"</cname></city>");
		}
		 writer.write("</cities>");
		writer.flush();
		writer.close();
	}


}
