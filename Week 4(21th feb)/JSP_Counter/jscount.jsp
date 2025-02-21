<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
 public static int accesses = 0;
%>
<h1>JSP Example (jspCount.jsp)</h1>
<%
  accesses++;
  out.print("<p>Number of times this JSP has been accessed:" + accesses + "</p>");
%>
</body>
</html>
