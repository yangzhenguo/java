<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>List</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 50px;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: center;
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
<s:url value="/employee/input" var="inputUrl"/>
<div class="container">
    <div class="table-responsive">
        <legend>List <a href="${inputUrl}" class="btn btn-default btn-xs">Create</a></legend>
        <table class="table table-bordered table-hover table-striped">
            <thead>
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>Birthday</th>
                <th>Sex</th>
                <th>State</th>
                <th>Operation</th>
            </tr>
            </thead>
            <tbody>
            ${pageContext.request.locale}
            ${pageContext.response.locale}
            <c:forEach items="${employees}" var="emp">
                <tr>
                    <td>${emp.username}</td>
                    <td>${emp.name}</td>
                    <td>${emp.email}</td>
                    <td>${emp.telephone}</td>
                    <td>
                        <fmt:formatDate pattern="yyyy-MM-dd" value="${emp.birthday}" timeZone="GMT+8"/>
                    </td>
                    <td>
                        <s:eval var="sex" expression="T(com.yangzg.crud.constant.EmployeeConstant.SEX).which(emp.sex).label"/>
                        <fmt:message key="${sex}"/>
                    </td>
                    <td>
                        <s:eval var="state" expression="T(com.yangzg.crud.constant.EmployeeConstant.STATE).which(emp.state).label"/>
                        <fmt:message key="${state}"/>
                    </td>
                    <td>
                        <s:url var="infoUrl" value="/employee/info/${emp.uid}"/>
                        <a href="${infoUrl}">查看</a>
                        <s:url var="editUrl" value="/employee/edit/${emp.uid}"/>
                        <a href="${editUrl}">编辑</a>
                        <s:url var="deleteUrl" value="/employee/${emp.uid}"/>
                        <a href="${deleteUrl}" class="delete">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/static/assets/js/employee-list.js"></script>
</body>
</html>
