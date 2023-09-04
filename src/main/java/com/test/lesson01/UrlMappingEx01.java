package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	
public class UrlMappingEx01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 한글깨짐 방지
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		out.println("안녕하세요");
		
		// 날짜
		Date now = new Date();
		
		// formatter
		// 2023-08-29 오후 19:43:44
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		out.println(sdf.format(now));
	}
}
