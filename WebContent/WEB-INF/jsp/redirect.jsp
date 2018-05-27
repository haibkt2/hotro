<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <li>Bạn sẽ chuyển sang trang <a href="http://kontum.vnpt.vn/"/>VNPT KON TUM</a> sau <span id="time">10</span> giây nữa</li> 
<a href="${pageContext.request.contextPath}/Home" onclick="reload();" id="reloadlink" title="Nhấn vào đây để tải lại trang">Tải lại trang</a> 
<script type="text/javascript"> var jgt = 10;
    document.getElementById('time').innerHTML = jgt;
    function stime() {
        document.getElementById('time').innerHTML = jgt;
        jgt = jgt - 1;
        if (jgt == 0) {
            clearInterval(timing);
            location = 'http://kontum.vnpt.vn';
        }
    }
    var timing = setInterval("stime();", 1000);</script>
</body>
</html>
