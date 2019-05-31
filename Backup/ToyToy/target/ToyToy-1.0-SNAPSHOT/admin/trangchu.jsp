<%-- 
    Document   : trangchu
    Created on : 13-Mar-2017, 21:21:27
    Author     : NguyenDang
--%>

<%@page import="com.toytoy.model.UserAdmin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRANG QUẢN TRỊ HUTECHACOUSTIC SHOP</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
<%
            UserAdmin user = (UserAdmin) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("/ToyToy/admin/login.jsp");
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

            <jsp:include page="content.jsp"></jsp:include>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
