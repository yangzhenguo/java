<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/21
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Employee Input</title>
</head>
<body>
<s:form action="/employee/submit">
    <s:textfield name="name" label="Name"/>
    <s:password name="password" label="Password"/>
    <s:radio list="#{'0': 'Female', '1': 'Male'}" name="gender" label="Gender"/>
    <s:select list="#request.departments" listKey="id" listValue="name" name="department" label="Department"/>
    <s:checkboxlist list="#request.roles" listKey="id" listValue="name" name="roles" label="Role"/>
    <s:textarea name="desc" label="Desc"/>
    <s:submit/>
</s:form>
</body>
</html>
