package com.test.lesson01;	

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingQuiz01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 한글깨짐 방지
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		// 날짜
		Date now = new Date();
		
		// formatter
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일");
		out.println("오늘의 날짜는 " + sdf.format(now));
	}
}
