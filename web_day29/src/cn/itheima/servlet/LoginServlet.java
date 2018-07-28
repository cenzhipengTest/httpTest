package cn.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;

import cn.itheima.bean.User;
import cn.itheima.service.Service;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User u = new User(uname, pwd);
		Service service = new Service();
		
		
		User user = null;
		try {
			user = service.login(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		if (user != null) {
			PrintWriter writer = resp.getWriter();
			writer.print("登录成功...login success");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("登录失败...login 失败");
		}
		
		
	}

}
