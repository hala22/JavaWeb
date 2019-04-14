package javaWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServlerDemo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/jpeg");
		ServletOutputStream sos=resp.getOutputStream();
		
		File file=new File("/Users/air/eclipse-workspace/javaWeb/WebContent/timg-6.jpg");
		FileInputStream fis=new FileInputStream(file);
		byte[] b=new byte[1024*1024];
		int a=-1;
		while((a=fis.read(b))!=-1) {
			sos.write(b,0,a);
		}
		
		fis.close();
		sos.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
