<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/16
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<jsp:include page="/WEB-INF/templates/bootstrap.jsp">
    <jsp:param name="content" value="/WEB-INF/pages/book/cart/content.jsp"/>
    <jsp:param name="js" value="/WEB-INF/pages/book/cart/js.jsp"/>
</jsp:include>