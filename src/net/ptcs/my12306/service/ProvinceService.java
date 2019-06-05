package net.ptcs.my12306.service;

import java.util.List;

import net.ptcs.my12306.dao.ProvinceDao;
import net.ptcs.my12306.entity.Province;

public class ProvinceService {

	private ProvinceDao provinceDao = ProvinceDao.getInstance();
	/**
	 * 获取所有省份的方法
	 */
	public List<Province> getAllProvince(){
		return provinceDao.queryAllProvince();
	}
	
	private ProvinceService() {};
	
	public static ProvinceService provinceService;
	
	public static ProvinceService getInstance()
	{
		if(provinceService==null)
		{
			provinceService=new ProvinceService();
		}
		return provinceService;
	}
}
