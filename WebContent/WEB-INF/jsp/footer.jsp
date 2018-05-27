<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>VNPT SUPPORT</title>
<link href="${pageContext.request.contextPath}/css/vnpt.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<footer>
	<p>
		<a href="index.jsp">TRUNG TÂM CÔNG NGHỆ THÔNG TIN</a>
	</p>
	<button onclick="totopFunction()" id="ToTop" title="Go to top">Top</button>
	</footer>
	 <script>
// When the user scrolls down 20px from the top of the document, show the button
            window.onscroll = function () {
                scrollFunction()
            };

            function scrollFunction() {
                if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                    document.getElementById("ToTop").style.display = "block";
                } else {
                    document.getElementById("ToTop").style.display = "none";
                }
            }

// When the user clicks on the button, scroll to the top of the document
            function totopFunction() {
                document.body.scrollTop = 0;
                document.documentElement.scrollTop = 0;
            }
        </script>
	
</body>
</html>