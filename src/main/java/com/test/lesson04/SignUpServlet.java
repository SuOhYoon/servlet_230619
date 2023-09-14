package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/sign-up")
public class SignUpServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 응답 정의 생략(302)
		
		// request parameters
		String name = req.getParameter("name");
		String yyyymmdd = req.getParameter("yyyymmdd");
		String email = req.getParameter("email");
		String introduce = req.getParameter("introduce");
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// DB insert
		String insertQurey = "insert into `new_user` (`name`, `yyyymmdd`, `email`, `introduce`)"
				+ "values('" + name + "','" + yyyymmdd + "', '" + email + "', '" + introduce + "')";
		
		try {
			ms.update(insertQurey);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DB 연결 해제
		ms.disconnect();
		
		// 리다이렉트(Redirect) -> 유저목록 화면 이동
		resp.sendRedirect("/lesson04/ex02/userList.jsp");
	}
}
