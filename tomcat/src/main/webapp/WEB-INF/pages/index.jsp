<%@page trimDirectiveWhitespaces="true" pageEncoding="UTF-8" session="false" errorPage="/WEB-INF/error.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="/WEB-INF/templates/index.jsp">
    <jsp:param name="title" value="首页"/>
    <jsp:param name="content" value="pages/index-content"/>
    <jsp:param name="style" value="pages/index-style"/>
</jsp:include>
