package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz09")
public class PostMethodQuiz09 extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// HTML
		resp.setContentType("text/html");
		
		// request params
		String name = req.getParameter("name");
		String introduce = req.getParameter("introduce");
		
		// 테이블로 출력
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title></title></head><body>");
		out.print("<b>" + name + "</b>님 지원이 완료되었습니다.<br>");
		out.print("<h3>지원 내용</h3>	");
		out.print(introduce);
		out.print("</body></html>");
	}
}
