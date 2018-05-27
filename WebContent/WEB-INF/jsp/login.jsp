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
		<section id="content"> <article> <%
 	String username = (String) session.getAttribute("username");

 	//redirect user to accout page if already logged in
 	if (username != null) {
 		response.sendRedirect("accout.jsp");
 	}

 	String status = request.getParameter("status");

 	if (status != null) {
 		if (status.equals("false")) {
 			out.print("<br /><h2>Incorrect Account!</h2>");
 		} else {
 			out.print("Some error occurred!");
 		}
 	}
 %>
		<form action="${pageContext.request.contextPath}/Login" method="post">
			<div style="height: 400px; font-size: 13pt;">
				<h2 style="text-align: center;" id="e">${thongbao }</h2>
				<table align="center" style="color: Black;">
				
					<tr>
						<td>Tên đăng nhập</td>
						<td><input type="text" name="username"
							placeholder="Tên đăng nhập" value="${cookie.id.value}" required /></td>
					</tr>
					<tr>
						<td>Mật khẩu</td>
						<td><input type="password" name="password"
							placeholder="Mật khẩu" value="${cookie.pw.value}" required /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2" align="left"><input type="submit"
							class="login" value="Đăng nhập" />
							<br>
							<p style="margin: 15px 0px 0px 0px ; color: red"><i>${messLg}</i></p>
							</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="checkbox" name="ghi" checked="checked">
							Ghi Nhớ</td>
					</tr>
				</table>
			</div>
		</form>
		</article> </section>
		<div class="clear"></div>
	</div>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>
	<script src="${pageContext.request.contextPath}/js/"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.bdt.min.js"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('#bootstrap-table').bdt({
				showSearchForm : 0,
				showEntriesPerPageField : 0
			});
		});
	</script>
</body>
</html>
