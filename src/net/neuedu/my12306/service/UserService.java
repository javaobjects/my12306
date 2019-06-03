package net.neuedu.my12306.service;

import net.ptcs.my12306.dao.UsersDao;
import net.ptcs.my12306.entity.Users;

public class UserService {
	
	/**
	 * 属性依赖UserDao
	 */
	private UsersDao userDao=UsersDao.getInstance();
	
	/**
	 * 注册方法
	 */
	public boolean register(Users user)
	{
		return userDao.addUser(user)>0;
	}
	
	private UserService()
	{
		
	}
	
	public static UserService userService;
	
	public static UserService getInstance()
	{
		if(userService==null)
		{
			userService=new UserService();
		}
		return userService;
	}
	/**
	 *  登陆方法
	 * @param username
	 * @param password
	 * @return
	 */
	public Users login(String username, String password) {
		return userDao.queryUserByUsernameAndPassword(username,password);
	}

	public boolean isExistsUserName(String username) {
		return userDao.queryUsername(username);
	}

}
