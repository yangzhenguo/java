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
    <table class="table table-bordered table-hover table-striped" style="margin-bottom: 0;">
        <thead>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>已售</th>
            <th>库存</th>
            <th>发版时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${pager.list}">
            <c:url var="detailUrl" value="${pageContext.request.contextPath}/book/detail">
                <c:param name="id" value="${book.id}"/>
                <c:param name="page" value="${pager.page}"/>
            </c:url>
        <tr>
            <td>
                <a href="${detailUrl}">${book.title}</a>
            </td>
            <td>${book.author}</td>
            <td><fmt:formatNumber type="currency" value="${book.price}" minFractionDigits="2" maxFractionDigits="2"/></td>
            <td><fmt:formatNumber value="${book.salesAmount}"/></td>
            <td><fmt:formatNumber value="${book.storeNumber}"/></td>
            <th><fmt:formatDate value="${book.publishingDate}" type="both"/></th>
        </tr>
        </c:forEach>
        </tbody>
    </table>
<c:url var="firstUrl" value="${pageContext.request.contextPath}/books">
    <c:param name="page" value="1"/>
</c:url>
<c:url var="lastUrl" value="${pageContext.request.contextPath}/books">
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
                <c:url var="currentUrl" value="${pageContext.request.contextPath}/books">
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
