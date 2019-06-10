package net.ptcs.my12306.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 启用连接池技术的DBUtil工具类
 * 
 * 步骤：
 * 1.在META-INF目录下创建配置文件context.xml
 * 2.编写DBUtils_pool工具类
 * 在里面定义getConnection方法
 * 
 * 3.这个方法定义完之后不可以马上写main方法测试，因为这个池子是基于Tomcat容器实现的，所以
 * 必须把web应用部署到Tomcat服务器上之后才可以测试
 * @author xianxian
 *
 */
public class DBUtils_pool {
	public static Connection getConnection()
	{
		Connection conn=null;
		try{
			//实例化Context对象，其实读取Context.xml文件中的资源
			Context context = new InitialContext();
			//使用lookup方法寻找数据源资源并且造型成DataSource
			 DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle/my12306");
			 conn = ds.getConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源的方法
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
