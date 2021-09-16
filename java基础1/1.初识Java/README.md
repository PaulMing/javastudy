## 初识Java
> 聚焦：开发环境搭建

### 基本概念
> JVM[Java Virtual Machine]: Java虚拟机，将源代码文件编译为字节码文件
> JRE[Java Runtime Environment]: Java运行环境，运行java程序 -> 显然其内部包含JVM，因为运行前必然需要编译
> JDK[Java Development Kit]: Java开发工具，开发人员使用的工具[编译工具javac.exe、开发工具java.exe] -> 显然其内部包含JVM、JRE

### 开发环境搭建
> 1. 安装JDK
> 官网：https://www.oracle.com/java/technologies/javase-downloads.html
> 本地安装路径：C:\Program Files\Java

> 2. 运行java程序
> [1].编译阶段：javac xx.java -> java编译工具双击时是黑色对话框，一闪而过，其需要在doc命令行窗口使用：打开命令行窗口，进入到源文件目录路径下，但是源文件和javac.exe要在同目录下才可以，否则也不能执行，因为本质就是执行javac命令，解决方案：1.拷贝javac.exe到源文件目录下[软连接]，若涉及到有很多不同目录下的源文件，那么就需要拷贝多次，其也会占据硬盘空间; 2.配置环境变量：本质就是配置javac.exe的目录路径，之后在源文件目录下打开命令行窗口时执行javac xxx.java时，其会首先在当前目录下查找javac.exc,若没有则从环境变量中查找，环境变量等同于提供了'公共存储路径区，便于查找，而且还节省空间'
> 配置环境变量：我的电脑 -> 右键点击属性 -> 点击环境变量，即可进行配置
>     Path: javac.exe编译工具的位置,让该工具可在任何位置均可被使用
>     classPath: 生成的class字节码文件放置的目录
>     JAVA_HOME：配置后，配置path/classPath的时候可直接使用JAVA_HOME,本质就是一种简写
>     -> 实际windows系统需要配置，Mac无需配置，而且最新版JDK下载，windows系统也无需手动配置环境变量，JDK已经配置完成，开发者直接安装JDK即可
> [2].执行阶段：源文件xx.java -> 编译javac xx.java 生成 xx.class字节码文件 -> java xx 执行即可