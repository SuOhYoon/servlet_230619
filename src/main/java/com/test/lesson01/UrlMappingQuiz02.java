package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingQuiz02 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 한글깨짐 방지
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		// 날짜
		Date now = new Date();
		
		// formatter
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초입니다.");
		out.println("현재 시간은 " + sdf.format(now));
	}
}
