package cn.itheima.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	// id INT(11) (NULL) NO PRI (NULL) AUTO_INCREMENT
	// SELECT,INSERT,UPDATE,REFERENCES
	// PASSWORD VARCHAR(32) utf8_general_ci NO (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES 密码
	// username VARCHAR(32) utf8_general_ci NO (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES 用户名称
	// birthday DATETIME (NULL) YES (NULL) SELECT,INSERT,UPDATE,REFERENCES 生日
	// sex CHAR(1) utf8_general_ci YES (NULL) SELECT,INSERT,UPDATE,REFERENCES 性别
	// address VARCHAR(256) utf8_general_ci YES (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES 地址

	private int id;
	private String password;
	private String username;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String sex;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + ", birthday=" + birthday
				+ ", sex=" + sex + ", address=" + address + "]";
	}

}
