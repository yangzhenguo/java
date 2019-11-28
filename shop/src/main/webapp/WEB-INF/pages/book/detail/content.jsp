<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/11
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url var="continueUrl" value="/books">
    <c:if test="${not empty param.page}">
        <c:param name="page" value="${param.page}"/>
    </c:if>
</c:url>
    <h3>${book.title}</h3>
    <p>作者：${book.author}</p>
    <p>价格：<fmt:formatNumber type="currency" value="${book.price}"/></p>
    <p>发版日期：<fmt:formatDate type="both" value="${book.publishingDate}"/></p>
    <p>出售：${book.salesAmount}</p>
    <p>库存：${book.storeNumber}</p>
<a href="${continueUrl}">继续购物</a>