<%@page import="java.util.*"%>
<%@page import="service.*"%>
<%@page import="model.*"%>
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
	<aside class="sidebar"> <%
 	ListMenu lt = new ListMenu();
 %>
	<ul>
		<li>
			
			<p style="font-size: 20px;padding-top: 64px;">Tin xem nhiều.</p>
			 <%
 				List<content> listCViewMax = lt.listCViewMax();
 				for (content ct : listCViewMax) {
 			%> 
 				<p style="margin: 0 0 0 15px"><a href="${pageContext.request.contextPath}/ViewContent?idtin=<%=ct.getIdtin()%>"><%=ct.getTen()%> (<%=ct.getCountview()%> lượt)</a></p> 
 			<%
 			}
 			%>
 			<p style="font-size: 20px; margin-top: 5px;margin-bottom: 0px;">Lưu trữ.</p>
			<ul>
				<li>
					<%
						List<Date> listDate = lt.listDate();
						for (Date date : listDate) {
					%>
					<p style="margin: 0 0 0 8px">
						<a
							href="${pageContext.request.contextPath}/ListContent?lt=<%=date%>"><%=date%></a>
					</p> <%
 	}
 %>
				</li>
			</ul>
		</li>

		<li class="bg">
			<h4>About us</h4>
			<ul>
				<li class="text">
					<p style="margin: 0;">
						VNPT Kon Tum <a href="${pageContext.request.contextPath}/jsp/redirect.jsp" class="readmore">Read More
							&raquo;</a>
					</p>
					<p style="margin: 0;">
						VNPT HIS <a href="https://yte-kontum.vnpthis.vn/web_his/dangnhap"
							class="readmore">Read More &raquo;</a>
					</p>
				</li>
			</ul>
		</li>

<!-- 		<li> -->
<!-- 			<h4>Helpful</h4> -->
<!-- 			<ul> -->
<!-- 				<li><h6> -->
<!-- 						Current Time: -->
<%-- 						<%=new java.util.Date()%></h6></li> --%>
<!-- 				<li><h6 id="upcode"></h6></li> -->
<!-- 				<script> 
// 					// Set the date we're counting down to
// 					var countDownDate = new Date("Sep 30, 2017 10:35:00")
// 							.getTime();
// 					// Update the count down every 1 second
// 					var x = setInterval(
// 							function() {
// 								// Get todays date and time
// 								var now = new Date().getTime();
// 								// Find the distance between now an the count down date
// 								var distance = countDownDate - now;

// 								// Time calculations for days, hours, minutes and seconds
// 								var days = Math.floor(distance
// 										/ (1000 * 60 * 60 * 24));
// 								var hours = Math
// 										.floor((distance % (1000 * 60 * 60 * 24))
// 												/ (1000 * 60 * 60));
// 								var minutes = Math
// 										.floor((distance % (1000 * 60 * 60))
// 												/ (1000 * 60));
// 								var seconds = Math
// 										.floor((distance % (1000 * 60)) / 1000);

// 								// Output the result in an element with id="demo"
// 								document.getElementById("upcode").innerHTML = days
// 										+ " ngày "
// 										+ hours
// 										+ " giờ "
// 										+ minutes
// 										+ " phút " + seconds + " giây ";

// 								// If the count down is over, write some text 
// 								if (distance < 0) {
// 									clearInterval(x);
// 									document.getElementById("upcode").innerHTML = "WEBSITE DIE";
// 								}
// 							}, 1000);
<!-- 				</script> -->
<%-- 				<% 
// 					Object demapp = application.getAttribute("demapp");
// 					if (demapp == null) {
// 						demapp = 1;
// 					} else {
// 						demapp = (Integer) demapp + 1;
// 					}
// 					application.setAttribute("demapp", demapp);
<%-- 				%> --%>
<!-- 				<li><h6> -->
<%-- 						Số Lần Xem - CCU:<%=demapp%></h6></li> --%>
<!-- 			</ul> -->
 		<!--</li> -->
 		

	</ul>
	</aside>
	<div class="clear"></div>
</body>
</html>
