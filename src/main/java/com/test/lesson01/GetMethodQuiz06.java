package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz06")
public class GetMethodQuiz06 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 한글 처리
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json");
		
		PrintWriter out = resp.getWriter();
		int num1 = Integer.parseInt(req.getParameter("number1"));
		int num2 = Integer.parseInt(req.getParameter("number2"));
		
		int add = num1 + num2;
		int sub = num1 - num2;
		int multiple = num1 * num2;
		double div = num1 / num2;
		
		out.print("{\"addition\":" + add + 
				",\"substraction\":" + sub + 
				",\"multiplication\":" + multiple + 
				",\"division\":" + div + "}");
	}
}
