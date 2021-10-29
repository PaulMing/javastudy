<html>
<body>
<h2>Hello World!</h2>

<%--
   jsp表达式:
      <%= 变量/表达式 %>                直接输出到客户端
      <% java代码 %>
      <%! 属性/方法/变量 %>             后续可使用该属性/方法/变量
      <%-- 注释 --%>                   JSP注释不会在客户端显示，HTML注释会
      <%@include file='common/header.jsp'%> 引用公用jsp
--%>
<%= new java.util.Date() %>

<%
    int sum = 0;
    for(int i=1; i<=100; i++) {
        sum+=i;
    }
    out.println("");
%>


<%
    for(int i=1; i<=5; i++) {
%>
    <h1>HelloWorld</h1>
<%
    }
%>

<%
    for(int i=1; i<=5; i++) {
%>
    <h1>HelloWorld <%= i %></h1>
<%
    }
%>
</body>
</html>