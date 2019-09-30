<%@ page import="com.yangzg.model.book.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/27
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>EL</title>
</head>
<body>
<%
pageContext.setAttribute("book", "<<Java>>");
%>
book: ${book}, <c:out value="${book}" default="Hello World"/>
<hr>
<c:set var="name" value="yzg" scope="page"/>
name: ${name}
<hr>
<% pageContext.setAttribute("customer", new Customer("yzg", "beijing", "visa", "23")); %>
<br>
<c:set target="${customer}" property="name" value="yangzg"/>
Customer: ${customer}<br>
<table border="1" style="border-collapse: collapse; width: 100%;">
    <c:forEach items="${pageContext.request.headerNames}" var="name">
        <tr>
            <td>${name}</td>
            <td>
                <c:choose>
                    <c:when test="${name.indexOf('accept') > -1}">
                        <table border="1" style="border-collapse: collapse; width: 100%; height: 100%;">
                            <c:forTokens var="prop" items="${pageContext.request.getHeader(name)}" delims=";" varStatus="status">
                                <tr>
                                    <td>
                                            ${prop}
                                    </td>
                                </tr>
                            </c:forTokens>
                        </table>
                    </c:when>
                    <c:otherwise>
                        ${pageContext.request.getHeader(name)}
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
${pageContext.response.characterEncoding}
<br>
<c:url var="url" value="http://a/b/c" context="/root" scope="request">
    <c:param name="姓名" value="杨振国"/>
</c:url>
${requestScope.url}
<br>
<%--<c:import url="http://www.baidu.com/" charEncoding="UTF-8"/>--%>
<fmt:setTimeZone value="GMT+3"/>
<jsp:useBean id="date" class="java.util.Date"/>
${date.toLocaleString()}<br>
<fmt:formatDate value="${date}" dateStyle="full" timeStyle="full" type="both"/>
<br>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${param.locale}"/>
<fmt:bundle basename="i18n.language_${param.locale}" prefix="label.">
    <fmt:message key="hello"/>
</fmt:bundle>
</body>
</html>
