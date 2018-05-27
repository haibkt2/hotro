<%@page import="java.util.*"%>
<%@page import="service.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VNPT SUPPORT</title>
<link href="${pageContext.request.contextPath}/vnpt.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/styles.css"
	rel="stylesheet" type="text/css" />
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
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ckfinder/ckfinder.js"></script>
<script type="text/javascript">
	function kt() {
		var mn = document.getElementById("menu").value.trim();
		var ten = document.getElementById("ten").value.trim();
		var tomtat = document.getElementById("tomtat").value.trim();
		var nd = document.getElementById("nd").value.trim();
		var author = document.getElementById("author").value.trim();
		if (mn == "" || ten == "" || summary == "" || nd == "" || author == "") {
			alert("chưa nhập đầy đủ thông tin!");
			return;
		}
		fm.submit();
	}
</script>



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#select").change(function() {
			if ($(this).val() == 1) {
				$("#select1").show();
				$("#select2").hide();
			} else if ($(this).val() == 2) {
				$("#select2").show();
				$("#select1").hide();
			} else {
				$("#select1").hide();
				$("#select2").hide();
			}
		});
	});
</script>
<style>
#select2 {
	display: none;
}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="body" class="width">
			<br>
			<h3 style="text-align: center;">Thêm thông báo</h3>
			<form action="${pageContext.request.contextPath}/AddNewNotify" method="post" id="fm" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Title</td>
						<td>
							<textarea rows="1" cols="99" name="title"></textarea>
						</td>
					</tr>

					<tr>
						<td>Content</td>
						<td>
							<textarea rows="2" cols="99" name="content"></textarea>
						</td>

					</tr>

					
					<tr>
						<td>File</td>
						<td>
						<input type="file" name="guru_file" size="50" />
						</td>
					</tr>

				</table>
				<input type="submit" value="Thêm thông báo" onclick="kt();"
					style="padding: 8px; margin-left: 400px;">
			</form>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
