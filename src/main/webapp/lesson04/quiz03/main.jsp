<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.common.MysqlService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홍당무 마켓</title>
<!-- bootstrap CDN -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<style>
</style>
</head>
<%
	// DB 연결
	MysqlService ms = MysqlService.getInstance();
	ms.connect();
	
	// DB select
	String query = "select A.nickname, A.id, B.sellerId, B.image, B.title, B.price from seller as A join used_goods as B on A.id = B.sellerId order by A.id desc";
	ResultSet res = ms.select(query);
%>
<body>
	<div id="wrap" class="container">
		<header class="bg-danger">
			<div class="align-items-center">
				<h1 class="text-center text-white">HONG당무 마켓</h1>
			</div>
		</header>
		<nav class="d-flex align-items-center bg-danger mt--2">
			<ul class="nav justify-content-start nav-fill w-100">
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">리스트</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">물건 올리기</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">마이 페이지</a></li>
			</ul>
		</nav>
		<section>
			<div id="list" class="mt-3">
				<% while(res.next()){%>
					<div id="product" class="col-4 border border-5"></div>
						<img class="mt-3" src="<%=res.getString("image") %>" width="338" height="200">
						<div><%=res.getString("title") %></div>
						<div><%=res.getInt("price") %><div>
						<div><%=res.getString("nickname") %><div>
					</div>
				<% }%>
<%
	ms.disconnect();
%>
			</div>
		</section>
		<footer></footer>
	</div>
</body>
</html>