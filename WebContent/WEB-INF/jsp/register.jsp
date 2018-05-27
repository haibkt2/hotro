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
<script type="text/javascript">
	function kt() {
		var p1 = document.getElementById("pass").value.trim();
		var p2 = document.getElementById("repass").value.trim();
		var id = document.getElementById("id").value.trim();
		var ht = document.getElementById("ht").value.trim();
		if (p1 == "" || p2 == "" || id == "" || ht == "") {
			document.getElementById("e").innerHTML = "Chưa Nhập Đầy Đủ Thông Tin!";
			return;
		}
		if (p1 != p2) {
			document.getElementById("e").innerHTML = "Pass không đạt yêu cầu!";
			return;
		}
		fm.submit();
	}
</script>
<style>
.khungregister {
	background-color: #f1f1f1;
	padding: 20px;
}

input {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
}

#testregister {
	display: none;
	background: #f1f1f1;
	color: #000;
	position: relative;
	padding: 20px;
	margin-top: 10px;
}

#testregister p {
	padding: 5px 30px;
	font-size: 18px;
}

.testtrue {
	color: green;
}

.testtrue:before {
	position: relative;
	left: -35px;
	content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.testfalse {
	color: red;
}

.testfalse:before {
	position: relative;
	left: -35px;
	content: "✖";
}
</style>
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp"></jsp:include>

		<div id="body" class="width">
			<section id="content"> <br>
			<h2 style="text-align: center;">CREATE ACCOUNT</h2>
			<div class="khungregister">
				<form action="${pageContext.request.contextPath}/Register?register=regNew" id="fm" method="post">
					<h3 style="text-align: center;" id="e">${mes_reg }</h3>
					<label
						for="username">Username</label> <input type="text" id="id"
						name="id" placeholder="Tên đăng nhập" required> <label
						for="pass">Password</label> <input type="password" id="pass"
						name="pass" placeholder="Mật khẩu"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Test password" required> <label for="repass">Re
						- Password</label> <input type="password" id="repass" name="repass"
						placeholder="Nhập lại mật khẩu"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Test password" required> <input type="submit"
						value="Đăng Ký" onclick="kt();">
				</form>
				<div id="testregister">
					<h3>Bạn nên đặt mật khẩu theo:</h3>
					<p id="letter" class="testfalse">Không để trống</p>
					<p id="capital" class="testfalse">Chữ in hoa</p>
					<p id="number" class="testfalse">Có chữ số</p>
					<p id="length" class="testfalse">Tối thiểu 8 kí tự</p>
				</div>

				<script>
					var mypassword = document.getElementById("repass");
					var letter = document.getElementById("letter");
					var capital = document.getElementById("capital");
					var number = document.getElementById("number");
					var length = document.getElementById("length");

					// When the user clicks on the password field, show the message box
					mypassword.onfocus = function() {
						document.getElementById("testregister").style.display = "block";
					}

					// When the user clicks outside of the password field, hide the message box
					mypassword.onblur = function() {
						document.getElementById("testregister").style.display = "none";
					}

					// When the user starts to type something inside the password field
					mypassword.onkeyup = function() {
						// Validate lowercase letters
						var lowerCaseLetters = /[a-z]/g;
						if (mypassword.value.match(lowerCaseLetters)) {
							letter.classList.remove("testfalse");
							letter.classList.add("testtrue");
						} else {
							letter.classList.remove("testtrue");
							letter.classList.add("testfalse");
						}

						// Validate capital letters
						var upperCaseLetters = /[A-Z]/g;
						if (mypassword.value.match(upperCaseLetters)) {
							capital.classList.remove("testfalse");
							capital.classList.add("testtrue");
						} else {
							capital.classList.remove("testtrue");
							capital.classList.add("testfalse");
						}

						// Validate numbers
						var numbers = /[0-9]/g;
						if (mypassword.value.match(numbers)) {
							number.classList.remove("testfalse");
							number.classList.add("testtrue");
						} else {
							number.classList.remove("testtrue");
							number.classList.add("testfalse");
						}

						// Validate length
						if (mypassword.value.length >= 8) {
							length.classList.remove("testfalse");
							length.classList.add("testtrue");
						} else {
							length.classList.remove("testtrue");
							length.classList.add("testfalse");
						}
					}
				</script>
			</section>
			<div class="clear"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>

