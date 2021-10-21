## tomcat -> Apache基金会下开源项目
> 其是由Apache、Sun和其它公司以及个人共同开发而成，因为Sun的参与，tomcat总能很好支持servlet、jsp -> 实际其就是'服务器'，提供配置文件进行'配置化操作'，并不关心静态or动态web，涉及到动态web技术配置servlet即可

### 环境搭建
> 1. 官网下载解压缩即可：https://tomcat.apache.org
![](assets/环境搭建/下载.png)

> 2. 目录结构
![](assets/环境搭建/目录结构.png)

> 3. 启动/关闭
> 启动：双击'bin/startup.bat',之后会运行'命令行窗口'，其就是整个服务器运行情况
> 关闭：双击'bin/stutdown.bat' -> 或者直接关闭'命令行窗口'即可
![](assets/环境搭建/启动关闭.png)

> 4. web项目配置及存放位置
> 本质：请求打到服务器上获取资源 -> 需要配置请求地址、端口、资源存放位置[其提供默认配置，用户可灵活修改]
![](assets/环境搭建/配置文件.png)
![](assets/环境搭建/web项目.png)

> 目录参考：
+ webapps                # tomcat设置的web目录
  - ROOT                 # localhost:8080默认读取的资源目录
  - testPro              # 自定义web项目名
    - WEB-INF            # 项目整体配置，此处可写java程序[完成动静分离，静态直接返回index.html，动态使用接口处理]
      - classes          # java程序
      - lib              # 依赖的jar包
      - web.xml          # 网站配置文件
    - index.html         # 默认首页 -> index.jsp或者其它tomcat支持的文件格式均可
    - static             # 静态资源
      - js
      - css
      - img
    - ....               # 其它

### IDEA中配置tomcat
> 最新版IDEA需手动添加tomcat插件，旧版IDEA内置tomcat插件，开发者可忽略第1步，直接进行第2步的配置即可
> 1. 添加tomcat插件
![](assets/idea配置tomcat/安装插件step1.png)
![](assets/idea配置tomcat/安装插件step2.png)
> 2. 配置tomcat
![](assets/idea配置tomcat/配置step1.png)
![](assets/idea配置tomcat/配置step2.png)
![](assets/idea配置tomcat/配置step3.png)