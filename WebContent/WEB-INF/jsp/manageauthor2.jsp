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
	<div id="container">
            <jsp:include page="header.jsp"></jsp:include>
                <div id="body" class="width">
                    <br /><br /><center><jsp:include page="searchauthor.jsp"></jsp:include></center>

                <%ArrayList<content> ds = new pageauthor().getDanhSach();
                    ArrayList<content> dsLoc = (ArrayList<content>) session.getAttribute("dsLoc");
                    if (session.getAttribute("dsLoc") != null) {
                        ds = dsLoc;
                    }
                %>
                <table border="1">
                    <tr>
                        <th style="width:5%;">STT</th>
                        <th style="width:30%;">Name Content </th>
                        <th style="width:40%;">Summary </th>
                        <th style="width:25%;">Author</th>
                    </tr>
                    <%
                        for (int i = 0; i < ds.size(); i++) {
                    %>
                    <tr>
                        <td><%=i + 1%></td>
                        <td><%=ds.get(i).getTen()%></td>
                        <td><%=ds.get(i).getSummary()%></td>
                        <td><%=ds.get(i).getAuthor()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <div class="clear"></div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>		
</body>
</html>
