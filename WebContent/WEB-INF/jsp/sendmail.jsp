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
			<br>
			<h3 style="text-align: center;">Gửi FeedBack</h3>
			<p style="text-align: center; color: red; font-size: 18px">${mss_send}</p>
			<form action="${pageContext.request.contextPath}/SendFeedback"
				method="post" id="fm" enctype="multipart/form-data">
				<table>
					<tr>
						<td>Subject</td>
						<td><textarea rows="2" cols="99" id="summary" name="summary"></textarea></td>
					</tr>
					<tr>
						<td>Thông tin</td>
						<td><textarea rows="1" cols="30" id="email" name="email"
								placeholder="Đỉa chỉ email của bạn"></textarea> <br> <input
							type="password" id="pass" name="pass" style="width: 289px"
							placeholder="Pass của bạn"></td>
					</tr>
					
					<!-- 					<tr> -->
					<!-- 						<td>Phone</td> -->
					<!-- 						<td><input type="tel" required pattern="^[0-9-+s()]*$" autocomplete="off"/> -->
					<!-- 						</td> -->
					<!-- 					</tr> -->
					<tr>
						<td>Content</td>
						<td><textarea rows="10" cols="99" id="nd" name="nd"></textarea>
							<script type="text/javascript" language="javascript">
								var editor = CKEDITOR.replace('nd');
								CKFinder.setupCKEditor(editor, 'ckfinder/');
							</script></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="file" name="file" size="130" /></td>
					</tr>
					<!-- 					<tr> -->
					<!-- 						<td>Đính kèm File</td> -->
					<!-- 						<td><textarea rows="1" cols="99" id="phone" name="phone" ></textarea></td> -->
					<!-- 					</tr> -->
				</table>
				<input type="submit" value="Send Feedback" onclick="kt();"
					style="padding: 8px; margin: 3px 0 100px 400px;">
			</form>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
