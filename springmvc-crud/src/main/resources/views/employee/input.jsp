<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 50px;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <form:form action="/employee" method="post" cssClass="form-horizontal" modelAttribute="employee">
        <legend>Create</legend>
        <form:input type="hidden" path="uid"/>

        <c:if test="${not empty employee.uid}">
            <input type="hidden" name="_method" value="PUT" />
        </c:if>

        <spring:bind path="username">
            ${status.error}
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label for="username" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <form:input path="username" type="text" class="form-control" id="username" placeholder="Username"/>
                <form:errors path="username" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>

        <spring:bind path="name">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <form:input path="name" type="text" class="form-control" id="name" placeholder="name"/>
                <form:errors path="name" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>

        <spring:bind path="email">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input path="email" type="text" class="form-control" id="email" placeholder="email"/>
                <form:errors path="email" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>


        <spring:bind path="telephone">
        <div class="form-group">
            <label for="telephone" class="col-sm-2 control-label">Telephone</label>
            <div class="col-sm-10">
                <form:input path="telephone" type="text" class="form-control" id="telephone" placeholder="telephone"/>
                <form:errors path="telephone" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>

        <spring:bind path="birthday">
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">Birthday</label>
            <div class="col-sm-10">
                <form:input path="birthday" type="date" class="form-control" id="birthday" placeholder="birthday"/>
                <form:errors path="birthday" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>

        <spring:bind path="sex">
        <div class="form-group">
            <label class="col-sm-2 control-label">Sex</label>
            <div class="col-sm-10">
                <spring:eval expression="{0: '女', 1: '男'}" var="sexes"/>
                <c:forEach items="${sexes}" var="sex">
                    <label class="radio-inline">
                        <form:radiobutton path="sex" value="${sex.key}"/>${sex.value}
                    </label>
                </c:forEach>
                <form:errors path="sex" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>

        <spring:bind path="state">
        <div class="form-group">
            <label class="col-sm-2 control-label">State</label>
            <div class="col-sm-10">
                <label class="checkbox-inline">
                    <form:checkbox path="state" />启用
                </label>
                <form:errors path="state" cssClass="help-block"/>
            </div>
        </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </form:form>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
