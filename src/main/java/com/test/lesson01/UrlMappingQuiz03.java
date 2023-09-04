package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz03")
public class UrlMappingQuiz03 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
	
		// 날짜 설정
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:ss:mm");
		
		// html 출력
		out.print("<html><head><title>마론달 뉴스</title></head><body>");
		out.print("<h1>[단독] 고양이가 야옹해" + "</h1><br>");
		out.print("기사 입력 시간: " + sdf.format(now) + "<hr>");
		out.print("끝</body></html>");
	}
}
