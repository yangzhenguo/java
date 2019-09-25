<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/25
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("count", 1);
%>
${param.age + 100}<br>
${paramValues.age[1]}<br>
${initParam}<br>
${"" + count + "1"}<br>
${cookie.JSESSIONID.version}<br>
${header}<br>
${header["accept-language"]}<br>
${initParam}<br>
${empty ""}
</body>
</html>
