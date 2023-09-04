package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz07")
public class GetMethodQuiz07 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 한글 깨짐 방지 -> HTML
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		// Request parameter
		String address = req.getParameter("address");
		String card = req.getParameter("card");
		int price = Integer.parseInt(req.getParameter("bill"));
		
		// 출력
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title></title></head><body>");
		if(!address.contains("서울시")) {
			out.print("배달 불가 지역입니다.");
		}
		else if(card.equals("신한카드")) {
			out.print("결제 불가 카드입니다.");
		}
		else{
			out.print(address + "<b> 배달 준비중</b><br>");
			out.print("결제금액:"+price);
		}		
		
		out.print("</body></html>");
	}
}
