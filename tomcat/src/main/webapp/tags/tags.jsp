<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2019/9/26
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.yangzg.model.book.Customer" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="hiyzg" uri="/WEB-INF/hiyzg.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<br>
<%
    final TreeMap<String, String> headers = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String first, String last) {
            return first.compareTo(last);
        }
    });
    final Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
        final String key = headerNames.nextElement();
        headers.put(key, request.getHeader(key));
    }
    pageContext.setAttribute("headers", headers);
%>

<table style="border-collapse: collapse;" border="1">
    <c:forEach var="entry" items="${headers}">
        <tr>
            <td style="width: 200px;">${entry.key}</td>
            <td style="width: 50px; text-align: center;">${fn:length(entry.key)}</td>
            <td>${entry.value}</td>
            <td style="width: 50px; text-align: center;">${fn:length(entry.value)}</td>
        </tr>
    </c:forEach>
</table>
${fn:length(header['accept-language'])}<br>
${hiyzg:now("GMT+2")}<br>
${fn:escapeXml("<h1>hahaa</h1>")}
</body>
</html>
