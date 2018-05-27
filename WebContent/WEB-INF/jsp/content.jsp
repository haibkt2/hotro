<%@page import="model.*"%>
<%@page import="service.*"%>
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
		<%
			List<content> listCon = (ArrayList) request.getAttribute("listCon");
		%>
		<div id="body" class="width">
			<section id="content"> <article> <br>


			<div id="line">
				<div class="dline"></div>
				<div class="dline"></div>
			</div>
			
			
			
			<article> <section> <br><form action="${pageContext.request.contextPath}/Search" method="POST">
                                <input type="text" name="ten" id="searchaccout" placeholder="Search for name content">
                                <input type="submit" value="Search" class="login" />        
                            </form>
			<p style="text-align: center;font-size: 25px;color: red">Danh sách bài đăng</p>
			<a href="${pageContext.request.contextPath}/Home"><p style="text-align: right;font-size: 18px;">Xem thông báo</p></a>
			
			<% if(listCon.size()== 0) {%>
			<p >Danh sách trống</p>
			<%}%>
			<table id="bootstrap-table"
				class="table table-bordered table-striped" border="1">
				<thead>
					<tr>
						<th style="display: none;"></th>
					</tr>
				</thead>

				
				<tbody>
				<%
					for (content content : listCon) {
				%>
					<tr>
						<td><h2><%=content.getTen()%></h2></td>
					</tr>
					<tr>
						<td><div class="article-info">
								Tác giả :<%=content.getAuthor()%></div> <br>
							<p><%=content.getSummary()%></p> <a
							href="${pageContext.request.contextPath}/ViewContent?idtin=<%=content.getIdtin() %>"
							style="text-decoration: none; float: right;">Read more</a></td>
					</tr>
					<%
					}
				%>
				</tbody>
				
			</table>
			<script>
					function Functionsearchaccout() {
						var searchacc, filter, tableacc, tr, td, i;
						searchacc = document.getElementById("searchaccout");
						filter = searchacc.value.toUpperCase();
						tableacc = document.getElementById("bootstrap-table");
						tr = tableacc.getElementsByTagName("tr");
						for (i = 0; i < tr.length; i++) {
							td = tr[i].getElementsByTagName("td")[0];
							if (td) {
								if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
									tr[i].style.display = "";
								} else {
									tr[i].style.display = "none";
								}
							}
						}
					}
				</script> </section></article> </article> </section>
			<jsp:include page="rightpage.jsp"></jsp:include>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>

	<script src="js/jquery.bdt.min.js"
		type="text/javascript"></script>
</body>
</html>
