## listener -> 监听器
> 其提供了系列监听器 -> 触发后的回调函数中进行相关操作即可

### 使用
> 1. web.xml中添加监听器
```xml
<!-- 监听器 -->
<listener>
  <listener-class>com.tt.listener.OnlineCountListener</listener-class>
</listener>
```

> 2. 监听器类
```java
package com.tt.listener;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 类实现相关监听器接口
public class OnlineCountListener implements HttpSessionListener {
  // 创建session监听：创建session会触发此事件
  @Override
  public void sessionCreated(HttpSessionEvent se) {
    ServletContext servletContext = se.getSession().getServletContext();
    Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

    if(onlineCount == null) {
      onlineCount = new Integer(1);
    }else {
      int count = onlineCount.intValue();
      onlineCount = new Integer(count+1);
    }
    servletContext.setAttribute("OnlineCount",onlineCount);
  }

  // 销毁session监听：销毁session会触发此事件
  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    ServletContext servletContext = se.getSession().getServletContext();
    Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

    if(onlineCount == null) {
      onlineCount = new Integer(0);
    }else {
      int count = onlineCount.intValue();
      onlineCount = new Integer(count-1);
    }
    servletContext.setAttribute("OnlineCount",onlineCount);
  }
}
```