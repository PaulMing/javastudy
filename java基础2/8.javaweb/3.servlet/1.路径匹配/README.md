## 路径匹配
> Tomcat服务器中配置的servlet容器映射关系：路径与对应的java处理程序 -> 默认路径读取index.jsp[等同于/index.jsp,省略了index.jsp，其它也可以/success.jsp等]，其它路径会根据servlet配置的映射关系进行处理

```xml
<!-- web.xml配置servlet映射关系 -->
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaeehttp://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="true">

  <!-- 配置web应用初始化参数 -->
  <context-param>
    <param-name>url</param-name>
    <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
  </context-param>

  <!--
    servlet容器：
      1.其是完全匹配：例如/hello 与/*
        /hello： 仅匹配/hello
        /* : 除了/hello的其它，常用于兜底[请求路径出错404对应的处理程序] -> 大多作为默认请求路径，其比默认配置优先级高，例如/默认匹配index.jsp，写了/*则优先匹配/*所指的servlet

      2. 自定义后缀：*.xx -> *部分不要出现项目相关的映射路径 /xx/a.xx
  -->
  <servlet>
    <servlet-name>helloServlet</servlet-name>
    <servlet-class>com.tt.servlet.HelloServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>helloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
  <servlet>
    <servlet-name>ErrorServlet</servlet-name>
    <servlet-class>com.tt.servlet.ErrorServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>ErrorServlet</servlet-name>
    <url-pattern>/*</url-pattern>
  </servlet-mapping>
</web-app>
```