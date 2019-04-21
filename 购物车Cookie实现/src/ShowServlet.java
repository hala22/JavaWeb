package javaWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		HashMap<String,String> map=new HashMap<>();
		map.put("1", "苹果");
		map.put("2", "毛绒玩具");
		map.put("3", "兰博基尼");
		map.put("4", "球衣");
		PrintWriter pw=resp.getWriter();
		pw.write("<ul>");
		for (Entry<String,String> entry: map.entrySet()) {
			String key=entry.getKey();
			String value=entry.getValue();
			pw.write("<li><a href='doAdd?id="+key+"&name="+value+"'>"+value+"</a></li>");
		}
		pw.write("</ul>");
		
		pw.write("<a href='doCart'>查看购物车</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

}
