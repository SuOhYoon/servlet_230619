package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/delete")
public class DeleteurlServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 응답 생략(302)
		
		// request parameter
		int id = Integer.parseInt(req.getParameter("id"));
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// 삭제 Query
		String deleteQuery = "delete from `star` where `id` = " + id;
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 연결 해제
		ms.disconnect();
		
		// redirect -> 유저 목록 화면
		resp.sendRedirect("/lesson04/quiz02/list.jsp");
	}
}