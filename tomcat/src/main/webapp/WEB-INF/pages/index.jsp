<%@ page import="com.yangzg.model.Person" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.IntStream" %>
<%@ page import="java.util.ArrayList" %>
<%@page trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h3><%=new Person(12, "yzg")%></h3>
    <p><%
        List<Person> list = new ArrayList<Person>(){
            private static final long serialVersionUID = 8319153374159392936L;

            {
            for (int i = 0; i < 10; i++) {
                add(new Person((int) (Math.random() * 100), "yzg"));
            }
        }};
    %></p>
    <p>${json}</p>
</body>
</html>