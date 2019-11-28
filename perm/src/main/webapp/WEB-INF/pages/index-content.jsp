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
    <c:choose>
        <c:when test="${empty user}">
            <div class="list-group">
                <c:forEach items="${users}" var="user">
                    <c:url var="url" value="${pageContext.request.contextPath}">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <a href="${url}" class="list-group-item">${user.username}</a>
                </c:forEach>
            </div>

            <div class="list-group">
                <a href="${pageContext.request.contextPath}/pages/url1" class="list-group-item">/pages/url1</a>
                <a href="${pageContext.request.contextPath}/pages/url2" class="list-group-item">/pages/url2</a>
            </div>
        </c:when>
        <c:otherwise>
            <form action="${pageContext.request.contextPath}" method="post" class="form-horizontal" role="form">
                <input type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <legend>${user.username}的权限</legend>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Authorities</label>
                    <div class="col-sm-10">
                        <div class="checkbox">
                            <c:forEach items="${authorities}" var="authority">
                                <label>
                                    <input name="authorityId" value="${authority.key.id}" type="checkbox"${authority.value ? ' checked' : ''}>${authority.key.name}
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </c:otherwise>
    </c:choose>
</div>