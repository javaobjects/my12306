package net.ptcs.my12306.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.ptcs.my12306.entity.City;
import net.ptcs.my12306.entity.Province;
import net.ptcs.my12306.util.DBUtils;

public class CityDao {
	
	private static final String QUERY_CITY_BY_PROVINCEID = "select id,cityid,city from tab_city where father=?";
	/**
	 * 获取指定省份的所有城市信息
	 * @param provinceId
	 * @return
	 */
	public List<City> queryCityByProvinceid(String provinceId){
		List<City> cities = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(QUERY_CITY_BY_PROVINCEID);
			stmt.setString(1,provinceId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				City c=new City();
				
				c.setCityId(rs.getString("cityid"));
				c.setId(rs.getInt("id"));
				c.setCityName(rs.getString("city"));
				
				cities.add(c);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.release(conn, stmt, rs);
		}
		return cities;
	}

//	 单例模式实现步骤：
//	 1.构造器私有
//	 2.提供私有的静态的当前类类型的变量
//	 3.提供一个公共的静态方法，返回刚才定义的变量，如果这个变量为null，那么给他赋值
	private CityDao() {};
	private static CityDao cityDao;
	public static CityDao getInstance() {
		if(cityDao == null) {
			cityDao = new CityDao();
		}
		return cityDao;
	}
}
