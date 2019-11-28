<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n.web"/>
<c:if test="${not empty error}">
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> ${error}
    </div>
</c:if>
<c:if test="${not empty sessionScope.cart.books}">
    <legend>商品</legend>
    <ul class="list-group">
        <c:forEach var="item" items="${sessionScope.cart.books}">
            <c:set var="book" value="${item.value.book}"/>
            <c:url var="deleteUrl" value="/deleteFromCart">
                <c:param name="id" value="${book.id}"/>
            </c:url>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">${book.title}</h4>
                <p class="list-group-item-text">
                    <fmt:message key="book.author"/>: ${book.author}<br>
                    <fmt:message key="book.price"/>: <fmt:formatNumber type="currency" value="${book.price}" maxFractionDigits="2"/><br>
                    <fmt:message key="book.publishingDate"/>: <fmt:formatDate value="${book.publishingDate}" type="both"/><br/>
                    数量: ${item.value.quantity}
                </p>
            </li>
        </c:forEach>
    </ul>

    <c:url var="transactUrl" value="/transact"/>
    <form action="${transactUrl}" method="post" role="form">
        <legend>信用卡</legend>

        <div class="form-group">
            <label for="no">银行卡号</label>
            <div class="row">
                <div class="col-sm-6">
                    <input type="number" class="form-control" name="no" value="${not empty no ? no : ""}" id="no" placeholder="输入银行卡号" autocomplete="off">
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="name">户主姓名</label>
            <div class="row">
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="name" value="${not empty name ? name : ""}" id="name" placeholder="输入户主姓名" autocomplete="off">
                </div>
            </div>
        </div>

        <h3 class="well">
            <div>
                <fmt:message key="cartStatisticTip">
                    <fmt:param>
                        <span id="count">${sessionScope.cart.count}</span>
                    </fmt:param>
                    <fmt:param>
                        <span id="price"><fmt:formatNumber type="currency" value="${sessionScope.cart.price}" maxFractionDigits="2"/></span>
                    </fmt:param>
                </fmt:message>
            </div>

            <c:url var="previewTransactionUrl" value="/previewTransaction"/>
            <div class="btn-transact-box">
                <button href="${previewTransactionUrl}" class="btn-transact btn-lg btn btn-primary pull-right">支付</button>
            </div>
        </h3>
    </form>
</c:if>