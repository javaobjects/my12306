package net.ptcs.my12306.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.ptcs.my12306.entity.CertType;
import net.ptcs.my12306.entity.City;
import net.ptcs.my12306.entity.Province;
import net.ptcs.my12306.entity.UserType;
import net.ptcs.my12306.entity.Users;
import net.ptcs.my12306.util.DBUtils_pool;

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

	private static final String QUERY_USERNAME = "select count(1) count from tab_user where username=?";

	private static final String QUERY_USER_BY_USERNAME_AND_PASSWORD = "select u.id,u.username,u.password,u.rule,"
			+ "u.realname,u.sex,u.city c_id,u.cert_type"
			+ ",u.cert,u.birthday,u.user_type,u.content,u.status,u.login_ip,u.image_path,"
			+ "c.city,p.province,p.provinceid,ut.content ut_content,ct.content ct_content "
			+ "from tab_user u,tab_city c,tab_province p,tab_usertype ut,tab_certtype ct"
			+ " where u.city=c.id and p.provinceid=c.father "
			+ "and ut.id=u.user_type and ct.id=u.cert_type "
			+ "and u.username=? and u.password=?";
	
	public int addUser(Users user) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DBUtils_pool.getConnection();
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
			DBUtils_pool.release(conn, stmt, null);
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

			conn = DBUtils_pool.getConnection();
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
			DBUtils_pool.release(conn, stmt, rs);
		}

		return result;
	}

	/**
	 * 根据用户名和密码查询用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public Users queryUserByUsernameAndPassword(String username, String password) {
		Users user=null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {

			conn = DBUtils_pool.getConnection();
			stmt = conn.prepareStatement(QUERY_USER_BY_USERNAME_AND_PASSWORD);
			stmt.setString(1,username);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				user=new Users();
				/*
				 * id,username,password,rule,realname,sex,city,cert_type"
			+ ",cert,birthday,user_type,content,status,login_ip,image_path
				 */
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRule(rs.getString("rule"));
				user.setRealname(rs.getString("realname"));
				//补全另外10个数据
				user.setId(rs.getInt("id"));
				user.setRule(rs.getString("rule"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setCity(new City(rs.getInt("c_id"),null, rs.getString("city"), new Province(null, rs.getString("provinceid"), rs.getString("province"))));
				user.setCerttype(new CertType(rs.getInt("cert_type"), rs.getString("ct_content")));
				user.setCert(rs.getString("cert"));
				user.setBirthday(rs.getDate("birthday"));
				user.setUsertype(new UserType(rs.getInt("user_type"),rs.getString("ut_content")));
				user.setContent(rs.getString("content"));
				user.setStatus(rs.getString("status").charAt(0));
				user.setLoginIp(rs.getString("login_ip"));
				user.setImagePath(rs.getString("image_path"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_pool.release(conn, stmt, rs);
		}
		return user;
	}
	public int updateUser(Users user) {
		int rows=0;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			//这些待更新的数据：真实姓名 性 别   城市 证件类型 证件号码 出生日期 旅客类型 备注
			String update_user_sql="update tab_user set realname=?,sex=?,city=?,cert_type=?,cert=?,"
					+ "birthday=?,user_type=?,content=? where id=?";
			conn=DBUtils_pool.getConnection();
			stmt=conn.prepareStatement(update_user_sql);
			stmt.setString(1, user.getRealname());
			stmt.setString(2, user.getSex() + "");
			stmt.setInt(3, user.getCity().getId());
			stmt.setInt(4,user.getCerttype().getId());
			stmt.setString(5,user.getCert());
			stmt.setDate(6, new java.sql.Date(user.getBirthday().getTime()));
			stmt.setInt(7,user.getUsertype().getId());
			stmt.setString(8,user.getContent());
			stmt.setInt(9, user.getId());
			
			rows=stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils_pool.release(conn, stmt, null);
		}
		return rows;
	}
	/**
	 * 根据id和旧的密码查询数据库，看能否找到用户，找到则旧密码输入正确
	 * @param id
	 * @param password_old
	 * @return
	 */
	public boolean find(Integer id, String password_old) {
		Boolean result=false;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {

			conn = DBUtils_pool.getConnection();
			stmt = conn.prepareStatement("select * from tab_user where id=? and password=?");
			stmt.setInt(1,id);
			stmt.setString(2, password_old);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_pool.release(conn, stmt, rs);
		}

		return result;
	}
	
	public void updatePassword(Integer id, String password_new) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			//这些待更新的数据：真实姓名 性 别   城市 证件类型 证件号码 出生日期 旅客类型 备注
			String update_user_sql="update tab_user set password=? where id=?";
			conn=DBUtils_pool.getConnection();
			stmt=conn.prepareStatement(update_user_sql);
			stmt.setString(1,password_new);
			stmt.setInt(2,id);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils_pool.release(conn, stmt, null);
		}
	}

	/**
	 * 根据给定条件查询用户信息：组合查询
	 * @param username
	 * @param certtype
	 * @param cert
	 * @param usertype
	 * @param sex
	 * @return
	 */
	public List<Users> queryUserByCondition(String username, int certtype,
			String cert, int usertype, char sex) {
		List<Users> users=new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		try {

			conn = DBUtils_pool.getConnection();
			
			StringBuffer query_user=new StringBuffer("select u.id,u.username,u.sex,u.cert,"
					+ "ct.id ct_id,ct.content ct_content,"
					+ "ut.id ut_id,ut.content ut_content "
					+ "from tab_user u,tab_usertype ut,tab_certtype ct "
					+ "where ut.id=u.user_type and ct.id=u.cert_type and sex='"+sex+
					"' and cert_type="+certtype+" and user_type="+usertype);
			if(username!=null&& !"".equals(username.trim()))
			{
				query_user.append(" and username like '%"+username.trim()+"%'");
			}
			if(cert!=null && !"".equals(cert.trim()))
			{
				query_user.append(" and cert='"+cert+"'");
			}
			
			stmt = conn.prepareStatement(query_user.toString());
			
			
			rs=stmt.executeQuery();
			Users user=null;
			while(rs.next())
			{
				user=new Users();
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setCerttype(new CertType(rs.getInt("ct_id"), rs.getString("ct_content")));
				user.setCert(rs.getString("cert"));
				user.setUsertype(new UserType(rs.getInt("ut_id"),rs.getString("ut_content")));
				
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils_pool.release(conn, stmt, rs);
		}

		return users;
	}
	
}
