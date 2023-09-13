package com.test.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/quiz01")
public class quiz01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 응답 plain
		resp.setContentType("text/plain");
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect(); //★★★★ 실질적인 DB 연결 (꼭 넣어야 함)
		
		// DB Insert 쿼리 수행
		String insertQuery = "insert into	`real_estate`"
				+ "(`realtorId`, `address`, `area`, `type`, `price`, `rentPrice`)"
				+ "values(3, '헤라펠리스 101동 5305호', 350, '매매', 1500000, null);";
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 셀렉트 쿼리 수행 & 출력
		PrintWriter out = resp.getWriter();
		String query = "select * from `real_estate` order by id desc limit 10";
		
		try {
			ResultSet res = ms.select(query);
			while(res.next()) { // 결과 행이 있는 동안 계속 수행
				out.println(res.getString("address"));
				out.println(res.getInt("area"));
				out.println(res.getString("type"));
				out.println(res.getInt("price"));
				out.println(res.getInt("rentPrice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 연결 해제
		ms.disconnect();
	}
}
