<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/16
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n.web"/>
<c:url var="toBuyUrl" value="/"/>
<h3>
    <fmt:message key="cart"/>
    <c:if test="${not empty sessionScope.cart.books}">
    &nbsp;<a href="${toBuyUrl}" class="small btn btn-default btn-sm"><span class="text-success">继续购物</span></a>
    </c:if>
</h3>
<c:if test="${empty sessionScope.cart.books}">
    <fmt:message key="emptyCartTip">
        <fmt:param>
            <a href="${toBuyUrl}"><fmt:message key="clickToBuy"/></a>
        </fmt:param>
    </fmt:message>
</c:if>
<c:if test="${not empty sessionScope.cart.books}">
    <p>
        <fmt:message key="cartStatisticTip">
            <fmt:param>
                <span id="count">${sessionScope.cart.count}</span>
            </fmt:param>
            <fmt:param>
                <span id="price"><fmt:formatNumber type="currency" value="${sessionScope.cart.price}" maxFractionDigits="2"/></span>
            </fmt:param>
        </fmt:message>
    </p>
</c:if>
<c:if test="${not empty sessionScope.cart.books}">
    <ul class="list-group">
        <c:forEach var="item" items="${sessionScope.cart.books}">
            <c:set var="book" value="${item.value.book}"/>
            <c:url var="deleteUrl" value="/deleteFromCart">
                <c:param name="id" value="${book.id}"/>
            </c:url>
            <li class="list-group-item">
                <input type="number" class="pull-right form-control input-sm text-center" data-id="${book.id}" data-count="${item.value.quantity}" style="width: 40px;" value="${item.value.quantity}">
                <h4 class="list-group-item-heading">${book.title}</h4>
                <p class="list-group-item-text">
                    <fmt:message key="book.author"/>: ${book.author}<br>
                    <fmt:message key="book.price"/>: <fmt:formatNumber type="currency" value="${book.price}" maxFractionDigits="2"/><br>
                    <fmt:message key="book.publishingDate"/>: <fmt:formatDate value="${book.publishingDate}" type="both"/>
                </p>
                <div class="text-right">
                    <a href="${deleteUrl}" class="btn btn-danger btn-sm delete">删除</a>
                </div>
            </li>
        </c:forEach>
    </ul>
    <c:url var="previewTransactionUrl" value="/previewTransaction"/>
    <a href="${previewTransactionUrl}" class="preview-transaction btn-lg btn-block btn btn-success pull-right">预览订单</a>
</c:if>