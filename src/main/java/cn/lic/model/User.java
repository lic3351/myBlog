package cn.lic.model;

public class User {

	private int id;
	private String name;
	private String address;
	private String sign;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	public User(int id, String name, String address, String sign) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sign = sign;
	}
	public User() {
		super();
	}
	
}
