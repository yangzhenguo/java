<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/11
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${not empty param.lang}">
    <fmt:setLocale value="${param.lang}"/>
</c:if>

<fmt:setBundle basename="i18n.web"/>

<c:url var="url" value="/">
    <c:if test="${not empty param.lang}">
        <c:param name="lang" value="${param.lang}"/>
    </c:if>
</c:url>

<fmt:message var="error" key="backHomeTip">
    <fmt:param value="${pageContext.exception.message}"/>
    <fmt:param>
        <a href="${url}"><fmt:message key="home"/></a>
    </fmt:param>
</fmt:message>

    <div class="well">
        <p>${error}</p>
    </div><!-- /.well -->
