package cn.itheima.dao;

import java.util.List;

import cn.itheima.domain.User;

public interface UserDao {
	
	List<User> findAll();

}
