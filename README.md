Demo地址： http://47.111.146.215:8080/MyBelfast/

# 项目说明

个人web开发练习新技术的项目,目前使用vue+Spring全家桶.

使用不同的框架会用不同的branch分开

# 已有功能

1. 登录注册,简单的会话管理
2. 基于爬虫实现的新闻看点
3. 管理系统最常见实现之用户管理(admin特有)

# 部署手册

本小节说明如何部署至各类云服务器并运行本项目，所有指令仅针对linux系统，win下可能需要做一定的修改

## 1 准备war包

可以直接下载war/MyBelfast1.0.war

或者自己从源代码构建新的war包,步骤如下：

1. git clone

2. 导入本项目到您本地的IDE工具中，推荐IDEA

3. 使用IDE工具重新编译并构建新的war包

由于本项目前端开发使用的是vue单文件组件开发，webpack打包，故如果想更改前端内容，
请单独将web/vue目录复制到其他位置，并作如下操作进行前端内容的开发：

1. 安装vue单文件组件开发环境，node，npm等，具体请见官网

2. 在vue根目录下，执行`npm install`，下载相关依赖

3. 根据你的喜欢对vue前端页面进行修改

4. 修改完毕后，使用`npm run serve`，会在localhost:8089端口启动一个node测试服务器，查看自己修改的效果

5. 觉得修改的没问题后，使用`npm run build`，会在vue根目录得到一个dist目录，将其内容全部复制到web目录下即可

6. 回到之前的第三步，使用IDE工具重新构建新的war包

## 2 准备web服务器

你可以使用你自己喜欢的web服务器来运行本项目，那么作为个人测试最方便来看，我们依旧请出我们熟悉的tomcat作为web服务器

1. 从官网下载zip包，并解压即可使用tomcat

2. 可根据自己喜欢建立Catalina_BASE目录

3. 将war包放入$Catalina_HOME/webapps或者$Catalina_BASE/webapps

4. 为了后续上传云服务器方便，我们将$Catalina_HOME全部压缩为一个zip包`tomcat.zip`

如果你想立即测试下tomcat功能是否正常，可以按如下步骤操作

1. 进入$Catalina_HOME/bin

2. 执行`./catalina.sh run`

3. 打开浏览器，输入`localhost:8080/MyBelfast`，一切正常的话，应该已经可以看到网站首页了

## 3 准备一台云服务器

1. 推荐从阿里云购买一台配置最低的轻量级应用服务器

2. 节点选择离自己最近的位置

3. 系统镜像推荐选择CentOS，不过我为了和本地开发环境一致防止出现一些小问题，选择的是Ubuntu18.04

购买完成后，我们必须做一些基本的配置

1. 设置root密码或者密钥

2. 使用ssh工具测试是否能连接

3. 添加防火墙设置，将8080端口放行

## 4 登录我们的云服务器并上传必要文件

1. 执行`ssh root@云服务器公网ip地址`登录我们的云服务器终端

2. 在当前用户home目录下，在我的案例中目录为/root/tomcat

3. 执行`scp tomcat.zip root@云服务器公网ip地址:/root/tomcat`，将我们的tomcat以及war包文件传至此目录下

4. 解压缩tomcat.zip

## 5 安装jdk或者jre

如果你比较懒！那么请和我一样使用apt安装java，它会帮我们自动完成java_home等一些环境变量的创建

1. 执行`ssh root@云服务器公网ip地址`登录我们的云服务器终端

2. 执行`sudo apt update`，将更新apt，若不更新可能会在安装java包的时候出错

3. 执行`sudo apt install openjdk-8-jdk`，由于java8后都是收费的，为了减少不必要的麻烦，我们安装openjdk即可，目前来看两者没有什么区别

## 6 mysql环境部署

mysql环境部署

1. 安装mysql8.x
https://zazalu.space/2019/06/14/ubuntu18-04%E5%AE%89%E8%A3%85mysql8-0-16-Community/

2. 创建一个zazalu的mysql用户，由于我的数据库配置中使用了zazalu用户进行登录，所以需要创建一个叫zazalu的用户

```
1) 先使用root账户进行登录 
mysql -u root -p 

2) 在mysql交互界面使用如下面指令创建zazalu用户，并给予它所有权限
create user 'zazalu'@'localhost' identified by '!密码!'
GRANT ALL ON *.* TO 'zazalu'@'localhost';

```

3. 依次执行/src/resource/sql/下的MyBelfast.sql和new.sql，这两个sql是本项目能正常运行的最基础数据
```
在mysql控制台执行
mysql>source /path/MyBelfast.sql
```

## 7 启动tomcat并通过外网访问

我们已经做完了所有在云服务器上启动项目的前提操作，现在让我们开心的上线我们的项目吧！

1. 执行`ssh root@云服务器公网ip地址`登录我们的云服务器终端

2. 进入$Catalina_HOME/bin，执行`./catalina.sh run`

3. 打开浏览器，访问`http://云服务器ip:8080/MyBelfast`

**[注意]**：如果发现Tomcat启动较慢的话，请观察是否是tomcat启动使用java.se创建SessionID过慢导致的,
如果是的话，请参考本博客进行解决
https://my.oschina.net/handsomejun/blog/708165
