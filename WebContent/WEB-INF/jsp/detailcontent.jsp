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
<div id="container">
            <jsp:include page="header.jsp"></jsp:include>
<%
 				content ctv = (content) request.getAttribute("ctv");
 			%> 
                <div id="body" class="width">
                <form style="margin-top: 30px;">
					<div class="holder"
						style="float: right; margin: 0px 100px 25px 0px;">
						<%--
						<a href="${pageContext.request.contextPath}/ViewContent?idtin=<%=ctv.getIdtin()%>&exWord=exWord"><img
							src="${pageContext.request.contextPath}/img/excel.jpg"></img></a>
						--%>
					</div>
				</form>
                    <article>
                    
                    
 		
                        <br/><h2 style="text-align: center;"><%=ctv.getTen() %></h2>
                    <div id="noidung"><%=ctv.getNoidung() %></div>
                    <input type="hidden" value="<%=ctv.getNoidung()%>" name=""/>
                    <%
							String f = ctv.getFile();
							if(f != null){
								%>
							<p>File đính kèm : <a href="${pageContext.request.contextPath}/Dowload?file=<%=f%>"><%=f%></a></p>
								<%
							}
							%>
                    <h4 style="text-align: right;">Tác giả: <%=ctv.getAuthor() %></h4>
                </article>

                <%--
                <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="600" data-numposts="5"></div>
                --%>
                <div class="fb-comments" data-href="http://localhost:8080/VNPTSupport/single.jsp?idtin==idtin" data-width="900" data-numposts="5"></div>
                <div class="clear"></div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>