<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>VNPT SUPPORT</title>


.sideaccoutsub a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 20px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sideaccoutsub a:hover {
	color: #f1f1f1;
}
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
<style>
.sideaccoutsub {
	height: 50%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 70px;
	background-color: #97D553;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}
.sideaccoutsub .closebtnaccoutsub {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 30px;
	margin-left: 40px;
}

#mainsideaccoutsub {
	transition: margin-left .5s;
	padding: 16px;
}

@media screen and (max-height: 450px) {
	.sideaccoutsub {
		padding-top: 15px;
	}
	.sideaccoutsub a {
		font-size: 18px;
	}
}

.holder {
	display: inline;
}

.holder img {
	max-height: 200px;
	max-width: 200px;
	object-fit: cover;
}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp"></jsp:include>

		<div id="body" class="width">
			<article> 
			<%
 	String u = (String) session.getAttribute("username");
 	if (u.equals("admin")) {
 %>
			<div id="mysideaccoutsub" class="sideaccoutsub">
				<a href="javascript:void(0)" class="closebtnaccoutsub"
					onclick="closesideaccoutsub()">&times; </a>
<!-- 									<a -->
<%-- 									href="${pageContext.request.contextPath}/Search?">Search --%>
<!-- 									Advance</a>  -->

				<a href="${pageContext.request.contextPath}/ManageMenu">Manage
					Menu</a> 
				<a href="${pageContext.request.contextPath}/ManageNotify">Manage
					Notify</a> 
				<a href="${pageContext.request.contextPath}/ManageAccount">Manage
					Author</a>
				<a href="${pageContext.request.contextPath}/ManageAccount2">Manage
					Author2</a>

			</div>
			
			<span style="font-size: 30px; cursor: pointer;" id="mainsideaccoutsub"
					onclick="opensideaccoutsub()" class="fa fa-bars"> Open </span> <br>
			<%} %>
			<div id="mainaccoutsub">
				
				<h3 style="text-align: left;">
					Hi : ${hoten} <a
						href="${pageContext.request.contextPath}/Changepasswd?change=">«
						Change Password » |</a> <a
						href="${pageContext.request.contextPath}/Logout?">|« Logout »</a>
				</h3>
				<br>



				<script>
					// Get the modal
					var info = document.getElementById('myinfo');

					// Get the button that opens the modal
					var infoac = document.getElementById("infoaccount");

					// Get the <span> element that closes the modal
					var span = document.getElementsByClassName("closeinfo")[0];

					// When the user clicks the button, open the modal 
					infoac.onclick = function() {
						info.style.display = "block";
					}

					// When the user clicks on <span> (x), close the modal
					span.onclick = function() {
						info.style.display = "none";
					}

					// When the user clicks anywhere outside of the modal, close it
					window.onclick = function(event) {
						if (event.target == info) {
							info.style.display = "none";
						}
					}
				</script>
				<a style="text-align: left; font-size: 16px;"
					href="${pageContext.request.contextPath}/AddNewCt?addtin=">Thêm
					nội dung</a> 
<!-- 					|| <a style="text-align: left; font-size: 16px;" -->
<%-- 					href="${pageContext.request.contextPath}/Import?import=">Import bài viết</a><br> <br> --%>
				<h2>${thongbao}</h2>
				<section> <br>
				<form
					action="${pageContext.request.contextPath}/Search?accout=search"
					method="POST">
					<input type="text" name="ten" id="searchaccout"
						placeholder="Search for name content"> <input
						type="submit" value="Search" class="login" />
				</form>

				<%
					String user = (String) session.getAttribute("username");
					if (user.equals("admin")) {
				%>
				<form action="${pageContext.request.contextPath}/Profile?export=excel" style="float: right; margin: 0px 10px 25px 0px;" method="POST">
					<div class="holder"></div>
						
						Từ <input type="date" id="date_fr" name="date_fr" placeholder="'dd/mm/yyyy'"> 
						
						Tới :<input type="date" id="date_to" name="date_to" placeholder="'dd/mm/yyyy'">
						
						<button type="submit" style="padding: 15px 0px 15px 0px;  ;width: 38px;height:38px ;background: url('${pageContext.request.contextPath}/img/excel.jpg');"></button>
					</div>
				</form>
				<%
					}
				%>
				<p style="text-align: center; color: red; font-size: 18px">${mss_del}</p>
				<br>
				<input type="checkbox" id="myCheck" checked onclick="myFunction()"
					style="margin-bottom: 30px;"> Show all <script>
						function myFunction() {
							var checkBox = document.getElementById("myCheck");
							var text = document
									.getElementById("bootstrap-table");
							var text_f = document
									.getElementById("table-footer");
							if (checkBox.checked == true) {
								text.style.display = "block";
								text_f.style.display = "block";
							} else {
								text.style.display = "none";
								text_f.style.display = "none";
							}
						}
					</script>
				<table id="bootstrap-table" border="1"
					class="table table-bordered table-striped">
					<thead>
						<tr>
							<th style="width: 10%;">MENU</th>
							<th style="width: 15%;">SUMMARY</th>
							<th style="width: 50%;">NAME CONTENT</th>
							<th style="width: 3%;">AUTHOR</th>
							<th style="width: 20%;">DATE</th>
							<th style="width: 3%;">EDIT</th>
							<th style="width: 2%;">DELETE</th>
						</tr>
					</thead>
					<tbody>

						<%
							List<menu> listContM = (ArrayList) request.getAttribute("listContM");
							for (menu mn : listContM) {
								for (content ct : mn.getContents()) {
						%>
						<tr>
							<td><%=mn.getMenu()%></td>
							<td><%=ct.getSummary()%></td>
							<td><%=ct.getTen()%></td>
							<td><%=ct.getAuthor()%></td>
							<td><%=ct.getDate()%></td>
							<td><a style="color: green;"
								href="${pageContext.request.contextPath}/EditContent?ten=<%=ct.getTen()%>&idmn=<%=mn.getIdmenu()%>&idsp=<%=mn.getIdsupport()%>&idct=<%=ct.getIdtin()%>">Sửa</a></td>
							<td><a style="color: red;"
								href="${pageContext.request.contextPath}/DeleteCt?ten=<%=ct.getTen()%>&idmn=<%=mn.getIdmenu()%>&idsp=<%=mn.getIdsupport()%>&idct=<%=ct.getIdtin()%>">Xóa</a></td>
						</tr>
						<%
							}
							}
						%>

					</tbody>
				</table>
				<br>

				<div id="pages"></div>
				<script>
					function Functionsearchaccout() {
						var searchacc, filter, tableacc, tr, td, i;
						searchacc = document.getElementById("searchaccout");
						filter = searchacc.value.toUpperCase();
						tableacc = document.getElementById("bootstrap-table");
						tr = tableacc.getElementsByTagName("tr");
						for (i = 0; i < tr.length; i++) {
							td = tr[i].getElementsByTagName("td")[2];
							if (td) {
								if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
									tr[i].style.display = "";
								} else {
									tr[i].style.display = "none";
								}
							}
						}
					}
				</script> </section>
			</div>

			<script>
				function opensideaccoutsub() {
					document.getElementById("mysideaccoutsub").style.width = "250px";
					document.getElementById("mainsideaccoutsub").style.marginLeft = "250px";
				}

				function closesideaccoutsub() {
					document.getElementById("mysideaccoutsub").style.width = "0";
					document.getElementById("mainsideaccoutsub").style.marginLeft = "0";
				}
			</script> </article>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script src="js/jquery.bdt.min_10.js"
		type="text/javascript"></script>
</body>
</html>
