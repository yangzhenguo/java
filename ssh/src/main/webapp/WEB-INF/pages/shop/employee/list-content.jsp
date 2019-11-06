<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/11/5
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <s:a namespace="/shop/employee" class="btn btn-primary" action="create">新建</s:a>
</p>
<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>创建日期</th>
        <th>部门</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="#request.employees">
        <tr>
            <td>${id}</td>
            <td>${name}</td>
            <td>${createTime}</td>
            <td>${department.name}</td>
            <td class="text-center">
                <s:a class="btn btn-default btn-xs" namespace="/shop/employee" action="edit">
                    <s:param name="id" value="id"/>
                    修改
                </s:a>
                <s:a class="btn btn-default btn-xs" namespace="/shop/employee" action="delete" style="margin-left: 20px;">
                    <s:param name="id" value="id"/>
                    删除
                </s:a>
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>
