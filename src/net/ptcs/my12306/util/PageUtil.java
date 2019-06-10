package net.ptcs.my12306.util;

import java.util.ArrayList;
import java.util.List;

import net.ptcs.my12306.entity.Users;

/**
 * 分页工具类
 * @author xianxian
 *
 */
public class PageUtil {
	//需要传给我的数据
		/** 要分页的对象 */
		private List<Users> users;
		/** 每页显示几条数据 */
		private Integer pageCount;
		/** 你要获取第几页的数据  */
		private Integer pageNumber;
		
		//工具类通过一定的算法加工处理后得到的数据
		/** 一共有多少页  */
		private Integer pagesum;
		/** 对应页码的数据*/
		private List<Users> users_page;
		
		
		public PageUtil(List<Users> users,Integer pageCount,Integer pageNumber)
		{
			this.users=users;
			this.pageCount=pageCount;
			this.pageNumber=pageNumber;
			
			//马上算出总页数
			if(users.size()==0)
			{
				this.pagesum=0;
			}else if(users.size()%pageCount==0)
			{
				this.pagesum=users.size()/pageCount;
			}else
			{
				this.pagesum=users.size()/pageCount+1;
			}
			
		}
		//返回页码的方法
		public Integer getPageNumber()
		{
			return this.pageNumber;
		}
		
		//返回总页数的方法
		public Integer getPagesum()
		{
			return pagesum;
		}
		
		//返回对应页码的查询结果集
		public List<Users> getUsers_page()
		{
			users_page=new ArrayList<>();
			/* 如果总页数是7页，那么用户查询1-6页数据都很正常
			 * 1.用户的查询结果集本来就没有数据
			 * 2.用户查的是第一页至第六页数据
			 * 3.用户查的是最后一页第七页数据
			 */
			if(users.size()==0)
			{
				return users_page;//也没有数据
			}else if(pageNumber<pagesum)//用户查的是第一页至第六页数据
			{
				users_page=users.subList((pageNumber-1)*pageCount, pageNumber*pageCount);//1:0-10  2:10-20
			}else if(pageNumber==pagesum)
			{
				users_page=users.subList((pageNumber-1)*pageCount,users.size());//3: 20-21
			}
			
			return users_page;
		}
}
