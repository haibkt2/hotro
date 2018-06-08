<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.content"%>
<%@page import="service.pageauthor"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>VNPT SUPPORT</title>
<link
	href="${pageContext.request.contextPath}/js/table/css/vendor/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/table/css/vendor/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/table/css/jquery.bdt.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/table/css/style.css"
	type="text/css" rel="stylesheet">

</head>
<body>
<form action="Searchauthor" method="post">
            <input type="text" list="dsAuthor" name="Author"placeholder="Chọn tác giả"  />
            <button type="submit" class="login">Choose Author</button>
        </form>
        <br />
        <%
            Set<String> dsAuthor = new pageauthor().getDanhSachTheoAuthor();
        %>
        <datalist id="dsAuthor">
            <%
                for (String a : dsAuthor) {
            %>
            <option value="<%=a%>"><%=a%></option>
            <%
                }
            %>
        </datalist>		
</body>
</html>
