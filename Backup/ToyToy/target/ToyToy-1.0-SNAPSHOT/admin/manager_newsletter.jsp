<%-- 
    Document   : manage_category
    Created on : 03-Mar-2017, 09:56:25
    Author     : NguyenDang
--%>

<%@page import="com.toytoy.model.Newsletter"%>
<%@page import="com.toytoy.get.NewsletterGet"%>
<%@page import="com.toytoy.model.Contact"%>
<%@page import="com.toytoy.get.ContactGet"%>
<%@page import="com.toytoy.model.UserAdmin"%>
<%@page import="com.toytoy.model.User"%>
<%@page import="com.toytoy.get.UserGet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.toytoy.model.Category"%>
<%@page import="com.toytoy.get.CategoryGet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lý Liên Hệ</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        <%

            NewsletterGet newsletterGet = new NewsletterGet();
            ArrayList<Newsletter> listNewsletter = newsletterGet.getListNewsletter();
            %>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    
<h3>QUẢN LÝ LIÊN HỆ</h3>
                    <div class="informasi">
                        Hãy chỉnh sửa dữ liệu cẩn thận nhé ^^
                    </div>

                   
                    
                    
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">Mã số</th>
                            <th class="data">Email</th>
                            <th class="data">Thời gian</th>
                            
                            
                        </tr>
                        <% 
                          int count =0;
                          for(Newsletter newsletter : listNewsletter){
                              count++;
                          
                            %>
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=newsletter.getNewsletterID()%></td>
                            <td class="data"><%=newsletter.getNewsletterName()%></td>
                            <td class="data"><%=newsletter.getDate()%></td>
                            
                            
                        </tr>
                        <% } %>
                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
