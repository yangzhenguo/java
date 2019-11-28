<%@ page import="com.yangzg.chapter11.JDBCUtil" %>
<%@ page import="com.yangzg.chapter11.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/7/19
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>title</title>
  </head>
  <body>
  <%
    List<User> users = JDBCUtil.queryList("select * from users", User.class);
    request.setParameter('users', users);
  %>
  <ul>
    <c:forEach items="${users}" var="user">
      <li>${user}</li>
    </c:forEach>
  </ul>
  <h1 style="color: orangered">ff</h1>
  </body>
</html>
