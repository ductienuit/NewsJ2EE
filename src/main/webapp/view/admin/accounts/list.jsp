<%--
  Created by IntelliJ IDEA.
  User: DucTien
  Date: 22/05/2019
  Time: 3:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách tài khoản</title>
</head>

<body>
<div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Danh sách tài khoản</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <c:if test="${not empty message}">
                <div class="alert alert-${alert}" role="alert">
                        ${message}
                </div>
            </c:if>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                           title='Thêm tài khoảns' href='<c:url value="/admin-accounts?type=insert"/>'>
                                                    <span>
                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                    </span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Tên tài khoản</th>
                                            <th>Họ và tên</th>
                                            <th>Phân quyền</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td>${item.id}</td>
                                                <td>${item.username}</td>
                                                <td>${item.fullName}</td>
                                                <td>
                                                    <div>
                                                        <select class="form-control"
                                                                id="form-field-select-1"
                                                                value="2"
                                                                disabled>
                                                            <c:choose>

                                                                <c:when test = "${item.role.priority > 1}">
                                                                    <option value="1">Người dùng</option>
                                                                    <option value="2" selected="selected">Quản trị viên</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="1" selected="selected">Người dùng</option>
                                                                    <option value="2">Quản trị viên</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </select>
                                                    </div>
                                                </td>
                                                <td>
                                                    <c:url var="editURL" value="/admin-accounts">
                                                        <c:param name="type" value="edit"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary" data-toggle="tooltip"
                                                       title="Cập nhật tài khoản" href='${editURL}'><i
                                                            class="fa fa-check-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <c:url var="deleteURL" value="/admin-accounts">
                                                        <c:param name="type" value="delete"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-danger btn-edit" data-toggle="tooltip"
                                                       title="Xóa tài khoản" href='${deleteURL}'>
                                                        <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <form action="<c:url value='/admin-accounts'/>" id="formSubmit" method="get">
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                    <input type="hidden" value="" id="type" name="type"/>
                                    </form>

                                    <!-- PAGE CONTENT ENDS -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<!-- /.main-content -->
<script>
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var visiblePages = 3; //Số phân trang
    var limit = 10;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('id');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
</body>

</html>