<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/24
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>姓名</th>
        <th>地址</th>
        <th>卡种</th>
        <th>卡号</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty cosutomer}">
    <tr>
        <td>${customer.name}</td>
        <td>${customer.address}</td>
        <td>${customer.cardType}</td>
        <td>${customer.card}</td>
    </tr>
    </c:if>
    </tbody>
</table>