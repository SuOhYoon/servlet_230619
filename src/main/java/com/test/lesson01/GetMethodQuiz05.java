package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz05")
public class GetMethodQuiz05 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 한글 처리
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		int num = Integer.parseInt(req.getParameter("number"));
		
		out.print("<html><head><title>결과</title></head><body>");
		out.print("<ul>");
		for(int i=1;i<=9;i++) {
			int result = num*i;
			out.print("<li>");
			out.printf("%d x %d = %d", num, i, result);
			out.print("</li>");
		}
		out.print("</ul>");
		out.print("</body></html>");
	}
}
