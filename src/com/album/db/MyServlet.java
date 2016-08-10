package com.album.db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=gbk");
		res.setCharacterEncoding("gbk");
		try{
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body><center>");
		pw.println("<a href=hu1>管理界面</a><br/>");
		pw.println("<a href=hu1>查找用户</a><br/>");
		pw.println("<a href=hu1>添加用户</a><br/>");
		pw.println("<a href=hu1>安全退出</a><br/>");
		pw.println("</center></body>");
		pw.println("</html>");

		}

		catch(Exception e){
		e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
