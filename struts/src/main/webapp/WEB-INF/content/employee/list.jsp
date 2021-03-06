<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/10/21
  Time: 6:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>雇员列表</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 50px;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: inherit;
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
                <li class="active"><a href="#"><s:text name="home"/></a></li>
                <li><a href="#about"><s:text name="about"/></a></li>
                <li><a href="#contact"><s:text name="contact"/></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <div class="starter-template">
        <legend>雇员列表</legend>
        <p><s:a action="add" class="btn btn-primary">新建</s:a></p>
        <table class="table table-striped table-hover table-bordered">
            <thead>
            <tr>
                <th>编号</th>
                <th>名</th>
                <th>姓</th>
                <th>年龄</th>
                <th>生日</th>
                <th>Email</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="#request.employees">
                <tr>
                    <td>${id}</td>
                    <td>${firstName}</td>
                    <td>${lastName}</td>
                    <td>${age}</td>
                    <td>
                        <fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>${email}</td>
                    <td width="200" class="text-center">
                        <s:url action="delete" namespace="/employee" var="deleteUrl">
                            <s:param name="id" value="id"/>
                        </s:url>
                            <s:a class="btn btn-xs btn-default" value="%{deleteUrl}">Delete</s:a>
                        <s:url action="edit" var="editUrl">
                            <s:param name="id" value="id"/>
                        </s:url>
                            <s:a class="btn btn-xs btn-default" value="%{editUrl}" style="margin-left: 10px;">Edit</s:a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
