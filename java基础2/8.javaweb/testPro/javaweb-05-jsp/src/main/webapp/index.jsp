<html>
<body>
<h2>Hello World!</h2>


<%-- jsp表达式:
    <%= 变量/表达式 %>  用来将程序的输出，输出到客户端
    <% jsp脚本片段 %>
 --%>
<%= new java.util.Date() %>



<% ---

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

<hr>


<%!



%>





</body>
</html>
