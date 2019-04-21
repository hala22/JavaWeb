package javaWeb;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		int count=1;
		
		//如果已经存在，则在原来数量上加一
		Cookie[] cs=req.getCookies();
		if(cs!=null) {
			for (Cookie cookie : cs) {
				if(URLDecoder.decode(cookie.getName(), "utf-8").equals(name)) {
					String value=cookie.getValue();
					count=Integer.parseInt(value)+1;
				}
			}
		}
		
		//这里在Cookie里边写入中文要进行编码转化
		Cookie c=new Cookie(URLEncoder.encode(name,"utf-8"),count+"");
		resp.addCookie(c);
		
		//重定向回显示界面
		resp.sendRedirect("doShow");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

}
