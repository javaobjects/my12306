package net.neuedu.my12306.entity;

/**
 * 证件类型
 * @author hp
 *
 */
public class CertType {
	
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
	public CertType(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public CertType() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CertType [id=" + id + ", content=" + content + "]";
	}
	
	

}
