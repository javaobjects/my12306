package net.ptcs.my12306.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.ptcs.my12306.entity.Province;
import net.ptcs.my12306.util.DBUtils_pool;

public class ProvinceDao {

	private static final String QUERY_ALL_PROVINCE = "select id,provinceid,province from my12306_tab_province";
	/**
     * 查询所有省份的方法
	 * @return
	 */
	public List<Province> queryAllProvince(){
		List<Province> provinces = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils_pool.getConnection();
			stmt = conn.prepareStatement(QUERY_ALL_PROVINCE);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Province p = new Province();
				p.setId(rs.getInt("id"));
				p.setProvinceId(rs.getString("provinceid"));
				p.setProvinceName(rs.getString("province"));
				
				provinces.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils_pool.release(conn, stmt, rs);
		}
		
		return provinces;
	}
	
//	 单例模式实现步骤：
//	 1.构造器私有
//	 2.提供私有的静态的当前类类型的变量
//	 3.提供一个公共的静态方法，返回刚才定义的变量，如果这个变量为null，那么给他赋值
	
	private ProvinceDao() {};
	private static ProvinceDao provinceDao;
	public static ProvinceDao getInstance() {
		if(provinceDao == null) {
			provinceDao = new ProvinceDao();
		}
		return provinceDao;
	}
}
