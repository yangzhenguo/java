<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/11
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n.web"/>
    <c:if test="${not empty sessionScope.cart.books}">
        <c:url var="toCartUrl" value="/cart"/>
        <div class="well">
            <fmt:message key="cartTip">
                <fmt:param value="${cart.count}"/>
                <fmt:param>
                    <a href="${toCartUrl}"><fmt:message key="clickToCart"></fmt:message></a>
                </fmt:param>
            </fmt:message>
        </div>
    </c:if>
    <table class="table table-bordered table-hover table-striped" style="margin-bottom: 0;">
        <thead>
        <tr>
            <th><fmt:message key="book.title"/></th>
            <th><fmt:message key="book.author"/></th>
            <th><fmt:message key="book.price"/></th>
            <th><fmt:message key="book.salesCount"/></th>
            <th><fmt:message key="book.storeCount"/></th>
            <th><fmt:message key="book.publishingDate"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${pager.list}">
            <c:url var="detailUrl" value="/book/detail">
                <c:param name="id" value="${book.id}"/>
                <c:param name="page" value="${pager.page}"/>
            </c:url>
            <c:url var="cartUrl" value="/addToCart">
                <c:param name="id" value="${book.id}"/>
            </c:url>
        <tr>
            <td>
                <a href="${detailUrl}">${book.title}</a>
            </td>
            <td>${book.author}</td>
            <td><fmt:formatNumber type="currency" value="${book.price}" minFractionDigits="2" maxFractionDigits="2"/></td>
            <td><fmt:formatNumber value="${book.salesAmount}"/></td>
            <td><fmt:formatNumber value="${book.storeNumber}"/></td>
            <td><fmt:formatDate value="${book.publishingDate}" type="both"/></td>
            <td>
                <a href="${cartUrl}"><fmt:message key="addToCart"></fmt:message></a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
<c:url var="firstUrl" value="/books">
    <c:param name="page" value="1"/>
</c:url>
<c:url var="lastUrl" value="/books">
    <c:param name="page" value="${pager.pages}"/>
</c:url>
    <nav aria-label="pagination">
        <ul class="pagination pull-right">
            <c:if test="${pager.hasPrev}">
                <li>
                    <a href="${firstUrl}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${not pager.hasPrev}">
                <li class="disabled">
                    <a href="javascript:void(0);" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${pager.pages}" var="page">
                <c:url var="currentUrl" value="/books">
                    <c:param name="page" value="${page}"/>
                </c:url>
                <c:if test="${pager.page == page}">
                    <li class="active"><a href="javascript:void(0);">${page}</a></li>
                </c:if>
                <c:if test="${not (pager.page == page)}">
                    <li><a href="${currentUrl}">${page} <span class="sr-only">(current)</span></a></li>
                </c:if>
            </c:forEach>

            <c:if test="${pager.hasNext}">
                <li>
                    <a href="${lastUrl}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${not pager.hasNext}">
                <li class="disabled">
                    <a href="javascript:void(0);" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
