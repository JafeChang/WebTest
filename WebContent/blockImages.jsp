<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Images of blocks with JavaBean</title>
</head>
	<%@ page import="info.jafe.ChartGraphics" %>
	<%@ page import="java.io.File"%>
	<jsp:useBean id="cg" class="info.jafe.ChartGraphics"></jsp:useBean>
	<jsp:useBean id="gd" class="info.jafe.ChartGraphics"></jsp:useBean>
	<%!
		int height[]=new int[5];
	%>
	<%
		height=cg.getHeightArray();
		File file=new File("chart.jpg");
		cg.graphicsGeneration(height[0],height[1],height[2],height[3],height[4],file);
	%>
<body>
<img src="chart.jpg"></img>

</body>
</html>