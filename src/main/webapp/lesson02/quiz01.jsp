<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz01</title>
</head>
<body>
	<%!			
		// method
		public int getSum(int n){
			int sum = 0;
			for(int i=1;i<=n;i++){
				sum += i;
			}
			return sum;
		}
	%>
    <%
		int[] scores = {80, 90, 100, 95, 80};
		int sum = 0;
		
		for(int i=0;i<scores.length;i++){
			sum += scores[i];
		}
		
		double avg = sum / (double)scores.length;
	%>
	<%
		// 3
		List<String> scoreList = Arrays.asList(new String[]{"X", "O", "O", "O", "X", "O", "O", "O", "X", "O"});
		int score = 0;
		for(int i=0;i<scoreList.size();i++){
			if(scoreList.get(i).equals("O")){
				score += 100 / scoreList.size();
			}
		}
		
		// 4
		String birthDay = "20010820"; // 2001 0~3
		String year = birthDay.substring(0, 4);
		// out.print(year);
		int age = 2023 - Integer.parseInt(year);
	%>
	<h2>1부터 50까지의 합은 <%= getSum(50) %> 입니다.</h2>
	<h2>평균 점수는 <%= avg %> 입니다.</h2>
	<h2>채점 결과는 <%= score %> 점입니다.</h2>
	<h2><%= birthDay %>의 나이는 <%= age %>세입니다.</h2>
</body>
</html>