package com.test.lesson04;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson04/quiz03/main.jsp")
public class addProduct extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		// 응답 없음
		
		// DB 처리....
	}
}
