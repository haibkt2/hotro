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
                    <article>
                   
                    <br/><h2 style="text-align: center;">tentin</h2>
                    <div id="noidung">nd</div>
                    <h4 style="text-align: right;">Ngày viết day</h4>
                    <h4 style="text-align: right;">Tác giả author</h4>
                </article>
                <%--
                <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="600" data-numposts="5"></div>
                --%>
                <div class="fb-comments" data-href="http://localhost:8080/VNPTSupport/single.jsp?idtin=idtin%" data-width="900" data-numposts="5"></div>
                <div class="clear"></div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
