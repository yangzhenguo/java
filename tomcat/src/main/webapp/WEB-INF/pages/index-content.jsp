<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/22
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" errorPage="/WEB-INF/error.jsp" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>价格</th>
        <th>市场价</th>
        <th>日期</th>
        <th>热卖</th>
        <th style="width: 30%;">描述</th>
        <th style="width: 80px;">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.shopPrice}</td>
            <td>${product.marketPrice}</td>
            <td>${product.date}</td>
            <td>${product.isHot ? '是' : '否'}</td>
            <td>${product.desc}</td>
            <td>
                <a href="https://www.baidu.com/" class="delete">百度</a>
                <a href="${pageContext.request.contextPath}/deleteProduct?id=${product.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
