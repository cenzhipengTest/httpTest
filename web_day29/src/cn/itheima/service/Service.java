package cn.itheima.service;

import java.sql.SQLException;

import cn.itheima.bean.User;
import cn.itheima.dao.Dao;

public class Service {
	private Dao d = new Dao();
	public User login(User u) throws SQLException {
		User user = d.login(u);
		return user;
		
	}

}
