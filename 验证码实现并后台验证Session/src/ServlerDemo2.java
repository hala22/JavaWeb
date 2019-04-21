package javaWeb;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServlerDemo2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String validateCode=req.getParameter("validateCode");
		
		HttpSession hs=req.getSession();
		Object code=hs.getAttribute("code");
		
		if("hala".equals(name)&&"123".equals(pwd)&&code.equals(validateCode)) {
			System.out.println("登录成功");
			resp.getWriter().write("<h3>登录成功</h3>");
		}else {
			System.out.println("登录失败");
			resp.getWriter().write("<h3>登录失败</h3>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
