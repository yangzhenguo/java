<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/24
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" session="false" trimDirectiveWhitespaces="true" %>
<form action="${pageContext.request.contextPath}/book/step2" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <legend>填写地址</legend>
    </div>

    <fieldset name="基本信息">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name" placeholder="姓名">
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">地址</label>
            <div class="col-sm-10">
                <input type="text" name="address" class="form-control" id="address" placeholder="地址">
            </div>
        </div>
    </fieldset>

    <div class="form-group">
        <label class="col-sm-2 control-label">卡种</label>
        <div class="col-sm-10">
            <label class="radio-inline">
                <input type="radio" name="cardType" id="visa" value="visa" checked="checked">
                Visa
            </label>
            <label class="radio-inline">
                <input type="radio" name="cardType" id="Master" value="master">
                Master
            </label>
        </div>
    </div>

    <div class="form-group">
        <label for="card" class="col-sm-2 control-label">No.</label>
        <div class="col-sm-10">
            <input type="number" name="card" class="form-control" id="card" placeholder="卡号">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </div>
</form>