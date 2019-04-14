package javaWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import entity.User;

public class ServlerDemo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IUserDao ud=new UserDaoImpl();
		User user=new User("落落","123");
		//添加
		System.out.println(ud.insert(user));
		//查询
		//System.out.println(ud.queryByUser(user));
		//查询所有
//		List<User> list=ud.queryAll();
//		for (User user2 : list) {
//			System.out.println(user2);
//		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
