package javaWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		Cookie[] cs=req.getCookies();
		
		//从cookie中获取信息
		if(cs!=null) {
			for (Cookie cookie : cs) {
				String name=URLDecoder.decode(cookie.getName(),"utf-8");
				String value=cookie.getValue();
				pw.write("<h3>"+name+" &nbsp;x"+value+"</h3>");//打印
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

}
