<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/30
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${not empty param.lang}">
    <fmt:setLocale value="${param.lang}"/>
</c:if>
<fmt:setBundle basename="languages.i18n"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><fmt:message key="title"></fmt:message></title>

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
<%
request.setAttribute("date", new Date());
%>
<fmt:message key="tip">
    <fmt:param>
        <fmt:formatDate value="${date}" dateStyle="full"/>
    </fmt:param>
    <fmt:param>
        <fmt:formatNumber value="5123412.53"/>
    </fmt:param>
</fmt:message>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><fmt:message key="title"/></a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#"><fmt:message key="home"/></a></li>
                <li><a href="#about"><fmt:message key="about"/></a></li>
                <li><a href="#contact"><fmt:message key="contact"/></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <jsp:include page="${param.content}"/>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>