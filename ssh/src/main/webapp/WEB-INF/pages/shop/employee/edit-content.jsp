<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/11/5
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:form theme="simple" namespace="/shop/employee" action="editSubmit" method="post" class="form-horizontal" role="form">
    <s:hidden name="id"/>
    <div class="form-group">
        <legend>修改</legend>
    </div>

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">名称</label>
        <div class="col-sm-10">
            <s:textfield class="form-control" id="name" name="name" placeholder="名称"/>
        </div>
    </div>

    <div class="form-group">
        <label for="department" class="col-sm-2 control-label">部门</label>
        <div class="col-sm-10">
            <s:select id="department" value="department.id" name="department.id" class="form-control" list="#request.departments" listKey="id" listValue="name"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </div>
</s:form>
