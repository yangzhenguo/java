<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/26
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EL</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        body {
            padding: 15px;
        }

        hr {
            border-color: #999;
        }
    </style>
</head>
<body>
<table border="1" width="100%" style="border-collapse: collapse;">
<c:forEach var="entry" items="${header}">
    <tr style="height: 32px; line-height: 32px;">
        <td width="300" style="text-align: center;">${entry.key}</td>
        <td style="padding-left: 20px;">${entry.value}</td>
    </tr>
</c:forEach>
</table>
<hr style="margin: 20px 0;">
<table border="1" width="100%" style="border-collapse: collapse;">
<c:forEach var="entry" items="${headerValues}">
    <tr style="height: 32px; line-height: 32px;">
        <td width="300" style="text-align: center;">${entry.key}</td>
        <td style="padding-left: 20px;">${entry.value[0]}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
