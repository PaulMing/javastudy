## jsp -> java server pages
> 背景：前后端未分离的时代ajax还没有诞生，html仅仅是纯静态网页，但用户需要动态页面，JSP就是在html中嵌入java程序为用户动态提供数据[html是静态的，java程序可灵活操作数据库获取动态数据从而实现动态网页]
> 本质：JSP也是servlet程序，JSP中写的内容最终都会装填到'servlet程序模板'中然后发送给客户端，这也是为什么JSP中可以使用java的预定义对象、变量等的原因 -> jsp写法繁琐[但其的功能很全面，涉及到网页技术都能实现，要不然也不能在某个时代留下很重的印记]，后来出现了模板引擎优化jsp，但随着前端技术的发展[AJAX]，后端不再需要实现动态网页，而聚集在接口的定义与实现，jsp基本废弃，了解即可

> javaweb：所有请求首先都会打到servlet容器中，即使localhost:8080/，实际默认读取/index.jsp，但index.jsp也是servlet程序，涉及到jsp相关不用在web.xml中显示配置servlet容器，其它不可省略，这些仅仅是'语法层面'简写而已，本质依旧是servlet容器

### 基础语法
```jsp
  <%= 变量/表达式 %>     直接输出到客户端
  <% java代码 %>
  <%! 属性/方法/变量 %>  后续可使用该属性/方法/变量
  <%-- 注释 --%>        JSP注释不会在客户端显示，HTML注释会
  <%@include file='common/header.jsp'%> 引用公用jsp
```