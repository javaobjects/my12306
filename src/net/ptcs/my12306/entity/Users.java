package net.ptcs.my12306.entity;

import java.util.Date;

/**
 * 用户实体类
 * @author hp
 */
public class Users {

	private Integer id;
	private String username;
	private String password;
	private String rule;// 1、管理员 2、普通用户
	private String realname;
	private Character sex;//性别(1、男 2、女)
	private City city;
	private CertType certtype;//证件类型1、二代身份证 2、港澳通行证 3、台湾通行证 4、护照
	private String cert;//证件号码
	private Date birthday;
	private UserType usertype;
	private String content;
	private Character status;//用户状态（0、无效  1、有效 ）
	private String loginIp;
	private String imagePath;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public CertType getCerttype() {
		return certtype;
	}
	public void setCerttype(CertType certtype) {
		this.certtype = certtype;
	}
	public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public UserType getUsertype() {
		return usertype;
	}
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Users() {
		super();
	}
	public Users(Integer id, String username, String password, String rule,
			String realname, Character sex, City city, CertType certtype,
			String cert, Date birthday, UserType usertype, String content,
			Character status, String loginIp, String imagePath) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rule = rule;
		this.realname = realname;
		this.sex = sex;
		this.city = city;
		this.certtype = certtype;
		this.cert = cert;
		this.birthday = birthday;
		this.usertype = usertype;
		this.content = content;
		this.status = status;
		this.loginIp = loginIp;
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + ", rule=" + rule + ", realname=" + realname
				+ ", sex=" + sex + ", city=" + city + ", certtype=" + certtype
				+ ", cert=" + cert + ", birthday=" + birthday + ", usertype="
				+ usertype + ", content=" + content + ", status=" + status
				+ ", loginIp=" + loginIp + ", imagePath=" + imagePath + "]\n";
	}
	public Users(String username, String password, Character sex, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
	}
}
