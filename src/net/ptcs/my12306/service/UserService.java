package net.ptcs.my12306.service;

import java.util.List;

import net.ptcs.my12306.dao.UsersDao;
import net.ptcs.my12306.entity.Users;

public class UserService {
	
	/**
	 * 
	 * @param id
	 * @param password_old
	 * @param password_new
	 * @return
	 */
	public boolean updatePassword(Integer id,String password_old,String password_new)
	{
		boolean tmp=false;//默认更新失败
		if(userDao.find(id,password_old))
		{
			userDao.updatePassword(id,password_new);
			tmp=true;
		}
		return tmp;
	}
	
	/**
	 * 更新用户信息的方法
	 * @param user
	 * @return
	 */
	public boolean updateUser(Users user)
	{
		return userDao.updateUser(user)>0;
	}
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
	
	/**
	 * 判断用户名是否已经存在
	 */
	public boolean isExistsUserName(String username)
	{
		return userDao.queryUsername(username);
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

	public List<Users> getUserByCondition(String username, int certtype, String cert, int usertype, char sex) {

		return userDao.queryUserByCondition(username,certtype,cert,usertype,sex);
	}

	public void saveImage(Integer id, String fileName) {
		userDao.insertImage(id,fileName);
	}
}
