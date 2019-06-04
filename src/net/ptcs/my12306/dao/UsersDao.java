package net.ptcs.my12306.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.ptcs.my12306.entity.CertType;
import net.ptcs.my12306.entity.City;
import net.ptcs.my12306.entity.Users;
import net.ptcs.my12306.util.DBUtils;

public class UsersDao {

	/**
	 * id NUMBER(11) not null, username VARCHAR2(30) not null, password
	 * VARCHAR2(50) not null, rule VARCHAR2(2) default '2' not null, realname
	 * VARCHAR2(50) not null, sex CHAR(1) default '1' not null, city NUMBER(11)
	 * not null, cert_type NUMBER(11) not null, cert VARCHAR2(50) not null,
	 * birthday DATE not null, user_type NUMBER(11), content VARCHAR2(3000),
	 * status CHAR(1) default '1' not null, login_ip VARCHAR2(50), image_path
	 * VARCHAR2(200)
	 */
	private static final String ADD_USER = "insert into tab_user(id,username,password,rule,realname,sex,city,cert_type"
			+ ",cert,birthday,user_type,content,status,login_ip,image_path)"
			+ " values (tab_user_seq.nextval,?,?,'2','张三',?,200,1,'440104201910106119',?,1,'备注','1',?,'')";
	
	private static final String QUERY_USER_BY_USERNAME_AND_PASSWORD = "select id,username,password,rule,realname,sex,city,cert_type"
			+ ",cert,birthday,user_type,content,status,login_ip,image_path from tab_user where username=? and password=?";

	private static final String QUERY_USERNAME = "select count(1) count from tab_user where username=?";

	public int addUser(Users user) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(ADD_USER);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getSex() + "");
			stmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			stmt.setString(5, user.getLoginIp());
			
			rows=stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, stmt, null);
		}

		return rows;
	}

	private UsersDao() {

	}

	public static UsersDao userDao;

	public static UsersDao getInstance() {
		if (userDao == null) {
			userDao = new UsersDao();
		}
		return userDao;
	}

	/**
	 *  根据用户名和密码查询用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public Users queryUserByUsernameAndPassword(String username, String password) {
		Users user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(QUERY_USER_BY_USERNAME_AND_PASSWORD);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
		
			if(rs.next()) {
				user = new Users();
				City city = new City();
				CertType cert_type = new CertType();
				/*
				 * id,username,password,rule,realname,sex,city,cert_type"
			+ ",cert,birthday,user_type,content,status,login_ip,image_path
				 */
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRule(rs.getString("rule"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getString("sex").charAt(0));//Character类型不会转换
				
				city.setCityId(rs.getString("city"));
				user.setCity(city);//引用类型不会转换
				
//				cert_type.setId(id);
//				user.setCerttype(rs.get("cert_type"));
				user.setCert(rs.getString("cert"));
				user.setBirthday(rs.getDate("birthday"));
//				user.setUsertype(rs.get("user_type"));
				user.setContent(rs.getString("content"));
//				user.setStatus(rs.get("status"));
				user.setLoginIp(rs.getString("login_ip"));
				user.setImagePath(rs.getString("image_path"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, stmt, rs);
		}
		return user;
	}
	/**
	 * 查询用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean queryUsername(String username) {
	Boolean result=false;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {

			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(QUERY_USERNAME);
			stmt.setString(1,username);
			
			rs=stmt.executeQuery();
			if(rs.next())
			{
				int tmp=rs.getInt("count");
				if(tmp>0)
				{
					result=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(conn, stmt, rs);
		}
		return result;
	}
}
