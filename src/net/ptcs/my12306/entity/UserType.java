package net.ptcs.my12306.entity;
/**
 * 用户类型实体类
 * @author hp
 *
 */
public class UserType {
	private Integer id;
	private String content;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserType(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserType [id=" + id + ", content=" + content + "]";
	}
	
}
