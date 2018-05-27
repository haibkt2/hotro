<%@page import="java.util.*"%>
<%@page import="service.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<div id="fb-root"></div>
<style>
#menu1{ background: #97D553; width: 100%;height:35px}

#ul{ z-index: 100; margin: 0; padding: 0; list-style-type: none; text-align: center;}

#ul li{ float: left; display: inline; position: relative; font-size: 15px;} 

#ul2 { display: none; position: absolute; width: 200px; padding: 0 1px; margin: 28px 0 0 8px; z-index: 101;}

#ul li a { display: block; height: 30px; margin-left: 2px;
           line-height: 25px; font-size: 13px; font-family: Georgia, "Times New Roman", Times, serif;
           text-align: left; text-decoration: none;
           font-weight: 200; outline: none;}    

#ul li:hover { background: #97D553;}        

#ul li:hover ul{ display: block; background: #97D553; top: 1px; width: 110px;}

#ul2 li{ display: list-item; float: none;list-style: none}

#ul2 li ul{ top: 0;}

.clear{ clear: both;}
</style>
<script>
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.10&appId=483325195359686";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<title>VNPT SUPPORT</title>
<link href="${pageContext.request.contextPath}/css/vnpt.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<nav>
	<div class="width">
		<div id="menu1">
			<ul id="ul">
				<li><a href="${pageContext.request.contextPath}/Home"><i
						style="background: url(images/03.png) no-repeat 0px 0px; width: 16px; display: inline-block; vertical-align: top; margin: 4px;">
					</i>Home</a></li>
				<%
					ListMenu lt = new ListMenu();
					int sizemn = lt.listSp().size();
					for (int i = 1; i <=sizemn; i++) {
						
				%>
				<li><a><%=lt.listSp().get(i-1).getSupport() %></a>
					<ul id="ul2">
						<%
							List<menu> listMenu = lt.listMenu(i);
						%>
						<%
							for (menu mn : listMenu) {
						%>
						<li><a style="font-size: 9px;"
							href="${pageContext.request.contextPath}/Menu?menu=<%=mn.getMenu()%>"><%=mn.getMenu()%></a>
							</li>
						<%
							}
						%>
					</ul></li>
				<%
					}
				%>

				<li><a href="${pageContext.request.contextPath}/Profile">ACCOUNT </a>
					<ul id="ul2">
						<li><a
							href="${pageContext.request.contextPath}/Register?register=">Register</a></li>
						<li><a href="${pageContext.request.contextPath}/Profile">Login</a></li>
					</ul></li>

				<li><a
					href="${pageContext.request.contextPath}/SendFeedback?sendFb=feedback">Send
						Mail</a></li>
			</ul>
			<div class="clear"></div>
		</div>

		<div id="textrun">
			<marquee style="z-index: 100; margin-top: 10px" direction="left">
				<h10>VNPT KON TUM - TRUNG TÂM CÔNG NGHỆ THÔNG TIN</h10>
			</marquee>
		</div>

	</div>
	</nav>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"
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
