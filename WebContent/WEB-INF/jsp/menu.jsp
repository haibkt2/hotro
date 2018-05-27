<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<section id="content"> <article> <br><form action="${pageContext.request.contextPath}/Search" method="GET">
                                <input type="text" name="ten" id="searchaccout" placeholder="Search for name content">
                                <input type="submit" value="Search" class="login" />        
                            </form>
			<section>
			<div id="line">
				<div class="dline"></div>
				<div class="dline"></div>
			</div>
			<article>
			<table id="bootstrap-table"
				class="table table-bordered table-striped">
				<thead>
					<tr>
						<th style="display: none;"></th>
					</tr>
				</thead>
				<%
					 List<content> listCon = (ArrayList) request.getAttribute("listContM");
				%>
				<%
					if (listCon.size()!=0) {
						for (content content : listCon) {
				%>
				<tbody>
					<tr>
						<td><h2><%=content.getTen()%></h2></td>

					</tr>
					<tr>

						<td><div class="article-info">
								Tác giả :<%=content.getAuthor()%></div> <br>
							<p><%=content.getSummary()%></p> <a href="${pageContext.request.contextPath}/ViewContent?idtin=<%=content.getIdtin() %>"
							style="text-decoration: none; float: right;">Read more</a></td>

					</tr>

				</tbody>
				<%
					}
					} else {
				%><p>Danh sách trống</p>
				<%
					}
				%>
			</table>
			</article> </section></section>

	<jsp:include page="rightpage.jsp"></jsp:include>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>


</body>
</html>
