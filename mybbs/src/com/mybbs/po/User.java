package com.mybbs.po;

/**
 * 用户表
 * 
 * @author leiyuan
 *
 */
public class User {

	private int id;
	private String name;
	private String email;// 使用邮箱登陆
	private String password;
	private int sex;// 0为男 1为女
	private int age;
	private String birthday;
	private int plateId;// 喜欢的板块ID
	private long time;// 禁言时间
	private int power;// 判断用户是否是管理员 默认权限-1 -1为普通用户 0为管理员用户 大于0以后代表板块ID

	public User() {

	}

	public User(int id, String name, String email, String password, int sex, int age, String birthday, int plateId,
			long time, int power) {
		// super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.plateId = plateId;
		this.time = time;
		this.power = power;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", sex=" + sex
				+ ", age=" + age + ", birthday=" + birthday + ", plateId=" + plateId + ", time=" + time + ", power="
				+ power + "]";
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
