package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz10")
public class PostMethodQuiz10 extends HttpServlet{
	private final Map<String, String> userMap =  new HashMap<String, String>() {
	    {
	        put("id", "marobiana");
	        put("password", "qwerty1234");
	        put("name", "신보람");
	    }
	};
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// HTML
		resp.setContentType("text/html");
		
		// request params
		String userId = req.getParameter("userid");
		String password = req.getParameter("password");
		
		// id/pw 검사 및 출력
		PrintWriter out = resp.getWriter();
		
		if(!userId.equals(userMap.get("id"))) {
			out.print("아이디가 일치하지 않습니다.");
		} else if(!password.equals(userMap.get("password"))) {
			out.print("비밀번호가 일치하지 않습니다.");
		} else {
			out.print(userMap.get("name") + "님 환영합니다!");
		}
		
	}
}
