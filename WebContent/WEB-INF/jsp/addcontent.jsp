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
	<%ListMenu lt = new ListMenu();
								List<support> lsp = lt.listSp();
							%>
<script>
	$(document).ready(function() {
		$("#select").change(function() {
			<%int m =1; 
			for(;m<lsp.size()+1;m++) {%>
			
			if ($(this).val() == <%=m%>) {
				$("#select<%=m%>").show();
				<%
				for(int k = 1;k<lsp.size()+1;k++){
					if(k!=m){
					%>
				$("#select<%=k%>").hide();
					<%
				}}
				%>
			} 
			
			<%}%>
			
		});
	});
</script>
<style>
<%for(int i = 2;i<lsp.size()+1;i++){%>
#select<%=i%> {
	display: none;
}
<%}%>
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="body" class="width">
			<br>
			<h3 style="text-align: center;">Thêm bài viết</h3>
			<p style="text-align: center;color: red;font-size: 18px">${mes_add}</p>
			<form action="${pageContext.request.contextPath}/AddContent" method="post" id="fm" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Menu</td>
						<td>
							 <select id="select" name="select">
								<%
									int i = 1;
									for (support spv : lsp) {
								%>

								<option value="<%=i++%>"><%=spv.getSupport()%></option>
								<%
									}
								%>
						</select>
						</td>
					</tr>

					<tr>
						<td></td>
						<td>
							<%
								for (int j = 1; j <i; j++) {
							%> <select name="menu<%=j%>" id="select<%=j%>">
								<%
									List<menu> listMenu = lt.listMenu(j);
										for (menu mn : listMenu) {
								%>
								<option value="<%=mn.getIdmenu()%>" ><%=mn.getMenu()%></option>

								<%
									}
								%>
						</select>
						<%
									}
								%>
						
						</td>

					</tr>

					<tr>
						<td>Content Name</td>
						<td><textarea rows="3" cols="99" id="ten" name="ten"></textarea></td>
					</tr>
					<tr>
						<td>Summary</td>
						<td><textarea rows="4" cols="99" id="summary" name="summary"></textarea></td>
					</tr>
					<tr>
						<td>Content</td>
						<td><textarea rows="15" cols="99" id="nd" name="nd"></textarea>
							<script type="text/javascript" language="javascript">
								var editor = CKEDITOR.replace('nd');
								CKFinder.setupCKEditor(editor, 'ckfinder/');
							</script></td>
					</tr>
					<tr>
						<td>File</td>
						<td>
						<input type="file" name="file" value="" multiple="true" />
						</td>
					</tr>

				</table>
				<input type="submit" value="Cập nhật bài viết" onclick="kt();"
					style="padding: 8px; margin-left: 400px;">
			</form>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
