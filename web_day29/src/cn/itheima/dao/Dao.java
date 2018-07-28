package cn.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itheima.bean.User;
import cn.itheima.utils.JDBCUtils;

public class Dao {

	public User login(User u) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		String sql = "select * from user where uname=? and pwd=?";
		
		User user = qr.query(sql, new BeanHandler<User>(User.class),u.getUname(),u.getPwd());
		
		return user;
	}

}
