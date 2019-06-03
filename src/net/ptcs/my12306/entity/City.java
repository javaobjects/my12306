package net.ptcs.my12306.entity;
/**
 * 城市类
 * @author hp
 *
 */
public class City {
	
	//id  cityid  city  father
	private Integer id;
	private String cityId;//cityid
	/** 城市名称 ，对应数据库city字段*/
	private String cityName;//city
	private Province province;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public City(Integer id, String cityId, String cityName, Province province) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.cityName = cityName;
		this.province = province;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", cityId=" + cityId + ", cityName="
				+ cityName + ", province=" + province + "]";
	}
	
	

}
