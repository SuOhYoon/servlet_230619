package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/ex03")
public class GetMethodEx03 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 한글 깨짐 방지 -> plain
//		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("text/plain");
		
		// 한글 깨짐 방지 -> json string
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json");
		
		// Request Parameter
		String userId = req.getParameter("user_id");
		String name = req.getParameter("name");
		int age = Integer.valueOf(req.getParameter("age"));
		
		// 출력
		PrintWriter out = resp.getWriter();
//		out.println("user_id:" + userId);
//		out.println("name:" + name);
//		out.println("age:" + age);
		
		// JSON으로 출력
		// {"user_id":"dbstndh12", "name":"윤수오", "age":24}
		out.print("{\"user_id\":\"" + userId +"\", \"name\":\""
				+ name + "\",\"age\":" + age + "}");
		
	}
}
