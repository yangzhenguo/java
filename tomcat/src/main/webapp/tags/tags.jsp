<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/26
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yangzg.model.book.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="hiyzg" uri="/WEB-INF/hiyzg.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tags</title>
</head>
<body>
<%
request.setAttribute("customer", new ArrayList<Customer>(){
    private static final long serialVersionUID = 1L;

    {
        add(new Customer("yzg", "beijing", "visa", "235134222"));
        add(new Customer("yzg1", "beijing1", "visa", "235134222"));
        add(new Customer("yzg2", "beijing2", "visa", "235134222"));
        add(new Customer("yzg3", "beijing3", "visa", "235134222"));
        add(new Customer("yzg4", "beijing4", "visa", "235134222"));
    }
});

request.setAttribute("num1", Math.random());
request.setAttribute("num2", Math.random());
%>
<hiyzg:hello times="${param.count}">${param.text}</hiyzg:hello><br/>
num1=${num1}, num2=${num2}, and max=<hiyzg:max num1="${num1}" num2="${num2}"/>
<pre>
<hiyzg:readFile file="/Users/Sam/work/java/java/tomcat/src/main/webapp/tags/tags.jsp"/>
</pre>
</body>
</html>
