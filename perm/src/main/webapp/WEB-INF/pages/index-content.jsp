<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/30
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="well well-lg">
    <div class="list-group">
        <c:forEach items="${users}" var="user">
            <c:url var="url" value="${pageContext.request.contextPath}">
                <c:param name="id" value="${user.id}"/>
            </c:url>
            <a href="${url}" class="list-group-item">${user.username}</a>
        </c:forEach>
    </div>
</div>