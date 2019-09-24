<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/24
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<form action="${pageContext.request.contextPath}/book/step1" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <legend>选择图书</legend>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Java</label>
        <div class="col-sm-10">
            <div class="checkbox">
                <label>
                    <input name="book" value="java" type="checkbox">选择
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Oracle</label>
        <div class="col-sm-10">
            <div class="checkbox">
                <label>
                    <input name="book" value="oracle" type="checkbox">选择
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Struts</label>
        <div class="col-sm-10">
            <div class="checkbox">
                <label>
                    <input name="book" value="struts" type="checkbox">选择
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="submit" class="btn btn-primary">下一步</button>
        </div>
    </div>
</form>