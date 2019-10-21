<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/21
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>提交</title>
</head>
<body>
<s:form action="/user/submit">
    <s:hidden name="userId"/>
    <s:textfield name="username" label="UserName" autocomplete="no"/>
    <s:password name="password" label="Password"/>
    <s:textarea name="desc" label="Desc"/>
    <s:checkbox name="married" label="Married"/>
    <s:submit/>
</s:form>
<s:debug/>
</body>
</html>
