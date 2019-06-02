package net.neuedu.my12306.entity;

/**
 * 省份实体类
 * @author hp
 *
 */
public class Province {
	/** id */
	private Integer id;
	/** 省份id 字符串类型*/
	private String provinceId;
	/** 省份名称 对应数据库的province字段*/
	private String provinceName;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(Integer id, String provinceId, String provinceName) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceId=" + provinceId
				+ ", provinceName=" + provinceName + "]";
	}
	
	

}
