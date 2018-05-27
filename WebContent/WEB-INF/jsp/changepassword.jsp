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
<script language="javascript">
	function fncSubmit() {
		if (document.TestChangePassword.username.value == "") {
			alert('Please input username');
			document.TestChangePassword.username.focus();
			return false;
		}

		if (document.TestChangePassword.OldPassword.value == "") {
			alert('Please input old password');
			document.TestChangePassword.OldPassword.focus();
			return false;
		}

		if (document.TestChangePassword.newpassword.value == "") {
			alert('Please input Password');
			document.TestChangePassword.newpassword.focus();
			return false;
		}

		if (document.TestChangePassword.conpassword.value == "") {
			alert('Please input Confirm Password');
			document.TestChangePassword.conpassword.focus();
			return false;
		}

		if (document.TestChangePassword.newpassword.value != document.TestChangePassword.conpassword.value) {
			alert('Confirm Password Not Match');
			document.TestChangePassword.conpassword.focus();
			return false;
		}

		document.TestChangePassword.submit();
	}
</script>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp"></jsp:include>

		<div id="body" class="width">
			<section id="content"> <br />
			<br />
			<h2 align="center">Change Password!</h2>
			<form name="TestChangePassword" method="post" action="${pageContext.request.contextPath}/Changepasswd"
				OnSubmit="return fncSubmit();">

				<h2 style="text-align: center;" id="e">${mes_change}</h2>
				<table border="1" align="center" bgcolor="white">

					<tr>
						<td>USERNAME</td>
						<td><input name="username" type="username" id="username"
							size="20" value="${hoten}"></td>
					</tr>
					<tr>
						<td>OLD PASSWORD</td>
						<td><input name="OldPassword" type="password" id="OLDpwd"
							size="20"></td>
					</tr>
					<tr>
						<td>NEW PASSWORD</td>
						<td><input name="newpassword" type="password"
							id="newpassword"></td>
					</tr>
					<tr>
						<td>CONFIRM PASSWORD</td>
						<td><input name="conpassword" type="password"
							id="conpassword"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="Submit" value="Save"></td>
					</tr>
				</table>
			</form>
			</section>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>
