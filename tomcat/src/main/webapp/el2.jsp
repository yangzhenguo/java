<%@ page import="com.yangzg.model.book.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/27
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</body>
</html>
