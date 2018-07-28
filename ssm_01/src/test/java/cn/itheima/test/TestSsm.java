package cn.itheima.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itheima.domain.User;
import cn.itheima.service.UserService;

public class TestSsm {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = context.getBean(UserService.class);
		List<User> list = userService.findAll();
		for (User user : list) {
			System.out.println(user);
		}
		
	}

}
